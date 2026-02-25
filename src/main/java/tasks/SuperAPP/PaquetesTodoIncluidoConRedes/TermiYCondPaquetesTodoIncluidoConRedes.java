package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import interactions.WaitForResponse;
import interactions.comunes.Atras;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import questions.ValidarElemento;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.SegmentoPage.*;
import static userinterfaces.WhatsAppPage.LBL_WHATSAPP;
import static utils.Constants.*;

public class TermiYCondPaquetesTodoIncluidoConRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(TERMINOS_Y_CONDICIONES)
        );

        theActorInTheSpotlight().should(seeThat(
                ValidarElemento.esVisible(PAG_TERMINOS_Y_CONDICIONES))
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Scroll.scrollUnaVista()
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Atras.irAtras(),
                WaitForResponse.withText(RESUMEN_COMPRA),
                Click.on(CHECK_ACEPTAR_TERMINOS_CONDICIONES2)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_PAGAR),
                WaitForResponse.withAnyText(TEXTO_COSTO_DEL__PAQUETE, OPERACION_EXITOSA)
        );

    }

    public static Performable termiYCondPaquetesTodoIncluidoConRedes() {
        return instrumented(TermiYCondPaquetesTodoIncluidoConRedes.class);
    }
}