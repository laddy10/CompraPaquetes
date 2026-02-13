package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.ConstantsPaquetes.PAQUETES_TODO_INCLUIDO_CON_REDES;


public class PaqueteTodoIncluidoConRedes extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_TODO_INCLUIDO_CON_REDES),
                WaitForResponse.withText(PAQUETES_TODO_INCLUIDO_CON_REDES)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable paqueteTodoIncluidoConRedes() {
        return instrumented(PaqueteTodoIncluidoConRedes.class);
    }
}