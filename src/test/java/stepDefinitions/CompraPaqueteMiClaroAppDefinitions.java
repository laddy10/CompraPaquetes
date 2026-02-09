package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;
import static utils.Constants.COMPRA_PAQUETES_Y_RECARGAS;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.*;

import java.io.File;
import java.util.List;
import models.User;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.SuperAPP.*;
import tasks.SuperAPP.PaquetesRelevo.PaqueteRelevo;
import tasks.SuperAPP.PaquetesTodoIncluido.*;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import tasks.MiClaroApp.*;
import tasks.SuperAPP.PaqueteVoz.Paquete1000Minutos;
import tasks.SuperAPP.PaqueteVoz.Paquete300Minutos1Dia;
import tasks.SuperAPP.PaqueteVoz.Paquete300Minutos2Dias;
import tasks.SuperAPP.PaquetesApps.*;
import tasks.SuperAPP.PaquetesDeDatos.*;
import tasks.SuperAPP.PaquetesTodoIncluidoConRedes.*;

public class CompraPaqueteMiClaroAppDefinitions {

    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());

    @Before
    public void initScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        LOGGER.info("Limpiando carpeta de capturas...");
        File folder = new File("Capturas");

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && (file.getName().toLowerCase().endsWith(".jpg")
                        || file.getName().toLowerCase().endsWith(".png"))) {
                    file.delete();
                }
            }
        }

    }

    @Given("ABRIR LA SUPER APP")
    public void abrirSuperApp() {
        theActorInTheSpotlight().attemptsTo(
                        WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                        WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                        WaitFor.aTime(2000));
    }


    private final User user = utils.TestDataProvider.getRealUser();

    @When("^EL USUARIO REALIZA EL INGRESO A LA SUPER APP$")
    public void elUsuarioRealizaIngreso() {
        theActorInTheSpotlight().attemptsTo(
                IngresoSuperApp.ingresoSuperApp()
        );
    }


    @Then("^VERIFICA VERSION DE LA SUPER APP$")
    public void verificaVersion() {
        theActorInTheSpotlight().attemptsTo(
                VersionSuperApp.validarVersion()
        );
    }

    @Then("^INGRESAR AL MENU DE RECARGAS Y PAQUETES$")
    public void ingresarMenuRecargasYPaquetes() {
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        theActorInTheSpotlight()
                .attemptsTo(
                        ClickElementByText.clickElementByText(RECARGA_COMPRA_PAQUETE),
                        WaitForResponse.withText(COMPRA_PAQUETES_Y_RECARGAS)
                );
    }

    @Then("^SELECCIONAR LINEA DE COMPRA$")
    public void seleccionarLineaDeCompra() {
        theActorInTheSpotlight()
                .attemptsTo(SeleccionarLineaDeCompra.seleccionarLineaDeCompra());
    }

    @Then("^VALIDAR EL PAQUETE SELECCIONADO$")
    public void validarPaqueteSeleccionado(List<User> credentials) {
        theActorInTheSpotlight()
                .attemptsTo(ValidarPaqueteSeleccionado.seleccionarLineaDeCompra(user));
    }

    // ... (Existing implicit references can keep their signatures if they didn't take args, but need to check if any other explicitly used args)

    @Then("^SELECCIONAR EL PAQUETE A COMPRAR$")
    public void seleccionarPaqueteComprar() {
        theActorInTheSpotlight()
                .attemptsTo(SeleccionarPaqueteAComprar.seleccionarPaqueteAComprar(user));
    }

    // ... (Existing implicit references can keep their signatures if they didn't take args, but need to check if any other explicitly used args)

    @Then("SELECCIONAR PAQUETE ESPECIFICO")
    public void seleccionarPaqueteEspecifico() {
        // Usamos 'paqueteComprar' (para la descripción, ej: "50 MB") y 'precio' (ej: "$ 2.500") del JSON.
        String descripcion = user.getPaqueteComprar();
        String precio = user.getPrecio();

        theActorInTheSpotlight().attemptsTo(
                tasks.SuperAPP.SeleccionarPaquete.conDescripcionYPrecio(descripcion, precio)
        );
    }

    @Then("VALIDAR NOTIFICACIONES DE COMPRA")
    public void validarNotificacionCompra() {
        theActorInTheSpotlight().attemptsTo(
                ValidarNotificacion.deCompra()
        );
    }

    @Then("CLIC EN BOTON CONTRA SALDO")
    public void clicEnBotonContraSaldo() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONTRA_SALDO)
        );
    }

    @Then("CLIC PAGAR CON MI SALDO")
    public void clicPagarConMiSaldo() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_PAGAR_CON_MI_SALDO)
        );
    }
}