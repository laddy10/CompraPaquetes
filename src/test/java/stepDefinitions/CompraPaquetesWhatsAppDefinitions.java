package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;
import interactions.WaitForResponse;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.WaitForTextContains;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import questions.ValidarElemento;
import tasks.WhatsApp.*;
import tasks.WhatsApp.Apps.SeleccionarPqApps;
import tasks.WhatsApp.Datos.*;
import tasks.WhatsApp.Internacional.*;
import tasks.WhatsApp.TodoIncluido.*;
import tasks.WhatsApp.Voz.PaqVoz1000MinX20Dias;
import tasks.WhatsApp.Voz.PaqVoz300MinX1Dia;
import tasks.WhatsApp.Voz.PaqVoz300MinX2Dias;
import tasks.WhatsApp.Voz.SeleccionarPaqVoz;
import utils.WordAppium;

import java.io.File;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

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

    @And("^Seleccionar el tipo de paquete de voz$")
    public void seleccionarTipoPaqueteVoz() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqVoz.seleccionarPaqVoz());
    }

    @And("^Seleccionar el tipo de paquete de datos$")
    public void seleccionarTipoPaqueteDatos() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqDatos.seleccionarPaqDatos());
    }

    @And("^Seleccionar el tipo de paquete internacionales$")
    public void seleccionarTipoPaqueteInternacionales() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqueteInternacional.seleccionarPaqueteInternacional());
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

    @And("^Comprar paq todo incluido 400MB WFT Voz ilimitada nacional$")
    public void comprarPaq400MBWFTVoz() {
        theActorInTheSpotlight().attemptsTo(Paq400MB_WFT_VozIlimi.paq400MB_WFT_VozIlimi());
    }

    @And("^Comprar paq todo incluido 1.4 GB WFT Voz ilimitada nacional$")
    public void comprarPaq14GBWFTVozIlim() {
        theActorInTheSpotlight().attemptsTo(Paq1_4GB_WFT_VozIlimi.paq1_4GB_WFT_VozIlimi());
    }

    @And("^Comprar paq todo incluido 2GB WFT Voz ilimitada nacional SMS$")
    public void comprarPaq2GBWFTVozIlimSMS() {
        theActorInTheSpotlight().attemptsTo(Paq2GB_WFT_VozIlimiSMS.paq2GB_WFT_VozIlimiSMS());
    }

    @And("^Comprar paq todo incluido 3.5 GB WFT Voz ilimitada nacional$")
    public void comprarPaq3_5GBWFTVozIlim() {
        theActorInTheSpotlight().attemptsTo(Paq3_5GB_WFT_VozIlimi.paq3_5GB_WFT_VozIlimi());
    }

    @And("^Comprar paq todo incluido 10GB Voz y SMS ilimitada nacional$")
    public void comprarPaq10GBVozSMSIlim() {
        theActorInTheSpotlight().attemptsTo(Paq10GB_VozSMSIlimi.paq10GB_VozSMSIlimi());
    }

    @And("^Comprar paq todo incluido 7.5 GB WFT Voz y SMS ilimitada nacional$")
    public void comprarPaq7_5GBWFTVozSMSIlim() {
        theActorInTheSpotlight().attemptsTo(Paq7_5GB_WFTVozSMSIlimi.paq7_5GB_WFTVozSMSIlimi());

    }

    @And("^Comprar paq todo incluido 20GB de Navegacion Voz y SMS Ilimitados$")
    public void comprarPaq20GBVozSMSIlim() {
        theActorInTheSpotlight().attemptsTo(Paq20GB_VozSMSIlimi.paq20GB_VozSMSIlimi());
    }

    @And("^Comprar paq todo incluido 12 GB WFT Voz nacional$")
    public void comprarPaq12GBWFTVozNacional() {
        theActorInTheSpotlight().attemptsTo(Paq12GBWFTVozNacional.paq12GBWFTVozNacional());
    }

    @And("^Comprar paq todo incluido 30 GB Voz y SMS Ilimitados$")
    public void comprarPaq30GBVozSMSNacional() {
        theActorInTheSpotlight().attemptsTo(Paq30GBVozSMSNacional.paq30GBVozSMSNacional());
    }

    @And("^Comprar paq todo incluido 18 GB WFT Voz ilimitada$")
    public void comprarPaq18GBWFTVozIlimitada() {
        theActorInTheSpotlight().attemptsTo(Paq18GBWFTVozIlim.paq18GBWFTVozIlim());
    }

    @And("^Comprar paq todo incluido 80 GB WFT Voz ilimitada$")
    public void comprarPaq80GBWFTVozIlimitada() {
        theActorInTheSpotlight().attemptsTo(Paq80GBWFTVozIlim.paq80GBWFTVozIlim());
    }

    @And("^Comprar paq todo incluido 400 MB WFT salud 4 beneficiarios$")
    public void comprarPaq400MBWFTSalud4Ben() {
        theActorInTheSpotlight().attemptsTo(Paq400MBWFTSalud4Beneficiarios.paq400MBWFTSalud4Beneficiarios());
    }

    @And("^Comprar paq todo incluido 1.4 GB WFT salud 4 beneficiarios$")
    public void comprarPaq1_4GBWFTSalud4Ben() {
        theActorInTheSpotlight().attemptsTo(Paq1_4GBWFTSalud4Beneficiarios.paq1_4GBWFTSalud4Beneficiarios());
    }

    @And("^Comprar paq voz 300 minutos a todo operador nacional x 1 dia$")
    public void comprarPaqVoz300Min1Dia() {
        theActorInTheSpotlight().attemptsTo(PaqVoz300MinX1Dia.paq3_5GB_WFT_VozIlimi());
    }

    @And("^Comprar paq voz 300 minutos a todo operador nacional x 2 dias$")
    public void comprarPaqVoz300Min2Dias() {
        theActorInTheSpotlight().attemptsTo(PaqVoz300MinX2Dias.paqVoz300MinX2Dias());
    }

    @And("^Comprar paq voz 1000 minutos a todo operador nacional x 20 dias$")
    public void comprarPaqVoz1000Min20Dias() {
        theActorInTheSpotlight().attemptsTo(PaqVoz1000MinX20Dias.paqVoz1000MinX20Dias());
    }

    @And("^Comprar paq de datos 200MB WhatsApp$")
    public void comprarPaqDatos200MBWhatsApp() {
        theActorInTheSpotlight().attemptsTo(PaqDatos200MBWH.paqDatos200MBWH());
    }

    @And("^Comprar paq de datos 400MB navegación WhatsApp Facebook Twitter$")
    public void comprarPaqDatos400MBWFT() {
        theActorInTheSpotlight().attemptsTo(PaqDatos400MBWFT.paqDatos400MBWFT());
    }

    @And("^Comprar paq de datos 800MB navegación WhatsApp Facebook Twitter$")
    public void comprarPaqDatos800MBWFT() {
        theActorInTheSpotlight().attemptsTo(PaqDatos800MBWFT.paqDatos800MBWFT());
    }

    @And("^Comprar paq datos ilimitados$")
    public void comprarPaqDatosIlimitados() {
        theActorInTheSpotlight().attemptsTo(PaqDatosIlimitados.paqDatosIlimitados());
    }


    @And("^Comprar paq datos 2 GB navegación WhatsApp Facebook Twitter$")
    public void comprarPaqDatos2GBWFT() {
        theActorInTheSpotlight().attemptsTo(PaqDatos2GBWFT.paqDatos2GBWFT());
    }

    @And("^Comprar paq LDI USA CAN PR MEX 60 Minutos$")
    public void seleccionarPaqLDIUSACANPRMEX60Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIUSACANPRMEX60Min.paqLDIUSACANPRMEX60Min());
    }

    @And("^Comprar paq LDI USA CAN PR MEX 120 Minutos$")
    public void seleccionarPaqLDIUSACANPRMEX120Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIUSACANPRMEX120Min.paqLDIUSACANPRMEX120Min());
    }

    @And("^Comprar paq LDI USA CAN PR MEX 240 Minutos$")
    public void seleccionarPaqLDIUSACANPRMEX240Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIUSACANPRMEX240Min.paqLDIUSACANPRMEX240Min());
    }

    @And("^Comprar Paq LDI Sin Fronteras 50 Minutos$")
    public void seleccionarPaqLDISinFronteras50Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDISinFronteras50Min.paqLDISinFronteras50Min());
    }

    @And("^Comprar Paq LDI Sin Fronteras 100 Minutos$")
    public void seleccionarPaqLDISinFronteras100Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDISinFronteras100Min.paqLDISinFronteras100Min());
    }

    @And("^Comprar Paq LDI Sin Fronteras 200 Minutos$")
    public void seleccionarPaqLDISinFronteras200Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDISinFronteras200Min.paqLDISinFronteras200Min());
    }


    @And("^Comprar Paq LDI Venezuela 12 minutos$")
    public void seleccionarPaqLDIVenezuela12Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIVenezuela12Minutos.paqLDIVenezuela12Minutos());
    }

    @And("^Comprar Paq LDI Venezuela 30 minutos$")
    public void seleccionarPaqLDIVenezuela30Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIVenezuela30Minutos.paqLDIVenezuela30Minutos());
    }

    @And("^Comprar Paq LDI Preferencial 50 minutos$")
    public void seleccionarPaqLDIPreferencial50Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIPreferencial50Minutos.paqLDIPreferencial50Minutos());
    }


    @And("^Comprar Paq LDI Preferencial 100 minutos$")
    public void seleccionarPaqLDIPreferencial100Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIPreferencial100Minutos.paqLDIPreferencial100Minutos());
    }

    @And("^Comprar Paq LDI Preferencial 200 minutos$")
    public void seleccionarPaqLDIPreferencial200Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIPreferencial200Minutos.paqLDIPreferencial200Minutos());
    }


    @And("^Comprar Paq LDI  Resto del Mundo 50 minutos$")
    public void seleccionarPaqLDIRestoDelMundo50Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIRestoDelMundo50Minutos.paqLDIRestoDelMundo50Minutos());
    }


    @And("^Comprar Paq LDI  Resto del Mundo 100 minutos$")
    public void seleccionarPaqLDIRestoDelMundo100Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIRestoDelMundo100Minutos.paqLDIRestoDelMundo100Minutos());
    }


    @And("^Comprar Paq LDI  Resto del Mundo 200 minutos$")
    public void seleccionarPaqLDIRestoDelMundo200Min() {
        theActorInTheSpotlight().attemptsTo(PaqLDIRestoDelMundo200Minutos.paqLDIRestoDelMundo200Minutos());
    }


    @And("^Comprar Paq Roaming 1GB$")
    public void seleccionarPaqRoaming1GB() {
        theActorInTheSpotlight().attemptsTo(PaqRoaming1GB.paqRoaming1GB());
    }


    @And("^Comprar Paq Roaming 2GB$")
    public void seleccionarPaqRoaming2GB() {
        theActorInTheSpotlight().attemptsTo(PaqRoaming2GB.paqRoaming2GB());
    }


    @And("^Seleccionar Paq LDI USA CAN PR MEX$")
    public void seleccionarPaqLDIUSACANPRMEX() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqLDIUSACANPRMEX.seleccionarPaqLDIUSACANPRMEX());
    }

    @And("^Seleccionar Paq LDI Sin Fronteras$")
    public void seleccionarPaqLDISinFronteras() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqLDISinFronteras.seleccionarPaqLDISinFronteras());
    }

    @And("^Seleccionar Paq LDI Venezuela$")
    public void seleccionarPaqLDIVenezuela() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqLDIVenezuela.seleccionarPaqLDIVenezuela());
    }

    @And("^Seleccionar Paq LDI Preferencial$")
    public void seleccionarPaqLDIPreferencial() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqLDIPreferencial.seleccionarPaqLDIPreferencial());
    }

    @And("^Seleccionar Paq LDI Resto del Mundo$")
    public void seleccionarPaqLDIPRestoDelMundo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqLDIRestoDelMundo.seleccionarPaqLDIRestoDelMundo());
    }


    @And("^Seleccionar Paq. Roaming$")
    public void seleccionarPaqRoaming() {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqRoaming.seleccionarPaqRoaming());
    }

    @And("^Vaciar chat$")
    public void vaciarChat() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_MAS_OPCIONES),
                ClickTextoQueContengaX.elTextoContiene(MAS),
                ClickTextoQueContengaX.elTextoContiene(VACIAR_CHAT),
                Click.on(BTN_VACIAR_CHAT),
                WaitFor.aTime(280000)
        );

    }

}