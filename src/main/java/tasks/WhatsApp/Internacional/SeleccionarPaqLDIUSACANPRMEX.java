package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_COMPRAR_ROAMING;
import static userinterfaces.WhatsAppPage.BTN_SELECCIONA_PQ;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.PQ_LDI_USA_CAN_PR_MEX;

public class SeleccionarPaqLDIUSACANPRMEX implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                ClickTextoQueContengaX.elTextoContiene(PQ_LDI_USA_CAN_PR_MEX),
                WaitFor.aTime(2000)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(PQ_LDI_USA_CAN_PR_MEX),
                WaitForTextContains.withAnyTextContains(ELIGE_Y_COMPRA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


            actor.attemptsTo(
                    EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20));
        }


    public static Performable seleccionarPaqLDIUSACANPRMEX() {
        return instrumented(SeleccionarPaqLDIUSACANPRMEX.class);
    }
}