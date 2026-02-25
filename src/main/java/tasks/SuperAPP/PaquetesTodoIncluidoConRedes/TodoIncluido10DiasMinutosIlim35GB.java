package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
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

public class TodoIncluido10DiasMinutosIlim35GB extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$13000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Desplazamiento inicial y selección del segmento
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO)
        );

        // Scroll hasta el paquete específico
        scrollCorto2(actor, PRECIO_$13000);

        // Ingreso al detalle del paquete
        actor.attemptsTo(
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),

                // Validación del nombre del paquete
                ValidarTexto.validarTexto(TODO_INCLUIDO_3_5GB)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_3_5GB);

        // Evidencia visual
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$13000)
        );
    }

    public static Performable todoIncluido10DiasMinutosIlim35GB() {
        return instrumented(TodoIncluido10DiasMinutosIlim35GB.class);
    }
}