package tasks.WhatsApp.Voz;

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

public class PaqVoz1000MinX20Dias implements Task {

    String precioTexto = PRECIO_$17500_20DIAS;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(PRECIO_$17500_20DIAS));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$17500_20DIAS),
                ValidarTextoQueContengaX.elTextoContiene(PQ_VOZ_1000_MINUTOS));

        // Guardar información para validación en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", PQ_VOZ_1000_MINUTOS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


    }

    public static Performable paqVoz1000MinX20Dias() {
        return instrumented(PaqVoz1000MinX20Dias.class);
    }
}