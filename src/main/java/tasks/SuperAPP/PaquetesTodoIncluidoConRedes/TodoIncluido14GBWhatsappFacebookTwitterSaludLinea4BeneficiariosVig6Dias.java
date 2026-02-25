package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias implements Task {

    private final String precioTexto = PRECIO_$9000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Desplazamiento y selección del paquete
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                WaitForResponse.withText(ELIGE_TIPO_PAQUETE),

                // Validación del precio en el canal
                ValidarTexto.validarTexto(PRECIO_$9000),

                // Ingreso al detalle del paquete
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),

                // Validación del nombre del paquete
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_6DIAS_1_4GB_4BENEFICIARIOS)
        );

        // Guardar datos para validaciones posteriores en CMAX
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_6DIAS_1_4GB_4BENEFICIARIOS);

        // Evidencia visual
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$9000)
        );
    }

    public static Performable
    todoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias() {
        return instrumented(
                TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias.class);
    }
}