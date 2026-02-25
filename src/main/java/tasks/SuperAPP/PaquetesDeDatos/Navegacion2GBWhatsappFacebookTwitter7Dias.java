package tasks.SuperAPP.PaquetesDeDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.Constants.ULTIMO;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class Navegacion2GBWhatsappFacebookTwitter7Dias extends AndroidObject implements Task {

    String precioTexto = PRECIO_$8000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO));

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto(PRECIO_$8000),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        NAVEGACION_2GB_7DIAS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", NAVEGACION_2GB_7DIAS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$8000)
        );

    }

    public static Performable navegacion2GBWhatsappFacebookTwitter7Dias() {
        return instrumented(Navegacion2GBWhatsappFacebookTwitter7Dias.class);

    }
}