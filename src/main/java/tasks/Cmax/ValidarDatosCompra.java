package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static utils.Constants.*;

import interactions.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.util.*;

public class ValidarDatosCompra implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarDatosCompra.class);
    private static final Locale COLOMBIA_LOCALE = new Locale("es", "CO");

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Recuperamos el valor dinámico desde el Actor
        String valorBuscado = actor.recall("VALOR_COMPRA");
        LOGGER.info("Valor buscado recuperado del actor: {}", valorBuscado);

        LOGGER.info("Iniciando validación de datos de compra para valor: {}", valorBuscado);

        actor.attemptsTo(WaitUntil.the(TBL_DATOS, WebElementStateMatchers.isVisible()));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TBL_DATOS)));

        List<WebElementFacade> filas = TBL_DATOS.resolveAllFor(actor);
        LOGGER.info("Se encontraron {} filas en la tabla", filas.size());

        // Pasamos valorBuscado como parámetro
        WebElementFacade filaEncontrada = buscarCompraMasReciente(filas, valorBuscado);

        if (filaEncontrada == null) {
            String errorMessage = "ERROR: No se encontró ninguna compra con el valor: " + valorBuscado;
            LOGGER.error(errorMessage);
            throw new AssertionError(errorMessage);
        }

        actor.attemptsTo(WaitFor.aTime(1000));
        filaEncontrada.then(By.xpath(COLUMN_LUPA_XPATH)).click();
        LOGGER.info("Se hizo clic en la lupa de la compra encontrada");

        actor.attemptsTo(
                WaitFor.aTime(2000),
                Scroll.to(LGO_CLARO),
                WaitFor.aTime(1000),
                AdjustPageZoom.to(ZOOM_LEVEL_80)
        );

        validarCamposDetalle(actor);

        String nombrePaquete = extraerNombrePaquete(actor);

        String mensajeEvidencia = PASO_VALIDACION_DATOS_COMPRA + " " + valorBuscado;
        if (!nombrePaquete.isEmpty()) {
            mensajeEvidencia += " - " + nombrePaquete;
        }
        EvidenciaUtils.registrarCaptura(mensajeEvidencia);

        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));

        LOGGER.info("Validación de datos de compra completada exitosamente");
    }

    private WebElementFacade buscarCompraMasReciente(List<WebElementFacade> filas, String valorBuscado) {

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###.##");

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_CMAX, COLOMBIA_LOCALE);
        configurarDateFormatSymbols(dateFormat);

        Date fechaMasReciente = null;
        WebElementFacade filaMasReciente = null;

        for (WebElementFacade fila : filas) {
            String valorCompraTexto = fila.then(By.xpath(COLUMN_VALOR_XPATH)).getText();

            if (valorCompraTexto.isEmpty()) {
                continue;
            }

            if (procesarYCompararValor(valorCompraTexto, valorBuscado, decimalFormat)) {
                Date fechaCompra = procesarFechaCompra(fila, dateFormat);

                if (fechaCompra != null && (fechaMasReciente == null || fechaCompra.after(fechaMasReciente))) {
                    fechaMasReciente = fechaCompra;
                    filaMasReciente = fila;
                    LOGGER.info("Nueva compra más reciente encontrada: {} - {}", valorBuscado, fechaCompra);
                }
            }
        }

        return filaMasReciente;
    }

    private boolean procesarYCompararValor(String valorCompraTexto, String valorBuscado, DecimalFormat decimalFormat) {
        try {
            LOGGER.debug("Comparando: '{}' con valor buscado: '{}'", valorCompraTexto, valorBuscado);

            if (valorBuscado.contains("COP") && valorCompraTexto.contains("COP")) {

                String valorTablaNormalizado = valorCompraTexto
                        .replace("-", "")
                        .trim();

                String valorBuscadoNormalizado = valorBuscado
                        .replace("-", "")
                        .trim();

                boolean coincide = valorTablaNormalizado.equals(valorBuscadoNormalizado);

                if (coincide) {
                    LOGGER.info("Valor coincidente encontrado (texto normalizado): {} = {}",
                            valorTablaNormalizado, valorBuscadoNormalizado);
                }

                return coincide;
            }

            String valorLimpio = valorCompraTexto.replaceAll("[^\\d,]", "");
            String valorBuscadoLimpio = valorBuscado.replaceAll("[^\\d,]", "");

            if (valorLimpio.isEmpty() || valorBuscadoLimpio.isEmpty()) {
                return false;
            }

            Number number = decimalFormat.parse(valorLimpio);
            Number numberBuscado = decimalFormat.parse(valorBuscadoLimpio);

            String valorFormateado = decimalFormat.format(number.doubleValue());
            String valorBuscadoFormateado = decimalFormat.format(numberBuscado.doubleValue());

            boolean coincide = valorFormateado.equals(valorBuscadoFormateado);
            if (coincide) {
                LOGGER.info("Valor coincidente encontrado (numérico): {} = {}", valorFormateado, valorBuscadoFormateado);
            }
            return coincide;

        } catch (ParseException e) {
            LOGGER.warn("No se pudo parsear el valor: '{}' o '{}'", valorCompraTexto, valorBuscado, e);
            return false;
        }
    }

    private Date procesarFechaCompra(WebElementFacade fila, SimpleDateFormat dateFormat) {
        try {
            String fechaHora = fila.then(By.xpath(COLUMN_FECHA_XPATH)).getText();
            LOGGER.debug("Procesando fecha: {}", fechaHora);

            return dateFormat.parse(fechaHora.trim());

        } catch (ParseException e) {
            LOGGER.warn("No se pudo parsear la fecha de la fila", e);
            return null;
        }
    }

    private void configurarDateFormatSymbols(SimpleDateFormat dateFormat) {
        DateFormatSymbols symbols = new DateFormatSymbols(COLOMBIA_LOCALE);
        symbols.setShortMonths(new String[]{"ene", "feb", "mar", "abr", "may", "jun",
                "jul", "ago", "sep", "oct", "nov", "dic"});
        dateFormat.setDateFormatSymbols(symbols);
    }

    private void validarCamposDetalle(Actor actor) {
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_HORA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_ESTADO_CUENTA)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_IMPORTE_AJUSTE)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CUENTA_PRINCIPAL)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_DATOS_EXTERNOS1)));
        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_DATOS_EXTERNOS2)));
    }

    private String extraerNombrePaquete(Actor actor) {
        try {
            Target targetPaquete = Target.the("Nombre del paquete")
                    .located(By.xpath(DATOS_EXTERNOS_XPATH));

            List<WebElementFacade> elementos = targetPaquete.resolveAllFor(actor);

            if (!elementos.isEmpty() && elementos.get(0).isPresent()) {
                return elementos.get(0).getText().trim();
            }
        } catch (Exception e) {
            LOGGER.warn("No se pudo extraer el nombre del paquete", e);
        }
        return "";
    }

    public static Performable validarDatosCompra() {
        return instrumented(ValidarDatosCompra.class);
    }
}