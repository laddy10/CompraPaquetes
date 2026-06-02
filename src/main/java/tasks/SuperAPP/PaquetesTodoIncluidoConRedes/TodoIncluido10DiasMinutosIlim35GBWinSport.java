package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

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
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

public class TodoIncluido10DiasMinutosIlim35GBWinSport extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$15000_WIN;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Scroll hasta el paquete específico
        scrollCorto2(actor, precioTexto);

        // Ingreso al detalle del paquete
        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),

                // Validación del nombre del paquete
                ValidarTexto.validarTexto(TODO_INCLUIDO_10DIAS_3_5GB_WINSPORTS)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_10DIAS_3_5GB_WINSPORTS);

        // Evidencia visual
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(precioTexto)
        );
    }

    public static Performable todoIncluido10DiasMinutosIlim35GBWinSport() {
        return instrumented(TodoIncluido10DiasMinutosIlim35GBWinSport.class);
    }
}