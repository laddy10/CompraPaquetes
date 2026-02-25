package tasks.WhatsApp.Internacional;

import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.ENVIAR2;
import static utils.ConstantsPaquetes.*;

public class PaqRoaming1GB implements Task {

    String precioTexto = PRECIO_$11900_1GB;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickElementByText.clickElementByText(PRECIO_$11900_1GB)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$11900_1GB),
                ValidarTextoQueContengaX.elTextoContiene(LLAMADAS_ROAMING_INTERNET)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Guardar datos para validación en CMAX
        actor.remember("ES_INTERNACIONAL", true);
        actor.remember("PRECIO_SELECCIONADO", PRECIO_$11900_1GB);
        actor.remember("VALOR_COMPRA", valorFormateado);

    }

    public static Performable paqRoaming1GB() {
        return instrumented(PaqRoaming1GB.class);
    }
}