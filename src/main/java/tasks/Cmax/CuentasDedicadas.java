package tasks.Cmax;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

public class CuentasDedicadas implements Task {
    private static final String paso = "Se valida acceso a cuentas dedicadas";
    private static final String paso1 = "Se validan los saldos desde cuentas dedicadas";
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_RESUMEN_CUENTA),
                WaitFor.aTime(1000),
                Scroll.to(BTN_CERRAR2),
                Click.on(BTN_CUENTAS_DEDICADAS)
        );

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                Scroll.to(LBL_SALDO_TOTAL),
                WaitFor.aTime(2000),
                AdjustPageZoom.to(90),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                AdjustPageZoom.to(100),
                WaitFor.aTime(2000)
        );
    }

    public static Performable cuentasDedicadas() {
        return instrumented(CuentasDedicadas.class);
    }
}