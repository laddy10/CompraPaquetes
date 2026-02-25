package tasks.WhatsApp.TodoIncluido;

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

public class Paq2GB_WFT_VozIlimiSMS implements Task {

    String precioTexto = PRECIO_$9000_7DIAS;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(TODO_INCLUIDO_2GB_WFT_VOZ));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$9000_7DIAS),
                ValidarTextoQueContengaX.elTextoContiene(TODO_INCLUIDO_2GB_WFT_VOZ)
        );

        // Guardar información para validación en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_2GB_WFT_VOZ);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }

    public static Performable paq2GB_WFT_VozIlimiSMS() {
        return instrumented(Paq2GB_WFT_VozIlimiSMS.class);
    }
}