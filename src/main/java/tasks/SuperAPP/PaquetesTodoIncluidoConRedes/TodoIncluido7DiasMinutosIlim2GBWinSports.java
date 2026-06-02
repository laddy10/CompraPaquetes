package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.scroll.ScrollVertical;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class TodoIncluido7DiasMinutosIlim2GBWinSports extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$11000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Ingreso al detalle del paquete directamente sin scroll, ya que es el primer paquete de la lista
        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_PAQUETE_DINAMICO.of("2 GB", "11.000")),

                // Validación robusta de una parte del nombre/descripción del paquete que no se corte en pantalla
                ValidarTextoQueContengaX.elTextoContiene(TODO_INCLUIDO_7DIAS_2GB_WINSPORTS)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_7DIAS_2GB_WINSPORTS);

        // Evidencia visual de los detalles del paquete
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Hacemos scroll corto para que el botón "Comprar" del paquete expanded quede visible en pantalla
        scrollCorto2(actor, "Comprar");

        // Flujo de compra
        actor.attemptsTo(
                ScrollVertical.scrollVertical(COMPRAR),
                Click.on(BTN_COMPRAR_1),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$11000)
        );
    }

    public static Performable todoIncluido7DiasMinutosIlim2GBWinSports() {
        return instrumented(TodoIncluido7DiasMinutosIlim2GBWinSports.class);
    }
}
