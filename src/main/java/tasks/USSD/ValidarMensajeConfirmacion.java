package tasks.USSD;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;

import static userinterfaces.USSDPage.*;
import static utils.Constants.*;

public class ValidarMensajeConfirmacion extends AndroidObject implements Task {


    public static ValidarMensajeConfirmacion deCompra() {
        return new ValidarMensajeConfirmacion();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        // Validar si la notificación es de saldo insuficiente o confirmación de la compra

        actor.attemptsTo(
                WaitFor.aTime(3000));

        if (!Presence.of(TXT_MENSAJE_SALDO_INSUFICIENTE).viewedBy(actor).resolveAll().isEmpty()) {
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
            if (!Presence.of(TXT_ACEPTAR).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR2));

            } else {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR));
            }
        } else {
            actor.attemptsTo(
                    WaitElement.isEnable(TXT_MENSAJE_COMPRA_EXITOSA));
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            if (!Presence.of(TXT_ACEPTAR).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR2));

            } else {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR));
            }
        }

        if (!Presence.of("CANCELAR").viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText("CANCELAR"));
        }

        WordAppium.main();

        actor.attemptsTo(
                WaitFor.aTime(120000));

    }
}