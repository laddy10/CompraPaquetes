package tasks.SuperAPP;

import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_CERRAR_X;
import static userinterfaces.SegmentoPage.BTN_MENU_HAMBURGUESA;
import static utils.Constants.*;


public class VersionSuperApp implements Task {

    private final User user = TestDataProvider.getRealUser();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU_HAMBURGUESA),
                ValidarTexto.validarTexto(user.getNombreUsuario()),
                ValidarTextoQueContengaX.elTextoContiene(VERSION_2)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_CERRAR_X)
        );

    }

    public static Performable validarVersion() {
        return instrumented(VersionSuperApp.class);
    }
}