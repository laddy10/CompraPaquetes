package tasks.SuperAPP.PaquetesTodoIncluido;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.ConstantsPaquetes.PAQUETES_TODO_INCLUIDO;

public class PaqueteTodoIncluido extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_TODO_INCLUIDO),
                WaitForResponse.withText(PAQUETES_TODO_INCLUIDO)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }


    public static Performable paqueteTodoIncluido() {
        return instrumented(PaqueteTodoIncluido.class);
    }
}