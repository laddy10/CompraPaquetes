package tasks.SuperAPP.PaquetesDeDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class NavegacionIlim2Horas extends AndroidObject implements Task {

    String precioTexto = PRECIO_$6000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$6000),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(NAVEGACION_ILIMITADA_2H)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", NAVEGACION_ILIMITADA_2H);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$6000)
        );

    }

    public static Performable navegacionIlim2Horas() {
        return instrumented(NavegacionIlim2Horas.class);
    }
}