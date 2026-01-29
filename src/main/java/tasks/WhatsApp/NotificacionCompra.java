package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;


public class NotificacionCompra extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerMensaje(actor);

        if (!Presence.of(LBL_87456).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    WaitFor.aTime(2000),
                    ClickTextoQueContengaX.elTextoContiene(MENSAJE_87456),
                    ClickTextoQueContengaX.elTextoContiene(MENSAJE_87456),
                    ValidarTextoQueContengaX.elTextoContiene(COMPRA_EXITOSA2));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    Atras.irAtras());


       } /* else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(CLARO),
                    WaitFor.aTime(1000));
        }

        actor.attemptsTo(
                ClickElementByText.clickElementByText(CLARO),
                WaitFor.aTime(1000));

        List<WebElementFacade> lblpaqueteinstalado = LBL_PAQUETE_INSTALADO.resolveAllFor(actor);

        if (!lblpaqueteinstalado.isEmpty()) {
            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene(INSTALACION),
                    ValidarTextoQueContengaX.elTextoContiene("www.claro.com.co"));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            UtilidadesAndroid.abrirLinkEnNavegador(actor,"https://www.claro.com.co");

            actor.attemptsTo(
                    WaitFor.aTime(6000),
                    ValidarTexto.validarTexto("Personas")
            );

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        } else {
            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene(COMPRASTE_PAQUETE));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        } */

        actor.attemptsTo(
                Atras.irAtras(),
                Atras.irAtras(),
                Atras.irAtras());

        WordAppium.main();

       // OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class).getDriver().quit();

    }

    public static Performable notificacionCompra() {
        return instrumented(NotificacionCompra.class);
    }
}