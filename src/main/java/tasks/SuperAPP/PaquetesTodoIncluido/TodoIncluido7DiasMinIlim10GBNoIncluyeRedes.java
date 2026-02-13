package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_1;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_1;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.PRECIO_$13000;
import static utils.ConstantsPaquetes.TODO_INCLUIDO_7DIAS_10GB;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido7DiasMinIlim10GBNoIncluyeRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$13000),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_7DIAS_10GB)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_1),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$13000));
    }

    public static Performable todoIncluido7DiasMinIlim10GBNoIncluyeRedes() {
        return instrumented(TodoIncluido7DiasMinIlim10GBNoIncluyeRedes.class);

    }
}