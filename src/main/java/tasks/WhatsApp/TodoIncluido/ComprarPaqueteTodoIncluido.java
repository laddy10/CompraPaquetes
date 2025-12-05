package tasks.WhatsApp.TodoIncluido;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Presence;
import tasks.WhatsApp.EsperarYClickSeleccionaEnUltimoMensaje;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.ELIGE_Y_COMPRA;
import static utils.Constants.ENVIAR2;

public class ComprarPaqueteTodoIncluido implements Task {

    private final User user = TestDataProvider.getRealUser();


    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean paqueteEncontrado = false;

        actor.attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                WaitFor.aTime(2000));

        // BUSCA EL PAQUETE A COMPRAR
        while (!paqueteEncontrado) {

            List<WebElementFacade> paquetes = OPCIONES_PAQUETES.resolveAllFor(actor);

            for (WebElementFacade paquete : paquetes) {
                String textoPaquete = paquete.getText().toLowerCase().replaceAll("\\s+", " ").trim();
                String paqueteBuscado = user.getPaqueteComprar().toLowerCase().replaceAll("\\s+", " ").trim();

                System.out.println("Evaluando: " + textoPaquete);

                if (textoPaquete.contains(paqueteBuscado)) {
                    //   paquete.click();

                    actor.attemptsTo(
                            ClickElementByText.clickElementByText(user.getNombrePaquete()));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            ValidarTextoQueContengaX.elTextoContiene(user.getPaqueteComprar()),
                            ValidarTextoQueContengaX.elTextoContiene(user.getNombrePaquete()));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


                    paqueteEncontrado = true;
                    break; // salimos del for
                }
            }

            // 🔁 Si no se encontró, intentamos mostrar más paquetes
            if (!paqueteEncontrado) {
                if (!Presence.of(BTN_VER_MAS_PAQUETES).viewedBy(actor).resolveAll().isEmpty()
                        && BTN_VER_MAS_PAQUETES.resolveFor(actor).isVisible()) {

                    actor.attemptsTo(
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
                            WaitFor.aTime(2000));

                    continue;
                } else {
                    // No hay más paquetes para mostrar
                    throw new RuntimeException("Paquete no encontrado: " + user.getPaqueteComprar());
                }
            }
        }

        OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWeb.class).getDriver().quit();

    }


    public static Performable comprarPaqueteTodoIncluido() {
        return instrumented(ComprarPaqueteTodoIncluido.class);
    }
}