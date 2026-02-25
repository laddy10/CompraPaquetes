package tasks.Cmax;

import static userinterfaces.CmaxPage.*;

import interactions.WaitFor;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.TestDataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class HistorialDeContrato implements Task {

    private final User user = TestDataProvider.getRealUser();


    public static Performable historialDeContrato() {
        return Instrumented.instanceOf(HistorialDeContrato.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActual = LocalDate.now().format(formatter);

        actor.attemptsTo(
                WaitFor.aTime(3000),
                Click.on(BTN_HISTORIAL_CONTRATO),
                Enter.theValue(fechaActual).into(TXT_FECHA),
                Enter.theValue(fechaActual).into(TXT_FECHA2),
                Click.on(TXT_AJUSTE),
                Click.on(BTN_BUSCAR),
                WaitFor.aTime(5000),
                Click.on(BTN_IMPORTE),
                Click.on(BTN_IMPORTE2)
        );

    }
}