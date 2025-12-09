package tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToWeb implements Task {

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String url;

    public SwitchToWeb(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Cerrar driver móvil si existe
            try {
                if (Serenity.getWebdriverManager().getCurrentDriver() != null) {
                    Serenity.getWebdriverManager().getCurrentDriver().quit();
                    Thread.sleep(1500);
                }
            } catch (Exception ignored) {
            }

            // Configurar Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navegar a la URL
            if (url != null && !url.isEmpty()) {
                driver.get(url);
            }

            actor.whoCan(BrowseTheWeb.with(driver));

            System.out.println("🌐 Cambio exitoso a contexto web");

        } catch (Exception e) {
            throw new RuntimeException("Error al cambiar a contexto web: " + e.getMessage(), e);
        }
    }

    public static SwitchToWeb toCmax(String url) {
        return instrumented(SwitchToWeb.class, url);
    }
}