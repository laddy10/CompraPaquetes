package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_PAQUETE_DINAMICO;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;

public class SeleccionarPaquete extends AndroidObject implements Task {

    private final String description;

    public SeleccionarPaquete(String description) {
        this.description = description;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Usamos scrollCorto2 heredado de AndroidObject para buscar el texto (precio o descripción)
        // Esto scrollea hasta que el texto sea visible y lo centra.
        scrollCorto2(actor, description);

        // Una vez visible el texto, intentamos hacer clic en el botón Comprar asociado
        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_COMPRAR_PAQUETE_DINAMICO.of(description))
        );
    }

    public static SeleccionarPaquete conDescripcion(String description) {
        return instrumented(SeleccionarPaquete.class, description);
    }
}
