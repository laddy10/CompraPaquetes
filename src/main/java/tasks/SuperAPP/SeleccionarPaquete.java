package tasks.SuperAPP;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.WebElementQuestion;


public class SeleccionarPaquete implements Task {

    private String description;
    private String price;

    public SeleccionarPaquete(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public static SeleccionarPaquete conDescripcionYPrecio(String description, String price) {
        return instrumented(SeleccionarPaquete.class, description, price);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean found = false;
        int maxPages = 10; // Límite de páginas para evitar bucle infinito

        for(int i=0; i < maxPages; i++) {
            if (WebElementQuestion.the(CONTENEDOR_PAQUETE_DINAMICO.of(description, price)).answeredBy(actor).isVisible()) {
                found = true;
                break;
            } else {
                 if (WebElementQuestion.the(BTN_SIGUIENTE_PAGINACION).answeredBy(actor).isVisible()) {
                    actor.attemptsTo(Click.on(BTN_SIGUIENTE_PAGINACION));
                    // Pequeña espera para cargar la siguiente página
                    try { Thread.sleep(2000); } catch (InterruptedException e) {}
                 } else {
                     break; // No hay más páginas
                 }
            }
        }

        if (found) {
            actor.attemptsTo(
                // Clic en ver detalle como solicitó el usuario
                Click.on(LBL_VER_DETALLE_PAQUETE_DINAMICO.of(description, price)),
                // Aquí se podría validar el nombre si tuviéramos un target específico visible tras el clic
                
                // Clic en comprar (asumiendo que está visible en la tarjeta o se revela)
                Click.on(BTN_COMPRAR_PAQUETE_DINAMICO.of(description, price))
            );
        } else {
            throw new AssertionError("El paquete con descripción '" + description + "' y precio '" + price + "' no fue encontrado tras buscar en " + maxPages + " páginas.");
        }
    }
}
