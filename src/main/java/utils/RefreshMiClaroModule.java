package utils;

import interactions.comunes.Atras;
import interactions.comunes.ClickElementByText;
import io.appium.java_client.android.AndroidDriver;
import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.SegmentoPage.*;

/**
 * Interaction para refrescar el módulo de Mi Claro App cuando la pantalla queda en blanco.
 * <p>
 * Estrategias implementadas:
 * 1. Pull-to-refresh (deslizar hacia abajo)
 * 2. Navegación hacia atrás y volver a entrar
 * 3. Forzar cierre y reapertura de la app
 * 4. Reinicio de actividad de la app
 * <p>
 * Uso:
 * actor.attemptsTo(RefreshMiClaroModule.ifNeeded());
 * actor.attemptsTo(RefreshMiClaroModule.forcePullToRefresh());
 */
public class RefreshMiClaroModule implements Interaction {

    private final RefreshStrategy estrategia;
    private final int maxIntentos;
    private final boolean validarCarga;

    // Target para detectar pantalla en blanco
    private static final Target CUALQUIER_CONTENIDO = Target.the("Cualquier contenido visible")
            .located(By.xpath("//*[@text or @content-desc][string-length(normalize-space()) > 0]"));

    public enum RefreshStrategy {
        AUTO,              // Detecta automáticamente si es necesario refrescar
        PULL_TO_REFRESH,   // Deslizar hacia abajo
        BACK_AND_REENTER,  // Volver atrás y entrar de nuevo
        FORCE_RELOAD       // Forzar recarga completa
    }

    private RefreshMiClaroModule(RefreshStrategy estrategia, int maxIntentos, boolean validarCarga) {
        this.estrategia = estrategia;
        this.maxIntentos = maxIntentos;
        this.validarCarga = validarCarga;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (estrategia) {
            case AUTO:
                refrescarSiEsNecesario(actor);
                break;
            case PULL_TO_REFRESH:
                ejecutarPullToRefresh(actor);
                break;
            case BACK_AND_REENTER:
                volverAtrasYReentrar(actor);
                break;
            case FORCE_RELOAD:
                forzarRecarga(actor);
                break;
        }
    }

    /**
     * Detecta si la pantalla está en blanco y ejecuta refresh automático
     */
    private <T extends Actor> void refrescarSiEsNecesario(T actor) {
        int intentos = 0;

        while (intentos < maxIntentos) {
            if (pantallaTieneContenido(actor)) {
                System.out.println("✅ Pantalla con contenido detectada. No requiere refresh.");
                return;
            }

            System.out.println("⚠️ Pantalla en blanco detectada. Ejecutando refresh (Intento " + (intentos + 1) + "/" + maxIntentos + ")");

            // Probar estrategia 1: Pull-to-refresh
            if (intentos == 0) {
                ejecutarPullToRefresh(actor);
            }
            // Probar estrategia 2: Volver atrás y reentrar
            else if (intentos == 1) {
                volverAtrasYReentrar(actor);
            }
            // Probar estrategia 3: Forzar recarga
            else {
                forzarRecarga(actor);
            }

            actor.attemptsTo(WaitFor.aTime(2000));
            intentos++;
        }

        if (!pantallaTieneContenido(actor)) {
            System.out.println("❌ No se pudo refrescar el módulo después de " + maxIntentos + " intentos");
        }
    }

    /**
     * Estrategia 1: Pull-to-refresh (deslizar hacia abajo)
     */
    private <T extends Actor> void ejecutarPullToRefresh(T actor) {
        try {
            AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();

            int startX = width / 2;
            int startY = height / 3;
            int endY = (height * 2) / 3;

            System.out.println("🔄 Ejecutando Pull-to-Refresh...");

            // Realizar swipe hacia abajo (pull-to-refresh)
            io.appium.java_client.TouchAction<?> action = new io.appium.java_client.TouchAction<>(driver);
            action.press(io.appium.java_client.touch.offset.PointOption.point(startX, startY))
                    .waitAction(io.appium.java_client.touch.WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(io.appium.java_client.touch.offset.PointOption.point(startX, endY))
                    .release()
                    .perform();

            actor.attemptsTo(WaitFor.aTime(2000));
            System.out.println("✅ Pull-to-Refresh ejecutado");

        } catch (Exception e) {
            System.out.println("⚠️ Error en Pull-to-Refresh: " + e.getMessage());
        }
    }

    /**
     * Estrategia 2: Volver atrás y volver a entrar
     */
    private <T extends Actor> void volverAtrasYReentrar(T actor) {
        try {
            System.out.println("🔙 Volviendo atrás y reingresando al módulo...");

            // Presionar el botón back de Android
            actor.attemptsTo(Atras.irAtras());
            actor.attemptsTo(WaitFor.aTime(1500));

            // Volver a ingresar al módulo
            actor.attemptsTo(
                    ClickElementByText.clickElementByText("Recargas y paquetes"),
                    WaitFor.aTime(2000)
            );

            System.out.println("✅ Navegación atrás y reingreso completado");

        } catch (Exception e) {
            System.out.println("⚠️ Error al volver atrás: " + e.getMessage());
        }
    }

    /**
     * Estrategia 3: Forzar recarga completa (cerrar actividad y reabrir)
     */
    private <T extends Actor> void forzarRecarga(T actor) {
        try {
            System.out.println("🔄 Forzando recarga completa de la actividad...");

            AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

            // Detener y reiniciar la actividad actual
            driver.runAppInBackground(Duration.ofSeconds(1));

            actor.attemptsTo(WaitFor.aTime(3000));

            // Esperar a que la app vuelva a estar lista
            actor.attemptsTo(
                    WaitUntil.the(LOADING_SPLASH, isNotPresent()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()).forNoMoreThan(10).seconds(),
                    WaitFor.aTime(2000)
            );

            System.out.println("✅ Recarga forzada completada");

        } catch (Exception e) {
            System.out.println("⚠️ Error al forzar recarga: " + e.getMessage());
        }
    }

    /**
     * Verifica si la pantalla tiene contenido visible
     */
    private <T extends Actor> boolean pantallaTieneContenido(T actor) {
        try {
            // Esperar un breve momento para que cargue
            Thread.sleep(1000);

            // Verificar si hay elementos con texto visible
            boolean tieneContenido = !Presence.of(CUALQUIER_CONTENIDO)
                    .viewedBy(actor)
                    .resolveAll()
                    .isEmpty();

            // Verificar específicamente si se ve el loading
            boolean sinLoading = Presence.of(LOADING_ESPERA_UN_MOMENTO)
                    .viewedBy(actor)
                    .resolveAll()
                    .isEmpty();

            return tieneContenido && sinLoading;

        } catch (Exception e) {
            System.out.println("⚠️ Error verificando contenido: " + e.getMessage());
            return false;
        }
    }

    // ==================== MÉTODOS DE CONSTRUCCIÓN ====================

    /**
     * Refresca automáticamente solo si detecta pantalla en blanco
     * Uso: actor.attemptsTo(RefreshMiClaroModule.ifNeeded());
     */
    public static RefreshMiClaroModule ifNeeded() {
        return new RefreshMiClaroModule(RefreshStrategy.AUTO, 3, true);
    }

    /**
     * Fuerza un pull-to-refresh sin validaciones previas
     * Uso: actor.attemptsTo(RefreshMiClaroModule.forcePullToRefresh());
     */
    public static RefreshMiClaroModule forcePullToRefresh() {
        return new RefreshMiClaroModule(RefreshStrategy.PULL_TO_REFRESH, 1, false);
    }

    /**
     * Vuelve atrás y vuelve a entrar al módulo
     * Uso: actor.attemptsTo(RefreshMiClaroModule.backAndReenter());
     */
    public static RefreshMiClaroModule backAndReenter() {
        return new RefreshMiClaroModule(RefreshStrategy.BACK_AND_REENTER, 1, false);
    }

    /**
     * Fuerza recarga completa de la app
     * Uso: actor.attemptsTo(RefreshMiClaroModule.forceReload());
     */
    public static RefreshMiClaroModule forceReload() {
        return new RefreshMiClaroModule(RefreshStrategy.FORCE_RELOAD, 1, false);
    }

    /**
     * Configuración personalizada
     * Uso: actor.attemptsTo(RefreshMiClaroModule.withStrategy(AUTO, 5));
     */
    public static RefreshMiClaroModule withStrategy(RefreshStrategy estrategia, int maxIntentos) {
        return new RefreshMiClaroModule(estrategia, maxIntentos, true);
    }
}