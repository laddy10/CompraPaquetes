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

public class PaqLDIVenezuela30Minutos implements Task {

    String precioTexto = PRECIO_$6900_30MIN;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(PRECIO_$6900_30MIN)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$6900_30MIN),
                ValidarTextoQueContengaX.elTextoContiene(LLAMADAS_LDI_VENEZUELA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Guardar datos para validación en CMAX
        actor.remember("ES_INTERNACIONAL", true);
        actor.remember("PRECIO_SELECCIONADO", PRECIO_$6900_30MIN);
        actor.remember("VALOR_COMPRA", valorFormateado);
    }

    public static Performable paqLDIVenezuela30Minutos() {
        return instrumented(PaqLDIVenezuela30Minutos.class);
    }
}