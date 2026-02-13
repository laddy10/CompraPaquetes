package tasks.SuperAPP.PaquetesRelevo;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.ConstantsPaquetes.PAQUETES_RELEVO_COMUNIDAD_SORDA;

public class PaqueteRelevo extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_RELEVO_COMUNIDAD_SORDA),
                WaitForResponse.withText(PAQUETES_RELEVO_COMUNIDAD_SORDA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable paqueteRelevo() {
        return instrumented(PaqueteRelevo.class);
    }
}