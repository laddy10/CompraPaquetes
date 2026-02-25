package tasks.SuperAPP.PaqueteVoz;

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

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;


public class Paquete300Minutos2Dias extends AndroidObject implements Task {

    String precioTexto = PRECIO_$3000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto(PRECIO_$3000),
                Click.on(LBL_VER_DETALLE_3),
                ValidarTexto.validarTexto(PAQUETE_300M_2DIAS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", PAQUETE_300M_2DIAS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_3),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$3000)
        );

    }

    public static Performable paquete300Minutos2Dias() {
        return instrumented(Paquete300Minutos2Dias.class);
    }
}