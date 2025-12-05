package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CmaxPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.NORMAL_ZOOM;
import static utils.Constants.ZOOM_LEVEL_80;

import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

public class ContadorUsoIniciales implements Task {

    private static final String paso = "Validar contadores de uso consumo iniciales";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CONTADORES_USO),
                WaitFor.aTime(1000)
        );

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CONTADORES_USO)));

        actor.attemptsTo(
                WaitFor.aTime(2000),
                AdjustPageZoom.to(ZOOM_LEVEL_80),
                Scroll.to(LGO_CLARO),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));
    }

    public static Performable contadorusoIniciales() {
        return instrumented(ContadorUsoIniciales.class);
    }
}