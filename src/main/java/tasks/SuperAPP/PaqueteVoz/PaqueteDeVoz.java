package tasks.SuperAPP.PaqueteVoz;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;
import static utils.ConstantsPaquetes.PAQUETES_APPS;
import static utils.ConstantsPaquetes.PAQUETES_DE_VOZ;

public class PaqueteDeVoz extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_DE_VOZ),
                WaitForResponse.withText(PAQUETES_DE_VOZ)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable paqueteDeVoz() {
        return instrumented(PaqueteDeVoz.class);
    }
}