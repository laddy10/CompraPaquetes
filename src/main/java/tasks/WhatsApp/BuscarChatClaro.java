package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.ClickTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.CLARO;
import static utils.Constants.CLARO_COLOMBIA;

public class BuscarChatClaro implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CLARO_COLOMBIA),
                WaitForResponse.withText((CLARO_COLOMBIA))
        );
    }

    public static Performable buscarChatClaro() {
        return instrumented(BuscarChatClaro.class);
    }
}