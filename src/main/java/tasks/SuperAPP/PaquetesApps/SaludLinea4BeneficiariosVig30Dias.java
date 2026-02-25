package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class SaludLinea4BeneficiariosVig30Dias extends AndroidObject implements Task {

    String precioTexto = PRECIO_$6500;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$6500),
                Click.on(LBL_VER_DETALLE_3),
                ValidarTexto.validarTexto(
                        SALUD_EN_LINEA_30DIAS_4BENEFICIARIOS)
        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", SALUD_EN_LINEA_30DIAS_4BENEFICIARIOS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_3),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$6500)
        );

    }

    public static Performable saludLinea4BeneficiariosVig30Dias() {
        return instrumented(SaludLinea4BeneficiariosVig30Dias.class);

    }
}