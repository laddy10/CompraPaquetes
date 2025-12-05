package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;


public class SeleccionarTipoPaquete implements Task {


    private final User user = TestDataProvider.getRealUser();

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(COMPRA_TUS_PAQUETES));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        if (!Presence.of(BTN_ENVIAR2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_ENVIAR2));
        } else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(ENVIAR));
        }

        actor.attemptsTo(
                WaitForResponse.withText(SELECCIONA),
                ValidarTextoQueContengaX.elTextoContiene(COMPRA_TUS_PAQUETES));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SELECCIONA),
                ClickTextoQueContengaX.elTextoContiene(user.getTipoPaquete()));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        if (!Presence.of(BTN_ENVIAR2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_ENVIAR2));
        } else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(ENVIAR));
        }

        actor.attemptsTo(
                WaitForTextContains.withAnyTextContains(
                        ELIGE_TIPO_PAQUETE,AHORRA_Y_APROVECHA_MAXIMO)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }


    public static Performable seleccionarTipoPaquete() {
        return instrumented(SeleccionarTipoPaquete.class);
    }
}