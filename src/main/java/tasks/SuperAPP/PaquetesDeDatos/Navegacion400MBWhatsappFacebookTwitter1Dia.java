package tasks.SuperAPP.PaquetesDeDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class Navegacion400MBWhatsappFacebookTwitter1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String precioTexto = PRECIO_$3000;
        String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

        scrollCorto2(actor, PRECIO_$3000);

        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$3000),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        NAVEGACION_400MB_1DIA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$3000)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", NAVEGACION_400MB_1DIA);
    }

    public static Performable navegacion400MBWhatsappFacebookTwitter1Dia() {
        return instrumented(Navegacion400MBWhatsappFacebookTwitter1Dia.class);

    }
}