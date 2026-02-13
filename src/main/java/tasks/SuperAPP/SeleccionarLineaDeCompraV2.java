package tasks.SuperAPP;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.*;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.RefreshMiClaroModule;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Task mejorado para seleccionar línea de compra en Super App Mi Claro
 * con manejo robusto de pantalla en blanco en el módulo Recargas y Paquetes.
 * <p>
 * Mejoras implementadas:
 * - Detección automática de pantalla en blanco
 * - Múltiples estrategias de refresh (Pull-to-refresh, navegación, recarga forzada)
 * - Validación de carga exitosa del módulo
 * - Reintentos inteligentes
 *
 * @author Alejandra
 * @version 2.0 - Con manejo de pantalla en blanco
 */
public class SeleccionarLineaDeCompraV2 extends AndroidObject implements Task {

    private final User user = utils.TestDataProvider.getRealUser();

    private final int maxIntentosAcceso = 3;


    @Override
    public <T extends Actor> void performAs(T actor) {

        // ✅ Intentar acceder al módulo con reintentos
        boolean accesoExitoso = false;
        int intentoActual = 0;

        while (!accesoExitoso && intentoActual < maxIntentosAcceso) {
            intentoActual++;
            System.out.println("🔄 Intento " + intentoActual + " de acceso al módulo Recargas y Paquetes");

            try {
                accederAlModuloRecargasYPaquetes(actor);
                accesoExitoso = true;
                System.out.println("✅ Acceso exitoso al módulo en intento " + intentoActual);
            } catch (Exception e) {
                System.out.println("⚠️ Error en intento " + intentoActual + ": " + e.getMessage());

                if (intentoActual < maxIntentosAcceso) {
                    // Aplicar estrategia de recuperación antes del siguiente intento
                    aplicarEstrategiaDeRecuperacion(actor, intentoActual);
                } else {
                    throw new RuntimeException("❌ No se pudo acceder al módulo después de " + maxIntentosAcceso + " intentos", e);
                }
            }
        }

        // Continuar con el flujo normal
        seleccionarLineaPrepago(actor);
        validarMiniVersion(actor);
        ingresarAPaquetes(actor);
    }

    /**
     * Accede al módulo de Recargas y Paquetes con validación de carga
     */
    private <T extends Actor> void accederAlModuloRecargasYPaquetes(T actor) {
        System.out.println("📱 Accediendo al módulo Recargas y Paquetes...");

        actor.attemptsTo(
                //ClickElementByText.clickElementByText(RECARGA_COMPRA_PAQUETE),
                WaitFor.aTime(3000)  // Espera inicial para permitir carga
        );

        // 🔍 Detectar si la pantalla quedó en blanco
        if (moduloEnPantallaBlanca(actor)) {
            System.out.println("⚠️ Pantalla en blanco detectada - Aplicando refresh...");
            actor.attemptsTo(RefreshMiClaroModule.ifNeeded());
        }

        // ✅ Validar que el módulo cargó correctamente
        actor.attemptsTo(
                WaitUntil.the(LBL_COMPRA_PAQUETES_RECARGAS2, isVisible())
                        .forNoMoreThan(10).seconds(),
                WaitForResponse.withText(COMPRA_PAQUETES_RECARGAS)
        );

        System.out.println("✅ Módulo Recargas y Paquetes cargado correctamente");
    }

    /**
     * Detecta si el módulo está en pantalla blanca
     */
    private <T extends Actor> boolean moduloEnPantallaBlanca(T actor) {
        try {
            // Verificar si no hay contenido visible característico del módulo
            boolean sinTitulo = Presence.of(LBL_COMPRA_PAQUETES_RECARGAS2)
                    .viewedBy(actor)
                    .resolveAll()
                    .isEmpty();

            boolean sinBotones = Presence.of(BTN_TRES_PUNTOS_MAS)
                    .viewedBy(actor)
                    .resolveAll()
                    .isEmpty();

            return sinTitulo && sinBotones;

        } catch (Exception e) {
            System.out.println("⚠️ Error detectando pantalla blanca: " + e.getMessage());
            return true; // Asumir pantalla en blanco en caso de error
        }
    }

    /**
     * Aplica diferentes estrategias de recuperación según el número de intento
     */
    private <T extends Actor> void aplicarEstrategiaDeRecuperacion(T actor, int numeroIntento) {
        System.out.println("🔧 Aplicando estrategia de recuperación #" + numeroIntento);

        switch (numeroIntento) {
            case 1:
                // Primer intento: Pull-to-refresh simple
                actor.attemptsTo(
                        RefreshMiClaroModule.forcePullToRefresh(),
                        WaitFor.aTime(2000)
                );
                break;

            case 2:
                // Segundo intento: Volver atrás y reentrar
                actor.attemptsTo(
                        RefreshMiClaroModule.backAndReenter(),
                        WaitFor.aTime(3000)
                );
                break;

            case 3:
                // Tercer intento: Recarga forzada de la app
                actor.attemptsTo(
                        RefreshMiClaroModule.forceReload(),
                        WaitFor.aTime(4000)
                );
                break;

            default:
                System.out.println("⚠️ Sin estrategia adicional para intento " + numeroIntento);
        }
    }

    /**
     * Selecciona la línea prepago y el número específico
     */
    private <T extends Actor> void seleccionarLineaPrepago(T actor) {
        System.out.println("📞 Seleccionando línea prepago: " + user.getNumero());

        actor.attemptsTo(
                ClickElementByText.clickElementByText(PREPAGO)
        );

        scrollCorto2(actor, LINEA_SA + " " + user.getNumero() + " " + ELEGIR);
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene(user.getNumero()),
                WaitForResponse.withText(COMPRA_PAQUETES_RECARGAS)
        );

        theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateInformationText.validateInformationText(LBL_COMPRA_PAQUETES_RECARGAS2),
                                equalTo(COMPRA_PAQUETES_RECARGAS))
                );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        System.out.println("✅ Línea seleccionada correctamente");
    }

    /**
     * Valida la mini versión de la app
     */
    private <T extends Actor> void validarMiniVersion(T actor) {
        System.out.println("🔍 Validando mini versión de la app...");

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitForResponse.withText(RECARGAS_Y_PAQUETES),
                ValidarTexto.validarTexto(RECARGAS_Y_PAQUETES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VERSION)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        System.out.println("✅ Mini versión validada");
    }

    /**
     * Ingresa a la sección de Paquetes
     */
    private <T extends Actor> void ingresarAPaquetes(T actor) {
        System.out.println("📦 Ingresando a Paquetes...");

        actor.attemptsTo(
                Atras.irAtras(),
                ClickElementByText.clickElementByText(PAQUETES),
                WaitForResponse.withText(ELIGE_TIPO_PAQUETE),
                ValidarTextoQueContengaX.elTextoContiene(user.getNumero())
        );

        // Seleccionar el tipo de paquete a comprar
        actor.attemptsTo(
                WaitElement.isClickable(CBX_TIPO_PAQUETE),
                Click.on(CBX_TIPO_PAQUETE),
                WaitForResponse.withText(TIPO_PAQUETE)
        );

        System.out.println("✅ Ingreso a Paquetes completado");
    }

    public static Performable seleccionarLineaDeCompra() {
        return instrumented(SeleccionarLineaDeCompraV2.class);
    }
}