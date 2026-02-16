package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import questions.ValidarElemento;
import tasks.WhatsApp.*;
import tasks.WhatsApp.Apps.SeleccionarPqApps;
import tasks.WhatsApp.Internacional.SeleccionarPqInternacional;
import tasks.WhatsApp.Internacional.SeleccionarUsarSaldo;
import tasks.WhatsApp.TodoIncluido.ComprarPaqueteTodoIncluido;
import tasks.WhatsApp.TodoIncluido.Paq50MB_50MIN;
import tasks.WhatsApp.TodoIncluido.SeleccionarPaqTodoIncluido;
import utils.WordAppium;

import java.io.File;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.PREGUNTAR_META;

public class CompraPaquetesWhatsAppDefinitions {

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

    @Given("Ingresar a WhatsAPP")
    public void ingresarWhatsapp() {
        theActorCalled(" ").attemptsTo
                (WaitForResponse.withText(PREGUNTAR_META));
        theActorInTheSpotlight().attemptsTo(
                ValidarTexto.validarTexto(PREGUNTAR_META));
        theActorInTheSpotlight().should(seeThat(
                ValidarElemento.esVisible(LBL_WHATSAPP)));
    }

    @When("^Validar Version de la App$")
    public void validarVersionApp() {
        theActorInTheSpotlight().attemptsTo(ValidarVersionApp.validarVersionApp());
    }

    @And("^Buscar el chat de Claro Colombia$")
    public void buscarChatClaro() {
        theActorInTheSpotlight().attemptsTo(BuscarChatClaro.buscarChatClaro());
    }

    @And("^Iniciar el chat con Claro Colombia$")
    public void iniciarChatClaro() {
        theActorInTheSpotlight().attemptsTo(IniciarChatClaro.iniciarChatClaro());
    }

    @And("^Seleccionar linea de consulta$")
    public void seleccionarLineaConsulta() {
        theActorInTheSpotlight().attemptsTo(SeleccionarLineaConsulta.seleccionarLineaConsulta());
    }

    @And("^Validar politica de tratamientos de datos$")
    public void validarPoliticaTratamiendoDatos() {
        theActorInTheSpotlight().attemptsTo(ValidarTratamientoDatos.validarTratamientoDatos());
    }

    @And("^Consultar saldo de la linea$")
    public void consultarSaldoLinea() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarSaldoLinea.consultarSaldoLinea());
    }

    @And("^Seleccionar el tipo de paquete$")
    public void seleccionarTipoPaquete() {
        theActorInTheSpotlight().attemptsTo(SeleccionarTipoPaquete.seleccionarTipoPaquete());
    }

    @And("^Seleccionar el tipo de paquete todo incluido$")
    public void seleccionarTipoPaqueteTodoIncluido() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqTodoIncluido.seleccionarPaqTodoIncluido());
    }

    @And("^Realizar la compra del paquete todo incluido$")
    public void realizarCompraPqTodoIncluido() {
        theActorInTheSpotlight().attemptsTo(ComprarPaqueteTodoIncluido.comprarPaqueteTodoIncluido());
    }


    @And("^Ingresar al boton Selecciona paquete Relevo$")
    public void ingresarBotonSeleccionaPqRelevo() {
        theActorInTheSpotlight().attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
               // Click.on(BTN_SELECCIONA_PQ_RELEVO),
                WaitFor.aTime(2000));
    }

    @And("^Seleccionar el paquete de Apps$")
    public void seleccionarPqApps() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPqApps.seleccionarPqApps());
    }

    @And("^Seleccionar el paquete internacional$")
    public void seleccionarPqInternacional() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPqInternacional.seleccionarPqInternacional());
    }

    @And("^Seleccionar el paquete de compra$")
    public void seleccionarPaqueteCompra() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqueteCompra.comprarPaqueteVoz());
    }

    @And("^Realizar la compra del paquete de voz$")
    public void realizarCompraPaqueteVoz() {
        theActorInTheSpotlight().attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
              //  Click.on(BTN_SELECCIONA_PQ_VOZ),
                WaitFor.aTime(3000),
               SeleccionarPaqueteUniversal.comprar()
               // SeleccionarPaqueteCompra.comprarPaqueteVoz()
        );
    }

    @And("^Realizar la compra de paquetes datos$")
    public void realizarCompraPaqueteDtos() {
        theActorInTheSpotlight().attemptsTo(
                EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20),
                //Click.on(BTN_SELECCIONA_PQ_DATOS),
                WaitFor.aTime(3000),
                SeleccionarPaqueteCompra.comprarPaqueteVoz());
    }

    @And("^Seleccionar opcion usar saldo$")
    public void seleccionarOpcionUsarSaldo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarUsarSaldo.seleccionarUsarSaldo());
    }

    @And("^Selecciona opcion usa tu saldo$")
    public void seleccionarUsaTuSaldo() {
        theActorInTheSpotlight().attemptsTo(SeleccionUsaTuSaldo.seleccionUsaTuSaldo());
    }


    @And("^Seleccionar opcion contra saldo pq relevo$")
    public void seleccionarContraSaldPqRelevo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarContraSaldoRelevo.seleccionarContraSaldoRelevo());
    }

    @Then("^Validar la notificacion de la compra$")
    public void validarNotificacionCompra() {
        theActorInTheSpotlight().attemptsTo(NotificacionCompra.notificacionCompra());
    }

    @And("^Comprar paq todo incluido 50MB WhatsApp 50 minutos a destinos nacionales$")
    public void comprarPaq50MB50MIN() {
        theActorInTheSpotlight().attemptsTo(Paq50MB_50MIN.paq50MB_50MIN());
    }

}