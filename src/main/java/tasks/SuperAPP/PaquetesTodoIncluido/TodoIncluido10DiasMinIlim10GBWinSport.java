package tasks.SuperAPP.PaquetesTodoIncluido;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_1;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_1;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

public class TodoIncluido10DiasMinIlim10GBWinSport extends AndroidObject implements Task {

    String precioTexto = PRECIO_$15000_WIN;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTexto.validarTexto(precioTexto),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_7DIAS_10GB_WINSPORTS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_7DIAS_10GB_WINSPORTS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_1),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(precioTexto)
        );

    }

    public static Performable todoIncluido10DiasMinIlim10GBWinSport() {
        return instrumented(TodoIncluido10DiasMinIlim10GBWinSport.class);

    }
}