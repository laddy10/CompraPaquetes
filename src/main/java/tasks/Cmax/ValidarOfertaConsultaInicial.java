package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

public class ValidarOfertaConsultaInicial implements Task {
    private static final String paso = "Se validan las ofertas activas";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitElement.isClickable(BTN_OFERTAS),
                Click.on(BTN_OFERTAS),
                Click.on(BTN_FECHA_INICIO),
                WaitFor.aTime(1000),
                Click.on(BTN_FECHA_INICIO2),
                WaitFor.aTime(1000),
                AdjustPageZoom.to(75)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION2)));

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(AdjustPageZoom.to(100));
    }

    public static Performable validarofertaConsultaInicial() {
        return instrumented(ValidarOfertaConsultaInicial.class);
    }
}