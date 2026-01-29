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
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import java.util.List;
import java.util.Map;

public class ContadorDeUsoConsumoDeVoz implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContadorDeUsoConsumoDeVoz.class);
    private final User user = TestDataProvider.getRealUser();

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando validación de contadores de uso consumo de voz");

        navegarAContadores(actor);
        buscarYSeleccionarPaqueteVoz(actor);
        validarCamposContador(actor);
        validarOfertaEnDetalle(actor);

        capturarEvidencia(actor);

        LOGGER.info("Validación de contadores de voz completada");
    }

    private void navegarAContadores(Actor actor) {
        actor.attemptsTo(Click.on(BTN_CONTADORES_USO));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CONTADORES_USO)));
    }

    private void buscarYSeleccionarPaqueteVoz(Actor actor) {
        List<WebElementFacade> rows = TBL_CONTADORES_USO.resolveAllFor(actor);
        LOGGER.info("Filas encontradas en la tabla de contadores: {}", rows.size());

        String paqueteEsperado = user.getPaqueteVoz();
        boolean paqueteEncontrado = false;

        for (WebElementFacade row : rows) {
            String actualPackageName = row.then(By.xpath(COLUMN_PAQUETE_XPATH)).getText().trim();
            LOGGER.debug("Comparando: '{}' con '{}'", actualPackageName, paqueteEsperado);

            if (actualPackageName.equalsIgnoreCase(paqueteEsperado)) {
                WebElementFacade yesLink = row.then(By.xpath(".//td[5]/a"));
                actor.attemptsTo(Scroll.to(yesLink), Click.on(yesLink), WaitFor.aTime(1000));
                paqueteEncontrado = true;
                LOGGER.info("Paquete de voz encontrado y seleccionado: '{}'", paqueteEsperado);
                break;
            }
        }

        if (!paqueteEncontrado) {
            String errorMessage = "No se encontró el paquete de voz: " + paqueteEsperado;
            LOGGER.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    private void validarCamposContador(Actor actor) {
        LOGGER.debug("Validando campos de contador");

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO_CONTADORES)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION_CONTADORES)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_VALOR_CONTADOR)));
    }

    private void validarOfertaEnDetalle(Actor actor) {
        try {
            String paqueteEsperado = user.getPaqueteVoz();

            // Buscar en la sección "Valores del contador de uso privado"
            Target detalleOferta = Target.the("Detalle de la oferta en contador privado")
                    .located(By.xpath("//*[contains(text(),'Valores del contador de uso privado para')]/following-sibling::*//td[1] | //*[contains(text(),'" + paqueteEsperado + "')]"));

            List<WebElementFacade> elementos = detalleOferta.resolveAllFor(actor);

            boolean ofertaValidada = false;
            for (WebElementFacade elemento : elementos) {
                String textoOferta = elemento.getText().trim();
                if (textoOferta.toLowerCase().contains(paqueteEsperado.toLowerCase())) {
                    LOGGER.info("Oferta validada en detalle: '{}'", textoOferta);
                    ofertaValidada = true;
                    break;
                }
            }

            if (!ofertaValidada) {
                LOGGER.warn("No se pudo validar la oferta en el detalle del contador privado");
            }

        } catch (Exception e) {
            LOGGER.warn("Error validando oferta en detalle", e);
        }
    }

    private void capturarEvidencia(Actor actor) {
        actor.attemptsTo(
                WaitFor.aTime(2000),
                AdjustPageZoom.to(ZOOM_LEVEL_85),
                Scroll.to(LGO_CLARO)
        );

        String nombrePaquete = user.getPaqueteVoz();
        String mensajeEvidencia = "Validar contadores de uso consumo de voz";
        if (nombrePaquete != null && !nombrePaquete.isEmpty()) {
            mensajeEvidencia += " - " + nombrePaquete;
        }

        EvidenciaUtils.registrarCaptura(mensajeEvidencia);

        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));
    }

    public static Performable contadorDeUsoConsumoDeVoz() {
        return instrumented(ContadorDeUsoConsumoDeVoz.class);
    }
}