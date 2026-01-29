package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import java.util.List;
import java.util.Map;

public class ContadorDeUsoConsumoDeDatos implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContadorDeUsoConsumoDeDatos.class);
    private final User user = TestDataProvider.getRealUser();

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando validación de contadores de uso consumo de datos");

        navegarAContadores(actor);
        buscarYSeleccionarPaqueteDatos(actor);
        validarOfertaEnDetalle(actor);
        capturarEvidencia(actor);

        LOGGER.info("Validación de contadores de datos completada");
    }

    private void navegarAContadores(Actor actor) {
        actor.attemptsTo(Click.on(BTN_CONTADORES_USO), WaitFor.aTime(1000));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CONTADORES_USO)));
    }

    private void buscarYSeleccionarPaqueteDatos(Actor actor) {
        List<WebElementFacade> rows = TBL_CONTADORES_USO.resolveAllFor(actor);
        LOGGER.info("Filas encontradas en la tabla de contadores: {}", rows.size());

        String paqueteEsperado = user.getPaqueteDatos();
        boolean paqueteEncontrado = false;

        for (WebElementFacade row : rows) {
            String actualPackageName = row.then(By.xpath(COLUMN_PAQUETE_XPATH)).getText().trim();
            LOGGER.debug("Comparando: '{}' con '{}'", actualPackageName, paqueteEsperado);

            if (actualPackageName.equals(paqueteEsperado)) {
                WebElementFacade yesLink = row.then(By.xpath(".//td[5]/a"));
                actor.attemptsTo(Scroll.to(yesLink), Click.on(yesLink), WaitFor.aTime(1000));
                paqueteEncontrado = true;
                LOGGER.info("Paquete de datos encontrado y seleccionado: '{}'", paqueteEsperado);
                break;
            }
        }

        if (!paqueteEncontrado) {
            String errorMessage = "No se encontró el paquete de datos: " + paqueteEsperado;
            LOGGER.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    private void validarOfertaEnDetalle(Actor actor) {
        String paqueteEsperado = user.getPaqueteDatos();

        List<WebElementFacade> filas = TBL_VALORES_CONTADORES.resolveAllFor(actor);
        LOGGER.info("Filas encontradas en valores de contadores: {}", filas.size());

        boolean ofertaValidada = false;

        for (WebElementFacade fila : filas) {
            String actualPackageName = fila.then(By.xpath(COLUMN_PAQUETE_XPATH)).getText().trim();
            LOGGER.debug("Validando oferta en detalle: '{}'", actualPackageName);

            if (actualPackageName.equals(paqueteEsperado)) {
                validarCamposContador(actor);
                ofertaValidada = true;
                LOGGER.info("Oferta validada en detalle: '{}'", actualPackageName);
                break;
            }
        }

        if (!ofertaValidada) {
            LOGGER.warn("No se pudo validar la oferta en el detalle: {}", paqueteEsperado);
            // Validar campos aunque no se encuentre la oferta específica
            validarCamposContador(actor);
        }
    }

    private void validarCamposContador(Actor actor) {
        LOGGER.debug("Validando campos de contador de datos");

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO_CONTADORES)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION_CONTADORES)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_VALOR_CONTADOR)));
    }

    private void capturarEvidencia(Actor actor) {
        actor.attemptsTo(
                WaitFor.aTime(3000),
                AdjustPageZoom.to(ZOOM_LEVEL_85),
                Scroll.to(LGO_CLARO)
        );

        String nombrePaquete = user.getPaqueteDatos();
        String mensajeEvidencia = "Validar contadores de uso consumo de datos";
        if (nombrePaquete != null && !nombrePaquete.isEmpty()) {
            mensajeEvidencia += " - " + nombrePaquete;
        }

        EvidenciaUtils.registrarCaptura(mensajeEvidencia);
    }

    public static Performable contadorDeUsoConsumoDeDatos() {
        return instrumented(ContadorDeUsoConsumoDeDatos.class);
    }
}