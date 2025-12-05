package tasks.SuperAPP;

import static userinterfaces.USSDPage.TXT_CLARO;
import static userinterfaces.WhatsAppPage.LBL_PAQUETE_INSTALADO;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;

import java.util.List;

public class ValidarNotificacion extends AndroidObject implements Task {

    public static ValidarNotificacion deCompra() {
        return new ValidarNotificacion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitForResponse.withAnyText(OPERACION_EXITOSA)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(CERRAR));

        WordAppium.main();

        actor.attemptsTo(
                WaitFor.aTime(15000));

        LeerMensaje(actor);

        if (!Presence.of(TXT_CLARO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    WaitForResponse.withText(CLARO_2),
                    ClickElementByText.clickElementByText(CLARO_2));

            //   CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            List<WebElementFacade> lblpaqueteinstalado = LBL_PAQUETE_INSTALADO.resolveAllFor(actor);

            if (!lblpaqueteinstalado.isEmpty()) {
                actor.attemptsTo(
                        ValidarTextoQueContengaX.elTextoContiene(INSTALACION),
                        ValidarTextoQueContengaX.elTextoContiene("www.claro.com.co"));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                UtilidadesAndroid.abrirLinkEnNavegador(actor,"https://www.claro.com.co");

                actor.attemptsTo(
                        WaitForResponse.withText(PERSONAS),
                        ValidarTexto.validarTexto(PERSONAS)
                );

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                actor.attemptsTo(
                        Atras.irAtras());

            } else {
                actor.attemptsTo(
                        ValidarTextoQueContengaX.elTextoContiene(COMPRASTE_PAQUETE));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
            }

        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }

        actor.attemptsTo(
                Atras.irAtras(),
                Atras.irAtras());

        WordAppium.main();
    }
}