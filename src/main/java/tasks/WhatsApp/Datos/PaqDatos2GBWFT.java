package tasks.WhatsApp.Datos;

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

public class PaqDatos2GBWFT implements Task {

    String precioTexto = PRECIO_$8000_7DIAS_2GB;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(PQ_DATOS_2GB_WFT));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$8000_7DIAS_2GB),
                ValidarTextoQueContengaX.elTextoContiene(PQ_DATOS_2GB_WFT));

        // Guardar información para validación en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", PQ_DATOS_2GB_WFT);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


    }

    public static Performable paqDatos2GBWFT() {
        return instrumented(PaqDatos2GBWFT.class);
    }
}