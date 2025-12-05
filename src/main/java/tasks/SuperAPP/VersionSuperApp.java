package tasks.SuperAPP;

import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;


public class VersionSuperApp implements Task {

    private final User addCredentials;

    public VersionSuperApp(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(PERFIL),
                ValidarTexto.validarTexto(addCredentials.getNombreUsuario()),
                ValidarTextoQueContengaX.elTextoContiene(VERSION));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(MUNDO_CLARO)
        );

    }

    public static Performable validarVersion(User addCredentials) {
        return instrumented(VersionSuperApp.class, addCredentials);
    }
}