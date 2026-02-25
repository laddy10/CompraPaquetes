package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

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

public class TodoIncluido3DíasMinutosIlimitados400MB extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$5000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Abrir detalle y validar nombre del paquete
        actor.attemptsTo(
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(TODO_INCLUIDO_3DIAS_400MB)
        );

        // Guardar información para validaciones posteriores (CMAX)
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_3DIAS_400MB);

        // Evidencia
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(precioTexto)
        );
    }

    public static Performable todoIncluido3DíasMinutosIlimitados400MB() {
        return instrumented(TodoIncluido3DíasMinutosIlimitados400MB.class);
    }
}