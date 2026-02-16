package tasks.WhatsApp.TodoIncluido;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.ENVIAR2;
import static utils.ConstantsPaquetes.PRECIO_$2500_1DIA;
import static utils.ConstantsPaquetes.TODO_INCLUIDO_50MB_50MIN;

public class Paq50MB_50MIN implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(TODO_INCLUIDO_50MB_50MIN));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$2500_1DIA),
                ValidarTextoQueContengaX.elTextoContiene(TODO_INCLUIDO_50MB_50MIN));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        WordAppium.main();

    }

    public static Performable paq50MB_50MIN() {
        return instrumented(Paq50MB_50MIN.class);
    }
}