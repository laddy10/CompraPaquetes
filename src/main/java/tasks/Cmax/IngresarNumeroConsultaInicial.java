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
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;
import utils.JsonDataProvider;
import utils.TestDataProvider;

public class IngresarNumeroConsultaInicial implements Task {

    private final User user = TestDataProvider.getRealUser();  // Usuario índice 0
    private static final String paso = "Verificar el estado inicial de la linea";

    public static Performable ingresarNumeroConsultaInicial() {
        return Instrumented.instanceOf(IngresarNumeroConsultaInicial.class)
                .withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CLIENTES),
                Click.on(BTN_BUSCAR_CLIENTE),
                Enter.theValue(user.getNumeroCmax()).into(TXT_MSISDN),
                Click.on(BTN_BUSCAR),
                WaitFor.aTime(1000),
                Click.on(TXT_MSISDN_BUSCADO)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.attemptsTo(
                AdjustPageZoom.to(85),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                AdjustPageZoom.to(100));
    }
}