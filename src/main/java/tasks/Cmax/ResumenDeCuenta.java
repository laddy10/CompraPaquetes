package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.NORMAL_ZOOM;
import static utils.Constants.ZOOM_LEVEL_90;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;
import interactions.comunes.ValidateInformationText;

public class ResumenDeCuenta implements Task {
    private static final String paso = "Se valida el resumen de la cuenta para SC";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_RESUMEN_CUENTA),
                WaitFor.aTime(1000)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_PLAN_TARIFA)));

        actor.attemptsTo(
                AdjustPageZoom.to(ZOOM_LEVEL_90),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                AdjustPageZoom.to(NORMAL_ZOOM));
    }

    public static Performable resumenDeCuenta() {
        return instrumented(ResumenDeCuenta.class);
    }
}