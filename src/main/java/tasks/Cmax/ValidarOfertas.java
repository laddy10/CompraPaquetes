package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.*;

import interactions.WaitElement;
import interactions.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

import java.util.List;
import java.util.Map;

public class ValidarOfertas implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarOfertas.class);

    private final Map<String, String> data;

    public ValidarOfertas(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando validación de ofertas activas");

        navegarAOfertas(actor);
        validarCamposOferta(actor);

        EvidenciaUtils.registrarCaptura(PASO_VALIDACION_OFERTAS);

        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));
        buscarYSeleccionarPaquete(actor);

        LOGGER.info("Validación de ofertas activas completada exitosamente");
    }

    private void navegarAOfertas(Actor actor) {
        LOGGER.debug("Navegando a la sección de ofertas");

        actor.attemptsTo(
                WaitElement.isClickable(BTN_OFERTAS),
                Click.on(BTN_OFERTAS),
                Click.on(BTN_FECHA_INICIO),
                Click.on(BTN_FECHA_INICIO2),
                WaitFor.aTime(1000),
                AdjustPageZoom.to(ZOOM_LEVEL_75),
                WaitFor.aTime(1000)
        );
    }

    private void validarCamposOferta(Actor actor) {
        LOGGER.debug("Validando campos de ofertas");

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION2)));

        LOGGER.debug("Todos los campos de ofertas validados correctamente");
    }

    private void buscarYSeleccionarPaquete(Actor actor) {
        String paqueteBuscado = data.get("paquete");
        LOGGER.info("Buscando paquete: '{}'", paqueteBuscado);

        List<WebElementFacade> filas = TBL_OFERTAS.resolveAllFor(actor);
        LOGGER.info("Se encontraron {} filas en la tabla de ofertas", filas.size());

        boolean paqueteEncontrado = false;

        for (int i = 0; i < filas.size(); i++) {
            WebElementFacade fila = filas.get(i);
            WebElementFacade celdaPaquete = fila.then(By.xpath(COLUMN_PAQUETE_XPATH));
            String nombrePaqueteActual = celdaPaquete.getText().trim();

            LOGGER.debug("Fila {}: Paquete encontrado: '{}'", (i + 1), nombrePaqueteActual);

            if (nombrePaqueteActual.equals(paqueteBuscado)) {
                LOGGER.info("Paquete encontrado en fila {}", (i + 1));

                WebElementFacade enlace = fila.then(By.xpath(COLUMN_LINK_XPATH));
                actor.attemptsTo(
                        Scroll.to(enlace),
                        WaitFor.aTime(500),
                        Click.on(enlace)
                );

                paqueteEncontrado = true;
                LOGGER.info("Clic realizado en el enlace del paquete: '{}'", paqueteBuscado);
                break;
            }
        }

        if (!paqueteEncontrado) {
            String errorMessage = "ERROR: No se encontró el paquete en la tabla: " + paqueteBuscado;
            LOGGER.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    public static Performable validarOfertas(Map<String, String> data) {
        return instrumented(ValidarOfertas.class, data);
    }
}