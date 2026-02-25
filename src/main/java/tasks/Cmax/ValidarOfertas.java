package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.*;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.ValidateInformationText;
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
import utils.mappers.PaquetesMapper;

import java.util.List;

public class ValidarOfertas implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarOfertas.class);

    @Override
    public <T extends Actor> void performAs(T actor) {

        LOGGER.info("Iniciando validación de ofertas activas en CMAX");

        navegarAOfertas(actor);
        validarCamposOferta(actor);

        EvidenciaUtils.registrarCaptura(PASO_VALIDACION_OFERTAS);

        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));

        buscarYSeleccionarPaquete(actor);

        LOGGER.info("Validación de ofertas completada exitosamente");
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

        LOGGER.debug("Validando campos generales de la tabla de ofertas");

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION2)));

        LOGGER.debug("Campos generales validados correctamente");
    }

    private void buscarYSeleccionarPaquete(Actor actor) {

        String paqueteBuscado;

        // 🔎 Detectar si es internacional
        Boolean esInternacional = actor.recall("ES_INTERNACIONAL");

        if (Boolean.TRUE.equals(esInternacional)) {

            String precioSeleccionado = actor.recall("PRECIO_SELECCIONADO");

            if (precioSeleccionado == null) {
                throw new AssertionError(
                        "No existe PRECIO_SELECCIONADO en memoria para paquete internacional.");
            }

            paqueteBuscado = PaquetesMapper
                    .obtenerNombreCmaxInternacional(precioSeleccionado);

            LOGGER.info("Internacional detectado.");
            LOGGER.info("Precio seleccionado: '{}'", precioSeleccionado);

        } else {

            // 🔎 Flujo normal
            String paqueteCanal = actor.recall("PAQUETE_CANAL");

            if (paqueteCanal == null) {
                throw new AssertionError(
                        "No existe PAQUETE_CANAL en memoria del actor.");
            }

            paqueteBuscado = PaquetesMapper
                    .obtenerNombreCMAX(paqueteCanal);

            LOGGER.info("Paquete canal: '{}'", paqueteCanal);
        }

        LOGGER.info("Nombre esperado en CMAX: '{}'", paqueteBuscado);

        List<WebElementFacade> filas = TBL_OFERTAS.resolveAllFor(actor);

        LOGGER.info("Se encontraron {} filas en la tabla de ofertas", filas.size());

        boolean paqueteEncontrado = false;

        for (int i = 0; i < filas.size(); i++) {

            WebElementFacade fila = filas.get(i);
            WebElementFacade celdaPaquete =
                    fila.then(By.xpath(COLUMN_PAQUETE_XPATH));

            String nombrePaqueteActual =
                    celdaPaquete.getText().trim();

            LOGGER.debug("Fila {}: '{}'", (i + 1), nombrePaqueteActual);

            if (nombrePaqueteActual.equalsIgnoreCase(paqueteBuscado)) {

                LOGGER.info("Paquete encontrado en fila {}", (i + 1));

                WebElementFacade enlace =
                        fila.then(By.xpath(COLUMN_LINK_XPATH));

                actor.attemptsTo(
                        Scroll.to(enlace),
                        WaitFor.aTime(500),
                        Click.on(enlace)
                );

                paqueteEncontrado = true;
                break;
            }
        }

        if (!paqueteEncontrado) {
            throw new AssertionError(
                    "No se encontró el paquete en CMAX. Esperado: "
                            + paqueteBuscado);
        }
    }

    public static Performable validarOfertas() {
        return instrumented(ValidarOfertas.class);
    }
}