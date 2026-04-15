package stepDefinitions;


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
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.Cmax.*;
import tasks.SwitchToMobile;
import tasks.SwitchToWeb;
import utils.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.LBL_WHATSAPP;

public class CMAXDefinitions {

    private final User user = TestDataProvider.getRealUser();
    private User userCompra;

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<>();
    private String URL;
    private EnvironmentVariables environmentVariables;

    private ChromeDriver driver;
    private static final Logger LOGGER = Logger.getLogger(CMAXDefinitions.class.getName());

    /**
     * Retorna true cuando se quiere ejecutar SOLO la compra en el canal,
     * saltando todas las validaciones de CMAX (inicial y final).
     * Se controla desde test.properties: solo.compra.canal = true/false
     */
    private boolean soloCompraCanal() {
        try {
            java.util.Properties props = new java.util.Properties();
            props.load(getClass().getResourceAsStream("/test.properties"));
            return Boolean.parseBoolean(props.getProperty("solo.compra.canal", "false"));
        } catch (Exception e) {
            LOGGER.warn("No se pudo leer solo.compra.canal desde test.properties, se asume false");
            return false;
        }
    }

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

    public void cargarDatos() {
        userCompra = JsonDataProvider.getUserCompra();
    }

    @Given("^Se ingresa a la URL de CMAX$")
    public void seIngresaALaURLDeCMAX() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando CMAX - inicializando actor para el canal");
            // Es necesario inicializar el actor en el escenario aunque no se abra CMAX.
            // De lo contrario, theActorInTheSpotlight() lanza NullPointerException
            // cuando llega el paso "cambia al contexto movil".
            theActorCalled("canal");
            return;
        }
        URL = environmentVariables.getProperty("url_prueba");

        if (URL == null || URL.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL de prueba no está definida.");
        }

        theActorCalled("cmax").attemptsTo(Open.url(URL));
    }


    @When("^Se ingresa el usuario y la contrasena$")
    public void seIngresaElUsuarioYLaContrasena() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se ingresa el usuario y la contrasena");
            return;
        }
        theActorInTheSpotlight().attemptsTo(RealizarIngreso.realizarIngreso());
    }

    @When("^Se ingresa el numero de la linea en consulta inicial$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaInicial() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se ingresa el numero de la linea en consulta inicial");
            return;
        }
        ReportHooksWeb.setLineaDesdeData(user.getNumeroCmax());
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaInicial.ingresarNumeroConsultaInicial());
    }

    @When("^Se ingresa el numero de la linea en consulta final$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaFinal() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se ingresa el numero de la linea en consulta final");
            return;
        }
        ReportHooksWeb.setLineaDesdeData(user.getNumeroCmax());
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaFinal.ingresarNumeroConsultaFinal());

    }

    @When("^Se valida el resumen de la cuenta para el SC$")
    public void seValidaElResumenDeLaCuentaParaElSC() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se valida el resumen de la cuenta para el SC");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ResumenDeCuenta.resumenDeCuenta());
    }

    @When("^Se validan las ofertas activas en consulta inicial$")
    public void seValidanLasOfertasActivasEnConsultaInicial() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan las ofertas activas en consulta inicial");
            return;
        }
        theActorInTheSpotlight()
                .attemptsTo(ValidarOfertaConsultaInicial.validarofertaConsultaInicial());
    }

    @When("^Se validan las ofertas activas en contadores$")
    public void seValidanLasOfertasActivasEnContadores() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan las ofertas activas en contadores");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ValidarOfertaConsultaContadores.validarOfertaConsultaContadores());
    }

    @When("^Se ingresa el numero de la linea en consulta de compra$")
    public void seIngresaElNumeroDeLaLineaEnConsultaDeCompra() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se ingresa el numero de la linea en consulta de compra");
            return;
        }
        ReportHooksWeb.setLineaDesdeData(user.getNumeroCmax());
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaCompra.ingresarnumeroConsultaCompra());
    }

    @When("^Se validan las ofertas activas$")
    public void seValidanLasOfertasActivas() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan las ofertas activas");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ValidarOfertas.validarOfertas());
    }

    @When("^Se valida el historial de contrato$")
    public void seValidaElHistorialDeContrato() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se valida el historial de contrato");
            return;
        }
        theActorInTheSpotlight().attemptsTo(HistorialDeContrato.historialDeContrato());
    }

    @When("^Se validan los datos de compra$")
    public void seValidanLosDatosDeCompra() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan los datos de compra");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ValidarDatosCompra.validarDatosCompra());
    }

    @Then("^Se verifican firmas y factor multiplicador$")
    public void seVerificanFirmasYFactorMultiplicador() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se verifican firmas y factor multiplicador");
            return;
        }
        theActorInTheSpotlight()
                .attemptsTo(ValidarFirmaYFactorMultiplicador.validarFirmaYFactorMultiplicador());
        WordWebReport.main();
    }

    @Then("^Validar contadores de uso consumo de voz$")
    public void validarContadoresDeUsoConsumoDeVoz() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Validar contadores de uso consumo de voz");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeVoz.contadorDeUsoConsumoDeVoz());
    }

    @Then("^Validar contadores de uso consumo iniciales$")
    public void validarContadoresDeUsoConsumoIniciales() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Validar contadores de uso consumo iniciales");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ContadorUsoIniciales.contadorusoIniciales());
    }

    @Then("^Validar contadores de uso consumo de SMS$")
    public void validarContadoresDeUsoConsumoDeSMS() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Validar contadores de uso consumo de SMS");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeSMS.contadorDeUsoConsumoDeSMS());
    }


    @Then("^Validar contadores de uso consumo de Datos$")
    public void validarContadoresDeUsoConsumoDeDatos() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Validar contadores de uso consumo de Datos");
            return;
        }
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeDatos.contadorDeUsoConsumoDeDatos());
    }

    @When("^Se validan las cuentas dedicadas$")
    public void seValidanLasCuentasDedicadas() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan las cuentas dedicadas");
            return;
        }
        theActorInTheSpotlight().attemptsTo(CuentasDedicadas.cuentasDedicadas());
    }

    @When("^Se validan los acumuladores de uso$")
    public void seValidanLosAcumuladoresDeUso() {
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: Se validan los acumuladores de uso");
            return;
        }
        theActorInTheSpotlight().attemptsTo(AcumuladoresDeUso.acumuladoresDeUso());
    }

    @When("^cambia al contexto móvil$")
    public void cambiaAlContextoMovil() {
        theActorInTheSpotlight().attemptsTo(
                SwitchToMobile.toApp("com.whatsapp", ".Main"));
    }

    @When("^cambia al contexto movil USSD$")
    public void cambiaAlContextoMovilUSSD() {
        theActorInTheSpotlight().attemptsTo(
                SwitchToMobile.toApp("com.google.android.dialer", ".activities.CallLogActivity"));
    }

    @And("^cambia al contexto movil mi claro app$")
    public void cambiaAlContextoMovilMiClaroApp() {
        theActorInTheSpotlight().attemptsTo(
                SwitchToMobile.toApp("com.clarocolombia.miclaro", "com.claro.superapp.SplashActivity"));
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
        if (soloCompraCanal()) {
            LOGGER.info("[SOLO CANAL] Saltando: cambia al contexto web (validacion CMAX final)");
            return;
        }
        LOGGER.info("Cambiando a contexto web - CMAX");

        URL = environmentVariables.getProperty("url_prueba");

        theActorInTheSpotlight().attemptsTo(
                SwitchToWeb.toCmax(URL)
        );
    }


}