package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class TodoIncluido30DiasMinIlim30GBNoIncluyeRedes extends AndroidObject implements Task {

    String precioTexto = PRECIO_$33000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, PRECIO_$33000);

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto(TODO_INCLUIDO_30DIAS_30GB)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_30DIAS_30GB);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$33000)
        );

    }

    public static Performable todoIncluido30DiasMinIlim30GBNoIncluyeRedes() {
        return instrumented(TodoIncluido30DiasMinIlim30GBNoIncluyeRedes.class);
    }
}