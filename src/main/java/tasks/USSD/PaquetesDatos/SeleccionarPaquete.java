package tasks.USSD.PaquetesDatos;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.USSD.RealizarCompraPaquete;

public class SeleccionarPaquete {

    private SeleccionarPaquete() {
    }

    public static Performable porNombre(String paquete) {
        return Task.where(
                "{0} selecciona el paquete de datos " + paquete,
                RealizarCompraPaquete.comprapaquete(paquete)
        );
    }
}
