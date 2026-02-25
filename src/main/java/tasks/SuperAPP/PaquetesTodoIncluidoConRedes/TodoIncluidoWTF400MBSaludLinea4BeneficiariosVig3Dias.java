package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;
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

public class TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias
        extends AndroidObject implements Task {

    private final String precioTexto = PRECIO_$6000;
    private final String valorFormateado = FormateadorValor.aFormatoCmax(precioTexto);

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Scroll hasta el paquete
        scrollCorto2(actor, PRECIO_$6000);

        // Abrir detalle y validar nombre del paquete
        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(TODO_INCLUIDO_3DIAS_400MB_4BENEFICIARIOS)
        );

        // Guardar datos para validaciones posteriores (CMAX)
        actor.remember("VALOR_COMPRA", valorFormateado);
        actor.remember("PAQUETE_CANAL", TODO_INCLUIDO_3DIAS_400MB_4BENEFICIARIOS);

        // Captura (se deja exactamente como la manejas)
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        // Flujo de compra
        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(precioTexto)
        );
    }

    public static Performable todoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias() {
        return instrumented(TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias.class);
    }
}