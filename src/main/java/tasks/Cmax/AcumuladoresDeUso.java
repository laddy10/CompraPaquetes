package tasks.Cmax;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Presence;
import utils.EvidenciaUtils;
import utils.WordWeb;
import utils.WordWebReport;

public class AcumuladoresDeUso implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        int pagina = 1;

        actor.attemptsTo(
                WaitFor.aTime(2000),
                Click.on(BTN_ACUMULADORES_DE_USO),
                WaitFor.aTime(2000),
                Scroll.to(BTN_CERRAR2),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura("Se validan los acumuladores de uso pagina " + pagina++);

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_NEXT_CMAX),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura("Se validan los acumuladores de uso pagina " + pagina++);

        while (!Presence.of(BTN_NEXT_ACUMULADORES_USO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    WaitFor.aTime(1000),
                    Click.on(BTN_NEXT_ACUMULADORES_USO),
                    WaitFor.aTime(1000)
            );

            EvidenciaUtils.registrarCaptura("Se validan los acumuladores de uso pagina " + pagina++);
        }


        WordWebReport.main();

    }

    public static Performable acumuladoresDeUso() {
        return instrumented(AcumuladoresDeUso.class);
    }
}