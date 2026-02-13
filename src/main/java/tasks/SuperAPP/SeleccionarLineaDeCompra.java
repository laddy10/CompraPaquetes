package tasks.SuperAPP;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;
import static utils.Constants.ELIGE_TIPO_PAQUETE;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;


public class SeleccionarLineaDeCompra extends AndroidObject implements Task {

    private final User user = utils.TestDataProvider.getRealUser();

    private AppiumDriver<AndroidElement> driver;


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickElementByText.clickElementByText(PREPAGO)
        );

        scrollCorto2(actor, LINEA_SA + " " + user.getNumero() + " " + ELEGIR);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                WaitFor.aTime(2000),
               // ClickElementByText.clickElementByText(LINEA_SA + " " + user.getNumero() + " " + ELEGIR),
               // ClickElementByText.clickElementByText("Línea 350 767 1166 Elegir"),
                ClickTextoQueContengaX.elTextoContiene("350 767 1166"),
                WaitForResponse.withText(COMPRA_PAQUETES_RECARGAS)
        );


        theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateInformationText.validateInformationText(LBL_COMPRA_PAQUETES_RECARGAS2),
                                equalTo(COMPRA_PAQUETES_RECARGAS))
                );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        //Validar mini versión

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitForResponse.withText(RECARGAS_Y_PAQUETES),
                ValidarTexto.validarTexto(RECARGAS_Y_PAQUETES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VERSION)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Atras.irAtras(),
                ClickElementByText.clickElementByText(PAQUETES),
                WaitForResponse.withText(ELIGE_TIPO_PAQUETE),
                ValidarTextoQueContengaX.elTextoContiene(user.getNumero())
        );


        //Seleccionar el tipo de paquete a comprar

        actor.attemptsTo(
                WaitElement.isClickable(CBX_TIPO_PAQUETE),
                Click.on(CBX_TIPO_PAQUETE),
                WaitForResponse.withText(TIPO_PAQUETE)
        );


    }

    public static Performable seleccionarLineaDeCompra() {
        return instrumented(SeleccionarLineaDeCompra.class);
    }
}