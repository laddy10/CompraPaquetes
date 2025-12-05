package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class SeleccionarPaqueteUniversal implements Task {

    private final User user = TestDataProvider.getRealUser();


    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean encontrado = false;

        while (!encontrado) {

            List<WebElementFacade> paquetes = OPCIONES_PAQUETES.resolveAllFor(actor);

            for (WebElementFacade paquete : paquetes) {

                String texto = paquete.getText().toLowerCase().replaceAll("\\s+", " ");

                String criterioNombre = user.getNombrePaquete().toLowerCase();
                String criterioBusqueda = user.getPaqueteComprar().toLowerCase();
                String criterioExtra = user.getCriterioExtra() != null
                        ? user.getCriterioExtra().toLowerCase()
                        : "";

                int coincidencias = 0;

                System.out.println(">>> TEXTO REAL DEL ELEMENTO:");
                System.out.println("'" + paquete.getText() + "'");


                if (texto.contains(criterioNombre)) coincidencias++;
                if (texto.contains(criterioBusqueda)) coincidencias++;
                if (!criterioExtra.isEmpty() && texto.contains(criterioExtra)) coincidencias++;

                // 🔥 Selección robusta
                if (coincidencias >= 2) {

                    paquete.click();

                    CapturaDePantallaMovil.tomarCapturaPantalla("seleccion-paquete");

                    actor.attemptsTo(
                            WaitFor.aTime(2000),
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            ValidarTextoQueContengaX.elTextoContiene(user.getNombrePaquete())
                    );

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                if (!Presence.of(BTN_VER_MAS_PAQUETES).viewedBy(actor).resolveAll().isEmpty()
                        && BTN_VER_MAS_PAQUETES.resolveFor(actor).isVisible()) {

                    actor.attemptsTo(
                            Click.on(BTN_VER_MAS_PAQUETES),
                            WaitFor.aTime(2000)
                    );

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            WaitForTextContains.withAnyTextContains(ELIGE_Y_COMPRA),
                            WaitFor.aTime(2000));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20)
                    );

                    continue;
                } else {
                    // No hay más paquetes para mostrar
                    throw new RuntimeException("Paquete no encontrado: " + user.getPaqueteComprar());
                }
            }
        }
    }

    public static Performable comprar() {
        return instrumented(SeleccionarPaqueteUniversal.class);
    }
}
