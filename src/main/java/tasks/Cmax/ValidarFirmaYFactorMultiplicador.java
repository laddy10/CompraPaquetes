package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CmaxPage.*;
import static userinterfaces.SegmentoPage.TBL_PRODUCT_ATTRIBUTES;
import static utils.Constants.*;

import interactions.WaitFor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import interactions.comunes.ValidateInformationText;
import utils.EvidenciaUtils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ValidarFirmaYFactorMultiplicador implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarFirmaYFactorMultiplicador.class);
    private static final Locale COLOMBIA_LOCALE = new Locale("es", "CO");

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando validación de firmas y factor multiplicador");

        prepararVista(actor);
        WebElementFacade compraMasReciente = buscarCompraMasReciente(actor);

        if (compraMasReciente != null) {
            compraMasReciente.then(By.xpath(COLUMN_LINK_DETALLE_XPATH)).click();
            LOGGER.info("Clic realizado en la compra más reciente");
        }

        actor.attemptsTo(WaitFor.aTime(2000), Scroll.to(BTN_CERRAR2));

        validarFirmasYFactor(actor);

        String nombrePaquete = extraerNombrePaquete(actor);
        String mensajeEvidencia = PASO_VALIDACION_FIRMAS;
        if (!nombrePaquete.isEmpty()) {
            mensajeEvidencia += " - " + nombrePaquete;
        }
        EvidenciaUtils.registrarCaptura(mensajeEvidencia);

        LOGGER.info("Validación de firmas y factor multiplicador completada");
    }

    private void prepararVista(Actor actor) {
        LOGGER.debug("Preparando vista para validación");

        actor.attemptsTo(
                WaitFor.aTime(2000),
                Scroll.to(BTN_CERRAR2),
                WaitUntil.the(CJA_PRODUCT_ATTRIBUTES, WebElementStateMatchers.isVisible())
        );
    }

    private WebElementFacade buscarCompraMasReciente(Actor actor) {
        List<WebElementFacade> filas = TBL_DETALLE_PRODUCTOS.resolveAllFor(actor);
        LOGGER.info("Se encontraron {} filas en detalle de productos", filas.size());

        if (filas.isEmpty()) {
            LOGGER.warn("No se encontraron filas en la tabla de detalle de productos");
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN_CMAX, COLOMBIA_LOCALE);
        configurarDateFormatSymbols(dateFormat);

        Date fechaMasReciente = null;
        WebElementFacade compraMasReciente = null;

        for (int i = 0; i < filas.size(); i++) {
            WebElementFacade fila = filas.get(i);
            String fechaHoraTexto = fila.then(By.xpath(COLUMN_FECHA_DETALLE_XPATH)).getText();

            LOGGER.debug("Fila {}: Fecha encontrada: '{}'", (i + 1), fechaHoraTexto);

            Date fechaCompra = procesarFecha(fechaHoraTexto, dateFormat);

            if (fechaCompra != null && (fechaMasReciente == null || fechaCompra.after(fechaMasReciente))) {
                fechaMasReciente = fechaCompra;
                compraMasReciente = fila;
                LOGGER.info("Nueva compra más reciente encontrada: {}", fechaCompra);
            }
        }

        return compraMasReciente;
    }

    private void configurarDateFormatSymbols(SimpleDateFormat dateFormat) {
        DateFormatSymbols symbols = new DateFormatSymbols(COLOMBIA_LOCALE);
        symbols.setShortMonths(new String[]{"ene", "feb", "mar", "abr", "may", "jun",
                "jul", "ago", "sep", "oct", "nov", "dic"});
        dateFormat.setDateFormatSymbols(symbols);
    }

    private Date procesarFecha(String fechaTexto, SimpleDateFormat dateFormat) {
        try {
            String fechaNormalizada = fechaTexto.trim();
            LOGGER.debug("Procesando fecha: '{}'", fechaNormalizada);

            Date fecha = dateFormat.parse(fechaNormalizada);
            LOGGER.debug("Fecha parseada exitosamente: {}", fecha);
            return fecha;

        } catch (ParseException e) {
            LOGGER.warn("No se pudo parsear la fecha: '{}'", fechaTexto, e);
            return null;
        }
    }

    private void validarFirmasYFactor(Actor actor) {

        LOGGER.info("Validando sección Product Attributes");

        List<WebElementFacade> filas = TBL_PRODUCT_ATTRIBUTES.resolveAllFor(actor);

        if (filas.isEmpty()) {
            throw new AssertionError("No se encontraron atributos del producto.");
        }

        boolean sorpresaEncontrada = false;

        for (WebElementFacade fila : filas) {

            String nombre = fila.then(By.xpath("./td[1]")).getText().trim();
            String tipo = fila.then(By.xpath("./td[3]")).getText().trim();
            String valor = fila.then(By.xpath("./td[4]")).getText().trim();

            LOGGER.debug("Atributo: {} | Tipo: {} | Valor: {}", nombre, tipo, valor);

            if (nombre.equalsIgnoreCase("Sorpresa")) {

                sorpresaEncontrada = true;

                // Validar que el tipo sea numérico
                if (!tipo.equalsIgnoreCase("Numero Decimal")) {
                    throw new AssertionError("El atributo Sorpresa no tiene tipo numérico.");
                }

                // Validar que el valor sea numérico
                if (!valor.matches("\\d+")) {
                    throw new AssertionError("El valor del factor multiplicador no es numérico: " + valor);
                }

                LOGGER.info("Factor multiplicador encontrado con valor válido: {}", valor);
            }
        }

        if (!sorpresaEncontrada) {
            LOGGER.info("El paquete no tiene factor multiplicador activo (válido según promoción).");
        }

        LOGGER.info("Validación de atributos completada correctamente.");
    }

    private String extraerNombrePaquete(Actor actor) {
        try {
            Target targetPaquete = Target.the("Nombre del paquete en detalles")
                    .located(By.xpath(NOMBRE_PAQUETE_XPATH));

            List<WebElementFacade> elementos = targetPaquete.resolveAllFor(actor);

            if (!elementos.isEmpty() && elementos.get(0).isPresent()) {
                String textoCompleto = elementos.get(0).getText().trim();

                if (textoCompleto.contains("Detalles del producto para ")) {
                    String nombrePaquete = textoCompleto.replace("Detalles del producto para ", "").trim();
                    LOGGER.info("Nombre del paquete extraído: '{}'", nombrePaquete);
                    return nombrePaquete;
                }
                return textoCompleto;
            }
        } catch (Exception e) {
            LOGGER.warn("No se pudo extraer el nombre del paquete", e);
        }
        return "";
    }

    public static Performable validarFirmaYFactorMultiplicador() {
        return instrumented(ValidarFirmaYFactorMultiplicador.class);
    }
}