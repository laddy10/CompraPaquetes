package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.*;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturaDePantallaMovil;
import utils.FormateadorValor;

public class SaludLinea2BeneficiarioVig30Dias implements Task {

    String precioTexto = PRECIO_$5000;
    String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto(PRECIO_$5000),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        SALUD_EN_LINEA_30DIAS_2BENEFICIARIOS),
                Scroll.scrollUnaVista()

        );

        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", SALUD_EN_LINEA_30DIAS_2BENEFICIARIOS);

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$5000)
        );

    }

    public static Performable saludLinea2BeneficiarioVig30Dias() {
        return instrumented(SaludLinea2BeneficiarioVig30Dias.class);

    }
}