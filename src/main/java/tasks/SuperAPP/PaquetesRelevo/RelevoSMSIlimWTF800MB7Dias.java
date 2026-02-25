package tasks.SuperAPP.PaquetesRelevo;

import interactions.WaitForResponse;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;
import static utils.ConstantsPaquetes.*;

public class RelevoSMSIlimWTF800MB7Dias extends AndroidObject implements Task {

    String precioTexto = PRECIO_$8000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$8000),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(PAQUETE_RELEVO_800MB_7DIAS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", PAQUETE_RELEVO_800MB_7DIAS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$8000)
        );
    }

    public static Performable relevoSMSIlimWTF800MB7Dias() {
        return instrumented(RelevoSMSIlimWTF800MB7Dias.class);
    }

}