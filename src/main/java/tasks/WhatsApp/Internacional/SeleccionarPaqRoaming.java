package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_COMPRAR_ROAMING;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.PQ_ROAMING;

public class SeleccionarPaqRoaming implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                ClickTextoQueContengaX.elTextoContiene(PQ_ROAMING),
                WaitFor.aTime(2000)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(PQ_ROAMING),
                WaitForTextContains.withAnyTextContains(COMPRAR)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_ROAMING),
                WaitForTextContains.withAnyTextContains(VER_PAQUETES)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VER_PAQUETES)
        );

    }


    public static Performable seleccionarPaqRoaming() {
        return instrumented(SeleccionarPaqRoaming.class);
    }
}