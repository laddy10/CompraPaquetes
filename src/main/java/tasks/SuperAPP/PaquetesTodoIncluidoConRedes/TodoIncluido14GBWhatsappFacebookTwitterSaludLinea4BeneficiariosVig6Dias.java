package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.PRECIO_$9000;
import static utils.ConstantsPaquetes.TODO_INCLUIDO_6DIAS_1_4GB_4BENEFICIARIOS;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

public class TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                WaitForResponse.withText(ELIGE_TIPO_PAQUETE),
                ValidarTexto.validarTexto(PRECIO_$9000),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_6DIAS_1_4GB_4BENEFICIARIOS )
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

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