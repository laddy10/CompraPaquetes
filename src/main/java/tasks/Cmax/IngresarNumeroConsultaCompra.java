package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CmaxPage.*;

import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
import models.User;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.TestDataProvider;

import java.util.Map;

public class IngresarNumeroConsultaCompra implements Task {

    private final User user = TestDataProvider.getRealUser();

    public static Performable ingresarnumeroConsultaCompra() {
        return Instrumented.instanceOf(IngresarNumeroConsultaCompra.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CLIENTES),
                Click.on(BTN_BUSCAR_CLIENTE),
                Enter.theValue(user.getNumero()).into(TXT_MSISDN),
                Click.on(BTN_BUSCAR),
                Click.on(TXT_MSISDN_BUSCADO),
                WaitFor.aTime(1000)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));
    }
}