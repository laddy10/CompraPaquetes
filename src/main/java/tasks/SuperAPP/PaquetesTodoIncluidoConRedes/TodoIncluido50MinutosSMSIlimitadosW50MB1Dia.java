package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.Constants.VER_DETALLE_DEL_PAQUETE;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class TodoIncluido50MinutosSMSIlimitadosW50MB1Dia extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$2500;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Scroll hasta el paquete
        scrollCorto2(actor, PRECIO_$2500);

        // Abrir detalle y validar nombre
        actor.attemptsTo(
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(TODO_INCLUIDO_1DIAS_50MIN)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_1DIAS_50MIN);

        // Captura (la dejamos exactamente como tú la manejas)
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(precioTexto)
        );
    }

    public static Performable todoIncluido50MinutosSMSIlimitadosW50MB1Dia() {
        return instrumented(TodoIncluido50MinutosSMSIlimitadosW50MB1Dia.class);
    }
}