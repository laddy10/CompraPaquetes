package tasks.Cmax;

import static userinterfaces.CmaxPage.*;

import interactions.WaitFor;
import models.User;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.JsonDataProvider;

public class RealizarIngreso implements Task {

    private final User user = JsonDataProvider.getUser();

    public static Performable realizarIngreso() {
        return Instrumented.instanceOf(RealizarIngreso.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getUsuario()).into(TXT_USUARIO),
                Enter.theValue(user.getContrasena()).into(TXT_CONTRASENA),
                Click.on(BTN_OK),
                WaitFor.aTime(1000));
    }
}