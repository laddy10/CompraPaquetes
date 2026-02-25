package tasks.WhatsApp.Datos;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_ENVIAR2;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.PAQ_DATOS_WH;
import static utils.ConstantsPaquetes.PAQ_VOZ_WH;


public class SeleccionarPaqDatos implements Task {


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
                ClickTextoQueContengaX.elTextoContiene(PAQ_DATOS_WH)
        );

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
                        ELIGE_TIPO_PAQUETE, AHORRA_Y_APROVECHA_MAXIMO, DISFRUTA_TUS_APP_MOVILES, CONECTADO, RECUERDA_TENER_SALDO)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }


    public static Performable seleccionarPaqDatos() {
        return instrumented(SeleccionarPaqDatos.class);
    }
}