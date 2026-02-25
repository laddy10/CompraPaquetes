package tasks.SuperAPP.PaqueteVoz;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

public class Paquete1000Minutos implements Task {

    String precioTexto = PRECIO_$17500;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto(PRECIO_$17500),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(PAQUETE_1000M_20DIAS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", PAQUETE_1000M_20DIAS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$17500)
        );
    }

    public static Performable paquete1000Minutos() {
        return instrumented(Paquete1000Minutos.class);

    }
}