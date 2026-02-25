package interactions.comunes;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TapLinea implements Interaction {


    private final String numero;

    public TapLinea(String numero) {
        this.numero = numero;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

        MobileElement elemento = (MobileElement) driver.findElement(
                By.xpath("//android.widget.Button[@text='Línea " + numero + " Elegir']")
        );

        elemento.click();
    }

    public static TapLinea conNumero(String numero) {
        return instrumented(TapLinea.class, numero);
    }
}
