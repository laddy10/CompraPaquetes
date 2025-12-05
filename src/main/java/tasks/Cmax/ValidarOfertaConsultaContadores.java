package tasks.Cmax;

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
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AdjustPageZoom;
import utils.EvidenciaUtils;

import java.util.List;

public class ValidarOfertaConsultaContadores implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarOfertaConsultaContadores.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando validación de ofertas activas en contadores");

        // Navegar a ofertas
        navegarAOfertas(actor);

        // Validar página inicial
        validarPaginaInicial(actor);

        // Validar páginas adicionales si existen paquetes activos
        validarPaginasAdicionales(actor);

        LOGGER.info("Validación de ofertas en contadores completada");
    }

    private void navegarAOfertas(Actor actor) {
        LOGGER.debug("Navegando a ofertas");

        actor.attemptsTo(
                WaitElement.isClickable(BTN_OFERTAS),
                Click.on(BTN_OFERTAS),
                Click.on(BTN_FECHA_INICIO),
                Click.on(BTN_FECHA_INICIO2),
                WaitFor.aTime(1000),
                AdjustPageZoom.to(ZOOM_LEVEL_75),
                WaitFor.aTime(2000)
        );
    }

    private void validarPaginaInicial(Actor actor) {
        EvidenciaUtils.registrarCaptura("Se validan las ofertas activas - Página 1");
        actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));
    }

    private void validarPaginasAdicionales(Actor actor) {
        int numeroPagina = 2;
        int maxPaginas = 10; // Límite de seguridad

        // Continuar mientras existan páginas siguientes Y haya paquetes activos
        while (existePaginaSiguiente(actor) && hayPaquetesActivos(actor) && numeroPagina <= maxPaginas) {
            LOGGER.info("Navegando a página {}", numeroPagina);

            actor.attemptsTo(
                    Click.on(BTN_NEXT2),
                    WaitFor.aTime(1000),
                    AdjustPageZoom.to(ZOOM_LEVEL_90),
                    WaitFor.aTime(1000)
            );

            // Verificar si volvió a la primera página (indicador de fin)
            if (estamosEnPrimeraPagina(actor)) {
                LOGGER.info("Se detectó vuelta a la primera página. Finalizando paginación.");
                break;
            }

            EvidenciaUtils.registrarCaptura("Se validan las ofertas activas - Página " + numeroPagina);

            actor.attemptsTo(AdjustPageZoom.to(NORMAL_ZOOM));
            numeroPagina++;
        }

        if (numeroPagina > maxPaginas) {
            LOGGER.warn("Se alcanzó el límite máximo de páginas ({})", maxPaginas);
        }

        LOGGER.info("Validación completada. Total de páginas procesadas: {}", numeroPagina - 1);
    }

    /**
     * Verifica si estamos de vuelta en la primera página
     */
    private boolean estamosEnPrimeraPagina(Actor actor) {
        try {
            // Crear target para buscar texto específico de primera página
            Target textoPrimera = LBL_DISPLAYING;

            List<WebElementFacade> elementos = textoPrimera.resolveAllFor(actor);
            boolean esPagena1 = !elementos.isEmpty();

            LOGGER.debug("¿Estamos en primera página? {}", esPagena1);
            return esPagena1;

        } catch (Exception e) {
            LOGGER.warn("Error verificando primera página", e);
            return false;
        }
    }

    /**
     * Verifica si existe una página siguiente
     */
    private boolean existePaginaSiguiente(Actor actor) {
        try {
            boolean existe = !Presence.of(BTN_NEXT2).viewedBy(actor).resolveAll().isEmpty();
            LOGGER.debug("¿Existe página siguiente? {}", existe);
            return existe;
        } catch (Exception e) {
            LOGGER.warn("Error verificando página siguiente", e);
            return false;
        }
    }

    /**
     * Verifica si hay paquetes activos en la página actual
     */
    private boolean hayPaquetesActivos(Actor actor) {
        try {
            List<WebElementFacade> ofertas = TBL_OFERTAS.resolveAllFor(actor);

            boolean hayActivos = ofertas.stream().anyMatch(fila -> {
                try {
                    String textoOferta = fila.getText().toLowerCase();
                    boolean esActivo = textoOferta.contains("datos") ||
                            textoOferta.contains("sms") ||
                            textoOferta.contains("voz") ||
                            textoOferta.contains("paquete") ||
                            textoOferta.contains("whatsapp") ||
                            textoOferta.contains("todo incluido");

                    if (esActivo) {
                        LOGGER.debug("Paquete activo encontrado: {}", textoOferta.substring(0, Math.min(50, textoOferta.length())));
                    }

                    return esActivo;
                } catch (Exception e) {
                    LOGGER.warn("Error procesando fila de oferta", e);
                    return false;
                }
            });

            LOGGER.debug("¿Hay paquetes activos? {}", hayActivos);
            return hayActivos;

        } catch (Exception e) {
            LOGGER.warn("Error verificando paquetes activos", e);
            return false;
        }
    }

    public static Performable validarOfertaConsultaContadores() {
        return instrumented(ValidarOfertaConsultaContadores.class);
    }
}