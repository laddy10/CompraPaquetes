package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;
import static utils.Constants.ELEGIR_OTRO_MEDIO_PAGO;
import static utils.ConstantsPaquetes.PRECIO_$6000;
import static utils.ConstantsPaquetes.TODO_INCLUIDO_3DIAS_400MB_4BENEFICIARIOS;

import interactions.WaitForResponse;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias extends AndroidObject
        implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, PRECIO_$6000);

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        TODO_INCLUIDO_3DIAS_400MB_4BENEFICIARIOS)
        );

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitForResponse.withText(ELEGIR_OTRO_MEDIO_PAGO),
                ValidarTexto.validarTexto(PRECIO_$6000));
    }

    public static Performable todoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias() {
        return instrumented(TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias.class);
    }
}