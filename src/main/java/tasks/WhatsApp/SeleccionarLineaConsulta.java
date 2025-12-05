package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_VER_MENU_PREPAGO;
import static utils.Constants.*;

public class SeleccionarLineaConsulta implements Task {

    private final User user = TestDataProvider.getRealUser();

    public SeleccionarLineaConsulta() {
        // Constructor vacío requerido por Serenity
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SeleccionarNumero.porUltimos4(user.getNumeroWhatsApp()),
                WaitForResponse.withAnyText(
                        POLITICA_TRATAMIENTO, MENU_PRINCIPAL, VER_MENU_PREPAGO
                )
        );

        List<WebElementFacade> btnvermenuprepago = BTN_VER_MENU_PREPAGO.resolveAllFor(actor);

        if (!btnvermenuprepago.isEmpty()) {

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    ClickElementByText.clickElementByText(VER_MENU_PREPAGO),
                    WaitFor.aTime(3000)
            );
        }
    }

    public static Performable seleccionarLineaConsulta() {
        return instrumented(SeleccionarLineaConsulta.class);
    }
}