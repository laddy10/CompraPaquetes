package tasks.SuperAPP.PaquetesDeDatos;

import interactions.WaitForResponse;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;
import static utils.ConstantsPaquetes.PAQUETES_DE_DATOS;
import static utils.ConstantsPaquetes.PAQUETES_TODO_INCLUIDO;

public class PaqueteDeDatos extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(PAQUETES_DE_DATOS),
                WaitForResponse.withText(PAQUETES_DE_DATOS)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable paqueteDeDatos() {
        return instrumented(PaqueteDeDatos.class);
    }
}