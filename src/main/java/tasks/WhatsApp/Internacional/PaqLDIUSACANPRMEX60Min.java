package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.ENVIAR2;
import static utils.ConstantsPaquetes.*;

public class PaqLDIUSACANPRMEX60Min implements Task {

    private final String precioTexto = PRECIO_$5900_60MIN;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Selección del paquete internacional por precio
        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(PRECIO_$5900_60MIN)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Confirmación y validaciones en WhatsApp
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$5900_60MIN),
                ValidarTextoQueContengaX.elTextoContiene(LLAMADAS_USA_CAN_PR_MEX)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Guardar datos para validación en CMAX
        actor.remember("ES_INTERNACIONAL", true);
        actor.remember("PRECIO_SELECCIONADO", PRECIO_$5900_60MIN);
        actor.remember("VALOR_COMPRA", valorFormateado);

    }

    public static Performable paqLDIUSACANPRMEX60Min() {
        return instrumented(PaqLDIUSACANPRMEX60Min.class);
    }
}