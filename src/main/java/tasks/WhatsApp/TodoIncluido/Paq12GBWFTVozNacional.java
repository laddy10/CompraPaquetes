package tasks.WhatsApp.TodoIncluido;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_VER_MAS_PAQUETES;
import static utils.Constants.ELIGE_Y_COMPRA;
import static utils.Constants.ENVIAR2;
import static utils.ConstantsPaquetes.*;

public class Paq12GBWFTVozNacional implements Task {

    String precioTexto = PRECIO_$33000_30DIAS;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                Click.on(BTN_VER_MAS_PAQUETES),
                WaitFor.aTime(2000)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                WaitForTextContains.withAnyTextContains(ELIGE_Y_COMPRA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000),
                ClickElementByText.clickElementByText(TODO_INCLUIDO_12GB_WFT_VOZ));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                ValidarTextoQueContengaX.elTextoContiene(PRECIO_$33000_30DIAS),
                ValidarTextoQueContengaX.elTextoContiene(TODO_INCLUIDO_12GB_WFT_VOZ));

        // Guardar información para validación en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_12GB_WFT_VOZ);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


    }

    public static Performable paq12GBWFTVozNacional() {
        return instrumented(Paq12GBWFTVozNacional.class);
    }
}