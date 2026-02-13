package tasks.SuperAPP.PaqueteVoz;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_1;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_1;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.PAQUETE_300M_1DIA;
import static utils.ConstantsPaquetes.PRECIO_$2500;

public class Paquete300Minutos1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$2500),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(PAQUETE_300M_1DIA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_1),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$2500)
        );
    }

    public static Performable paquete300Minutos1Dia() {
        return instrumented(Paquete300Minutos1Dia.class);

    }
}