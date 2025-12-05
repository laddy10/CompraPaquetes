package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.NORMAL_ZOOM;
import static utils.Constants.ZOOM_LEVEL_90;

import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

import java.util.Map;

public class IngresarNumeroConsultaFinal implements Task {
    private final Map<String, String> data;
    private static final String paso = "Verificar el estado final de la línea";


    public IngresarNumeroConsultaFinal(Map<String, String> data) {
        this.data = data;
    }

    public static Performable ingresarNumeroConsultaFinal(Map<String, String> data) {
        return Instrumented.instanceOf(IngresarNumeroConsultaFinal.class)
                .withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CLIENTES),
                Click.on(BTN_BUSCAR_CLIENTE),
                Enter.theValue(data.get("Numero")).into(TXT_MSISDN),
                Click.on(BTN_BUSCAR),
                Click.on(TXT_MSISDN_BUSCADO),
                WaitFor.aTime(1000)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.attemptsTo(
                AdjustPageZoom.to(ZOOM_LEVEL_90),
                WaitFor.aTime(1000));

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                AdjustPageZoom.to(NORMAL_ZOOM));
    }
}