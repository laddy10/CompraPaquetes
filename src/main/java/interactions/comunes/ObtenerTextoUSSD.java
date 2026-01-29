package interactions.comunes;

import net.serenitybdd.screenplay.Actor;

import static userinterfaces.USSDPage.MENSAJE_USSD_ANDROID;
import static userinterfaces.USSDPage.MENSAJE_USSD_PHONE;

public class ObtenerTextoUSSD {

    public static String obtener(Actor actor) {

        if (MENSAJE_USSD_ANDROID.resolveFor(actor).isPresent()) {
            return MENSAJE_USSD_ANDROID.resolveFor(actor).getText();
        }

        if (MENSAJE_USSD_PHONE.resolveFor(actor).isPresent()) {
            return MENSAJE_USSD_PHONE.resolveFor(actor).getText();
        }

        throw new RuntimeException("No se encontró el mensaje USSD en el dispositivo");
    }
}
