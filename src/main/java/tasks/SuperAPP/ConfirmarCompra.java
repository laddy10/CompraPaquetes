package tasks.SuperAPP;

import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.Atras;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;

import java.util.List;

import static userinterfaces.USSDPage.TXT_CLARO;
import static userinterfaces.WhatsAppPage.LBL_PAQUETE_INSTALADO;
import static utils.Constants.*;

public class ConfirmarCompra extends AndroidObject implements Task {

    public static ConfirmarCompra deCompra() {
        return new ConfirmarCompra();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitForResponse.withAnyText(OPERACION_EXITOSA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(CERRAR));

        WordAppium.main();

    }
}