package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import models.User;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.USSD.*;
import tasks.USSD.PaquetesDatos.SeleccionarPaquete;
import utils.TestDataProvider;
import utils.WordAppium;

import java.io.File;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.canales.USSDPaquetesDatosConstants.*;


public class CompraPaquetesUSDDefinitions {

    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());
    private final User user = TestDataProvider.getRealUser();


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

    String filePath = "src/test/resources/data/Usuario.xlsx";
    String sheetName = "Datos";


    @Given("^Se realiza la llamada al numero (.*)$")
    public void realizaUnaLlamadaAlNumero(String numero) {

        theActorInTheSpotlight().attemptsTo(RealizarLlamada.alNumero(numero));


    }

    @When("^Se ingresa la opcion compra de paquetes$")
    public void seIngresaOpcionCompraPaquetes() {
        theActorInTheSpotlight().attemptsTo(SeleccionarConsultaSaldo.selectOption("Consulta de saldo y consumos"));
        theActorInTheSpotlight().attemptsTo(SeleccionarConsultaSaldo.selectOption("Consulta de saldo y numero"));
        theActorInTheSpotlight().attemptsTo(SeleccionarCompraPaquetes.selectOption("Compra tu paquete"));

    }

    @When("^Se selecciona el tipo de paquete a comprar$")
    public void seSeleccionaElTipoDePaqueteAComprar() {

        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(user.getTipoPaquete()));

    }

    @When("^Se selecciona la categoria paquete de datos$")
    public void seSeleccionaLaCategoriaPaqueteDeDatos() {
        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(CATEGORIA_PAQUETE_DATOS));
    }

    @Then("^Seleccionar el tipo de paquete datos$")
    public void seleccionarElTipoDePaqueteDatos() {
        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(CATEGORIA_PAQUETE_DATOS));
    }

    @Then("^Seleccionar paquete todo incluido$")
    public void seleccionarPaqueteTodoIncluido() {
        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(CATEGORIA_PAQUETE_TODO_INCLUIDO));
    }

    @Then("^Seleccionar paquete de voz$")
    public void seleccionarPaqueteDeVoz() {
        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(CATEGORIA_PAQUETE_VOZ));
    }


    @When("^Se realiza la compra del paquete$")
    public void seRealizaLaCompraDelPaquete() {

        theActorInTheSpotlight().attemptsTo(RealizarCompraPaquete.comprapaquete(user.getPaqueteComprar()));
    }

    @When("^Se selecciona el paquete de datos (.*)$")
    public void seSeleccionaElPaqueteDeDatos(String paquete) {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(paquete));
    }

    @Then("^Compra del paquete datos 1Dia 200MB nav WhatsAPP$")
    public void compraDelPaqueteDatos1Dia200MbNavWhatsapp() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_200_MB));
    }

    @Then("^Compra del paquete datos 1Dia 400MB nav WFX$")
    public void compraDelPaqueteDatos1Dia400MbNavWfx() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_400_MB));
    }

    @Then("^Compra del paquete datos 3 dias 800MB nav WFX$")
    public void compraDelPaqueteDatos1Dia800MbNavWfx() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_800_MB));
    }

    @Then("^Compra del paquete datos 2 horas nav ilimitada$")
    public void compraDelPaqueteDatos2HNavIlim() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_2_HORAS));
    }

    @Then("^Compra del paquete datos 7 dias 2GB nav WFX$")
    public void compraDelPaqueteDatos7Dias2GBNavWfx() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_2_GB));
    }

    @Then("^Compra del paquete todo incluido 3 dias 400MB WFX Voz$")
    public void compraDelPaqueteTodoIncluido3Dias400MBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_400MB));
    }

    @Then("^Compra del paquete todo incluido 6 dias 1.4GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido6Dias14MBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_1_4_GB));
    }

    @Then("^Compra del paquete todo incluido 7 dias 2GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido7Dias2GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_2_GB));
    }

    @Then("^Compra del paquete todo incluido 7 dias 10GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido7Dias10GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_10_GB));
    }

    @Then("^Compra del paquete todo incluido 20 dias 7.5GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido20Dias75GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_7_5_GB));
    }

    @Then("^Compra del paquete todo incluido 10 dias 3.5GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido10Dias35GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_3_5_GB));
    }

    @Then("^Compra del paquete todo incluido 30 dias 12GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido30Dias12GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_12_GB));
    }

    @Then("^Compra del paquete todo incluido 30 dias 18GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido30Dias18GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_18_GB));
    }

    @Then("^Compra del paquete todo incluido 15 dias 20GB Voz$")
    public void compraDelPaqueteTodoIncluido15Dias20GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_20_GB));
    }

    @Then("^Compra del paquete todo incluido 30 dias 30GB Voz$")
    public void compraDelPaqueteTodoIncluido30Dias30GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_30_GB));
    }

    @Then("^Compra del paquete todo incluido 30 dias 80GB WFX Voz$")
    public void compraDelPaqueteTodoIncluido30Dias80GBWFXVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_80_GB));
    }

    @Then("^Compra del paquete todo incluido 6 dias 1.4GB WFX Salud en linea 4 beneficiarios$")
    public void compraDelPaqueteTodoIncluido6Dias14GBWFXVozSalud() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_1_4_GB_SALUD));
    }

    @Then("^Compra del paquete todo incluido 3 dias 400MB WFX Salud en linea 4 beneficiarios$")
    public void compraDelPaqueteTodoIncluido3Dias400MBWFXVozSalud() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_400_MB_SALUD));
    }

    @Then("^Compra del paquete todo incluido 7 dias 2GB Win$")
    public void compraDelPaqueteTodoIncluido7Dias2GBWIN() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_2_GB_WIN));
    }

    @Then("^Compra del paquete todo incluido 10 dias 3.5GB Win$")
    public void compraDelPaqueteTodoIncluido10Dias35GBWIN() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_3_5_GB_WIN));
    }

    @Then("^Compra del paquete todo incluido 7 dias 10GB Win$")
    public void compraDelPaqueteTodoIncluido7Dias10GBWIN() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_TODO_INCLUIDO_10_GB_WIN));
    }

    @Then("^Compra del paquete de voz 1 dia 300 Minutos$")
    public void compraDelPaqueteVoz1Dia300Min() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_VOZ_300_MIN_1_DIA));
    }

    @Then("^Compra del paquete de voz 2 dias 300 Minutos$")
    public void compraDelPaqueteVoz2Dias300Min() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_VOZ_300_MIN_2_DIAS));
    }

    @Then("^Compra del paquete de voz 20 dias 1000 Minutos$")
    public void compraDelPaqueteVoz20Dias1000Min() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaquete.porNombre(PAQUETE_VOZ_1000_MIN_20_DIAS));
    }


    @When("^Se confirma el pago de la compra$")
    public void seConfirmaElPagoDeLaCompra() {
        theActorInTheSpotlight().attemptsTo(SeleccionarOpcionPago.comprapaquete("Descuento de saldo"));
        theActorInTheSpotlight().attemptsTo(ValidarMensajeConfirmacion.deCompra());


    }
}
