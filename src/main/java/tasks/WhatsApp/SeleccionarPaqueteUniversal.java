package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForTextContains;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.TestDataProvider;
import utils.WordAppium;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class SeleccionarPaqueteUniversal implements Task {

    private final User user = TestDataProvider.getRealUser();

    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean encontrado = false;

        // 🔹 Normalización de criterios
        String criterioNombre   = normalizarTexto(user.getNombrePaquete());
        String criterioBusqueda = normalizarTexto(user.getPaqueteComprar());


        while (!encontrado) {

            List<WebElementFacade> paquetes = OPCIONES_PAQUETES.resolveAllFor(actor);

            for (WebElementFacade paquete : paquetes) {

                String textoOriginal = paquete.getText();
                String texto = normalizarTexto(textoOriginal);

                int coincidencias = 0;

                // 🔍 Debug controlado
                System.out.println(">>> TEXTO REAL DEL ELEMENTO:");
                System.out.println("'" + textoOriginal + "'");
                System.out.println(">>> TEXTO NORMALIZADO:");
                System.out.println("'" + texto + "'");

                if (!criterioNombre.isEmpty() && texto.contains(criterioNombre)) {
                    coincidencias++;
                }

                if (!criterioBusqueda.isEmpty() && texto.contains(criterioBusqueda)) {
                    coincidencias++;
                }



                // ✅ Selección robusta (mínimo 1 coincidencia fuerte + contexto)
                if (coincidencias >= 1 && texto.contains("dia")) {

                    paquete.click();

                    CapturaDePantallaMovil.tomarCapturaPantalla("seleccion-paquete");

                    actor.attemptsTo(
                            WaitFor.aTime(2000),
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            ValidarTextoQueContengaX.elTextoContiene(user.getNombrePaquete())
                    );

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {

                if (!Presence.of(BTN_VER_MAS_PAQUETES).viewedBy(actor).resolveAll().isEmpty()
                        && BTN_VER_MAS_PAQUETES.resolveFor(actor).isVisible()) {

                    actor.attemptsTo(
                            Click.on(BTN_VER_MAS_PAQUETES),
                            WaitFor.aTime(2000)
                    );

                    CapturaDePantallaMovil.tomarCapturaPantalla("ver-mas-paquetes");

                    actor.attemptsTo(
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            WaitForTextContains.withAnyTextContains(ELIGE_Y_COMPRA),
                            WaitFor.aTime(2000)
                    );

                    CapturaDePantallaMovil.tomarCapturaPantalla("lista-expandida");

                    actor.attemptsTo(
                            EsperarYClickSeleccionaEnUltimoMensaje.conTimeout(20)
                    );

                } else {
                    throw new RuntimeException(
                            "Paquete no encontrado. Criterios: "
                                    + criterioBusqueda
                    );
                }
            }
        }

        WordAppium.main();
    }

    /**
     * 🔧 Normaliza textos provenientes de Android
     */
    private static String normalizarTexto(String texto) {
        if (texto == null) return "";

        return texto
                .toLowerCase()
                .replace("\u00A0", " ")        // NBSP
                .replace("×", "x")             // multiplicación
                .replace("í", "i")
                .replace("á", "a")
                .replace("é", "e")
                .replace("ó", "o")
                .replace("ú", "u")
                .replaceAll("\\s+", " ")
                .replaceAll("[^a-z0-9$., ]", "")
                .trim();
    }

    public static Performable comprar() {
        return instrumented(SeleccionarPaqueteUniversal.class);
    }
}
