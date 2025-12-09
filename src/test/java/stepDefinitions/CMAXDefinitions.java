package stepDefinitions;

import cucumber.api.DataTable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import hooks.ReportHooksWeb;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.Cmax.*;
import tasks.SwitchToMobile;
import tasks.SwitchToWeb;
import utils.*;

import static net.serenitybdd.screenplay.actions.Open.url;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.LBL_WHATSAPP;

public class CMAXDefinitions {

    private final User user = TestDataProvider.getRealUser();

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<>();
    private String URL;
    private EnvironmentVariables environmentVariables;

    private ChromeDriver driver;
    private static final Logger LOGGER = Logger.getLogger(CMAXDefinitions.class.getName());

   // @Managed
   // private Actor user = Actor.named("user");

    @Before
    public void getConfiguration() {

        OnStage.setTheStage(new OnlineCast());
        URL = EnviaromentProperties.getProperty("url_prueba");
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

    @Given("^Se ingresa a la URL de CMAX$")
    public void seIngresaALaURLDeCMAX() {
        URL = environmentVariables.getProperty("url_prueba");


        if (URL == null || URL.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL de prueba no está definida.");
        }

        theActorCalled("cmax").attemptsTo(Open.url(URL));
    }


    @When("^Se ingresa el usuario y la contrasena$")
    public void seIngresaElUsuarioYLaContrasena() {
        theActorInTheSpotlight().attemptsTo(RealizarIngreso.realizarIngreso());
    }

    @When("^Se ingresa el numero de la linea en consulta inicial$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaInicial() {
        ReportHooksWeb.setLineaDesdeData(user.getNumero());
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaInicial.ingresarNumeroConsultaInicial());
    }

    @When("^Se ingresa el numero de la linea en consulta final$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaFinal() {
        ReportHooksWeb.setLineaDesdeData(data.get("Numero"));
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaFinal.ingresarNumeroConsultaFinal(data));

    }

    @When("^Se valida el resumen de la cuenta para el SC$")
    public void seValidaElResumenDeLaCuentaParaElSC() {
        theActorInTheSpotlight().attemptsTo(ResumenDeCuenta.resumenDeCuenta());
    }

    @When("^Se validan las ofertas activas en consulta inicial$")
    public void seValidanLasOfertasActivasEnConsultaInicial() {
        theActorInTheSpotlight()
                .attemptsTo(ValidarOfertaConsultaInicial.validarofertaConsultaInicial());
    }

    @When("^Se validan las ofertas activas en contadores$")
    public void seValidanLasOfertasActivasEnContadores() {
        theActorInTheSpotlight().attemptsTo(ValidarOfertaConsultaContadores.validarOfertaConsultaContadores());
    }

    @When("^Se ingresa el numero de la linea en consulta de compra$")
    public void seIngresaElNumeroDeLaLineaEnConsultaDeCompra() {
        ReportHooksWeb.setLineaDesdeData(user.getNumero());
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaCompra.ingresarnumeroConsultaCompra());
    }

    @When("^Se validan las ofertas activas$")
    public void seValidanLasOfertasActivas() {
        theActorInTheSpotlight().attemptsTo(ValidarOfertas.validarOfertas(data));
    }

    @When("^Se valida el historial de contrato$")
    public void seValidaElHistorialDeContrato() {
        theActorInTheSpotlight().attemptsTo(HistorialDeContrato.historialDeContrato(data));
    }

    @When("^Se validan los datos de compra$")
    public void seValidanLosDatosDeCompra() {
        theActorInTheSpotlight().attemptsTo(ValidarDatosCompra.validarDatosCompra());
    }

    @Then("^Se verifican firmas y factor multiplicador$")
    public void seVerificanFirmasYFactorMultiplicador() {
        theActorInTheSpotlight()
                .attemptsTo(ValidarFirmaYFactorMultiplicador.validarFirmaYFactorMultiplicador());
    }

    @Then("^Validar contadores de uso consumo de voz$")
    public void validarContadoresDeUsoConsumoDeVoz() {
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeVoz.contadorDeUsoConsumoDeVoz(data));
    }

    @Then("^Validar contadores de uso consumo iniciales$")
    public void validarContadoresDeUsoConsumoIniciales() {
        theActorInTheSpotlight().attemptsTo(ContadorUsoIniciales.contadorusoIniciales());
    }

    @Then("^Validar contadores de uso consumo de SMS$")
    public void validarContadoresDeUsoConsumoDeSMS() {
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeSMS.contadorDeUsoConsumoDeSMS(data));
    }


    @Then("^Validar contadores de uso consumo de Datos$")
    public void validarContadoresDeUsoConsumoDeDatos() {
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeDatos.contadorDeUsoConsumoDeDatos(data));
    }

    @When("^Se validan las cuentas dedicadas$")
    public void seValidanLasCuentasDedicadas() {
        theActorInTheSpotlight().attemptsTo(CuentasDedicadas.cuentasDedicadas());
    }

    @When("^Se validan los acumuladores de uso$")
    public void seValidanLosAcumuladoresDeUso() {
        theActorInTheSpotlight().attemptsTo(AcumuladoresDeUso.acumuladoresDeUso());
    }

    @When("^cambia al contexto móvil$")
    public void cambiaAlContextoMovil() {
        theActorInTheSpotlight().attemptsTo(
                SwitchToMobile.toApp("com.whatsapp", ".Main"));
    }

    @When("^abre WhatsApp$")
    public void abreWhatsApp() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LBL_WHATSAPP, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }

    @And("^cambia al contexto web$")
    public void cambiaAlContextoWeb() {
        LOGGER.info("Cambiando a contexto web - CMAX");

        URL = environmentVariables.getProperty("url_prueba");


        theActorInTheSpotlight().attemptsTo(
                SwitchToWeb.toCmax(URL)
        );
    }


}