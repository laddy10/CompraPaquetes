package tasks.SuperAPP.PaquetesApps;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.ConstantsPaquetes.PAQUETES_APPS;

public class PaqueteDeApps extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_APPS),
                WaitForResponse.withText(PAQUETES_APPS)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable paqueteDeApps() {
        return instrumented(PaqueteDeApps.class);
    }
}