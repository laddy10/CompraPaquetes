package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.ELIGE_Y_COMPRA;
import static utils.Constants.ENVIAR2;
import static utils.ConstantsPaquetes.PQ_LDI_SIN_FRONTERAS;
import static utils.ConstantsPaquetes.PQ_LDI_USA_CAN_PR_MEX;

public class SeleccionarPaqLDISinFronteras implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                ClickTextoQueContengaX.elTextoContiene(PQ_LDI_SIN_FRONTERAS),
                WaitFor.aTime(2000)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(PQ_LDI_SIN_FRONTERAS),
                WaitForTextContains.withAnyTextContains(ELIGE_Y_COMPRA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


            actor.attemptsTo(
                    EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20));
        }


    public static Performable seleccionarPaqLDISinFronteras() {
        return instrumented(SeleccionarPaqLDISinFronteras.class);
    }
}