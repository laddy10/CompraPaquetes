package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.scroll.Scroll;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import java.util.ArrayList;
import java.util.List;

public class CompraPaquetePorCategoria extends AndroidObject implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompraPaquetePorCategoria.class);
    User addCredentials;

    public CompraPaquetePorCategoria(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String nombrePaquete = addCredentials.getNombrePaquete();
        String precio = addCredentials.getPrecio();
        LOGGER.info("Buscando paquete: '{}' con precio: '{}'", nombrePaquete, precio);

        boolean paqueteEncontrado = buscarPaqueteEnTodasLasPaginas(actor, nombrePaquete, precio);

        if (!paqueteEncontrado) {
            throw new AssertionError("No se encontró el paquete: " + nombrePaquete + " con precio: " + precio);
        }
    }

    private boolean buscarPaqueteEnTodasLasPaginas(Actor actor, String nombrePaquete, String precio) {
        int paginaActual = 1;
        int maxPaginas = 4;

        while (paginaActual <= maxPaginas) {
            LOGGER.info("Buscando '{}' con precio '{}' en página {}", nombrePaquete, precio, paginaActual);

            if (buscarPaqueteEnPaginaActual(actor, nombrePaquete, precio)) {
                return true;
            }

            if (paginaActual < maxPaginas && navegarSiguientePagina(actor)) {
                paginaActual++;
            } else {
                break;
            }
        }

        return false;
    }

    private boolean buscarPaqueteEnPaginaActual(Actor actor, String nombrePaquete, String precio) {
        String[] palabrasClave = extraerPalabrasClave(nombrePaquete);
        LOGGER.info("Buscando por precio: '{}'", precio);

        for (int scroll = 0; scroll < 3; scroll++) {
            Target todoTexto = Target.the("Todo el texto visible")
                    .located(By.xpath("//*[@text and string-length(@text) > 1]"));

            List<WebElementFacade> elementos = todoTexto.resolveAllFor(actor);

            // Buscar primero por precio exacto
            for (WebElementFacade elemento : elementos) {
                String texto = elemento.getText();

                if (texto.contains(precio)) {
                    LOGGER.info("Precio encontrado: '{}' en elemento '{}'", precio, texto);

                    if (hacerClicVerDetalle(actor)) {
                        CapturaDePantallaMovil.tomarCapturaPantalla("paquete_" + nombrePaquete);
                        return true;
                    }
                }
            }

            if (scroll < 2) {
                scrollDown(actor);
                actor.attemptsTo(WaitFor.aTime(1500));
            }
        }

        return false;
    }

    private String[] crearXPathsDinamicos(String[] palabrasClave) {
        List<String> xpathsList = new ArrayList<>();
        xpathsList.add("//*[@text]"); // XPath base

        for (String palabra : palabrasClave) {
            if (palabra != null && palabra.length() > 2) {
                xpathsList.add("//*[contains(@text,'" + palabra + "')]");
            }
        }

        return xpathsList.toArray(new String[0]);
    }

    private void centrarElemento(Actor actor, WebElementFacade elemento) {
        try {
            elemento.click();
            actor.attemptsTo(WaitFor.aTime(500));
            LOGGER.debug("Elemento centrado haciendo clic");
        } catch (Exception e) {
            LOGGER.debug("No se pudo centrar elemento");
        }
    }

    private void scrollDown(Actor actor) {
        try {
            actor.attemptsTo(Scroll.scrollUnaVista());
            LOGGER.debug("Scroll hacia abajo realizado");
        } catch (Exception e) {
            LOGGER.debug("Error en scroll");
        }
    }

    private String[] extraerPalabrasClave(String nombre) {
        return nombre.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", " ")
                .split("\\s+");
    }

    private boolean coincidePaquete(String texto, String[] palabrasClave) {
        String textoLower = texto.toLowerCase();

        // Excluir elementos no relacionados con paquetes
        if (textoLower.contains("línea") ||
                textoLower.contains("paquetes todo incluido") ||
                textoLower.contains("elige tu paquete") ||
                textoLower.contains("filtrar por") ||
                textoLower.contains("ordenar por")) {
            return false;
        }

        int coincidencias = 0;
        boolean tieneCapacidad = false; // MB o GB

        for (String palabra : palabrasClave) {
            if (palabra.length() > 1) {
                // Para números, buscar coincidencias exactas con límites de palabra
                if (palabra.matches("\\d+")) {
                    if (textoLower.matches(".*\\b" + palabra + "\\b.*")) {
                        coincidencias++;
                        LOGGER.debug("Coincidencia numérica exacta: '{}' en '{}'", palabra, texto);
                    }
                } else if (textoLower.contains(palabra)) {
                    coincidencias++;
                    if (palabra.equals("mb") || palabra.equals("gb")) {
                        tieneCapacidad = true;
                    }
                    LOGGER.debug("Coincidencia encontrada: '{}' en '{}'", palabra, texto);
                }
            }
        }

        // Requiere al menos 3 coincidencias Y debe tener capacidad (MB/GB)
        return coincidencias >= 3 && tieneCapacidad;
    }

    private boolean hacerClicVerDetalle(Actor actor) {
        try {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                    WaitFor.aTime(2000)
            );
            return true;
        } catch (Exception e) {
            LOGGER.debug("No se encontró 'Ver detalle' para este paquete");
            return false;
        }
    }

    private boolean navegarSiguientePagina(Actor actor) {
        try {
            Target siguientePagina = Target.the("Siguiente página")
                    .located(By.xpath("//*[@text='2' or @text='3' or @text='4' or @text='Último']"));

            List<WebElementFacade> botones = siguientePagina.resolveAllFor(actor);

            if (!botones.isEmpty()) {
                botones.get(0).click();
                actor.attemptsTo(WaitFor.aTime(2000));
                LOGGER.debug("Navegado a siguiente página");
                return true;
            }

        } catch (Exception e) {
            LOGGER.warn("Error navegando a siguiente página", e);
        }

        return false;
    }

    public static Performable compraPaquetePorCategoria(User addCredentials) {
        return instrumented(CompraPaquetePorCategoria.class, addCredentials);
    }
}