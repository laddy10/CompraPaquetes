package tasks;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToMobile implements Task {

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    private final String appPackage;
    private final String appActivity;

    public SwitchToMobile(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            try {
                if (Serenity.getWebdriverManager().getCurrentDriver() != null) {
                    Serenity.getWebdriverManager().getCurrentDriver().quit();
                    Thread.sleep(1500);
                }
            } catch (Exception ignored) {}

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("autoGrantPermissions", true);
            capabilities.setCapability("fullReset", false);
            capabilities.setCapability("autoDismissAlerts", "true");
            capabilities.setCapability("unicodeKeyboard", true);
            capabilities.setCapability("resetKeyboard", true);
            capabilities.setCapability("hideKeyboardOnStart", true);


            String hub = environmentVariables.getProperty("appium.hub", "http://127.0.0.1:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver(new URL(hub), capabilities);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            actor.whoCan(BrowseTheWeb.with(driver));

            System.out.println("📱 Cambio exitoso a: " + appPackage);

        } catch (Exception e) {
            throw new RuntimeException("Error al cambiar a app móvil: " + e.getMessage(), e);
        }
    }

    public static SwitchToMobile toApp(String appPackage, String appActivity) {
        return instrumented(SwitchToMobile.class, appPackage, appActivity);
    }
}
