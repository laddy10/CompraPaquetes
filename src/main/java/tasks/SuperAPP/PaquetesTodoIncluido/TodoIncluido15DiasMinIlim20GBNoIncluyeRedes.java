package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.PRECIO_$23000;
import static utils.ConstantsPaquetes.TODO_INCLUIDO_15DIAS_20GB;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido15DiasMinIlim20GBNoIncluyeRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, TODO_INCLUIDO_15DIAS_20GB);

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_15DIAS_20GB)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$23000));
    }

    public static Performable todoIncluido15DiasMinIlim20GBNoIncluyeRedes() {
        return instrumented(TodoIncluido15DiasMinIlim20GBNoIncluyeRedes.class);

    }
}