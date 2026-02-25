package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;
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

public class TodoIncluido7DiasMinutosIlim2GB extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$9000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Desplazamiento inicial y selección del segmento
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                WaitForResponse.withText(ELIGE_TIPO_PAQUETE)
        );

        // Scroll hasta el paquete específico
        scrollCorto2(actor, "2 GB");

        // Ingreso al detalle del paquete
        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),

                // Validación del nombre del paquete
                ValidarTexto.validarTexto(TODO_INCLUIDO_7DIAS_2GB)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_7DIAS_2GB);

        // Evidencia visual
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$9000)
        );
    }

    public static Performable todoIncluido7DiasMinutosIlim2GB() {
        return instrumented(TodoIncluido7DiasMinutosIlim2GB.class);
    }
}