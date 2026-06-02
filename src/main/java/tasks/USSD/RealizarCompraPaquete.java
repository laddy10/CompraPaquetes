package tasks.USSD;

import interactions.WaitFor;
import interactions.comunes.ObtenerTextoUSSD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.CapturaDePantallaMovil;

import static userinterfaces.USSDPage.BTN_ENVIAR;
import static userinterfaces.USSDPage.CJA_INGRESAR_OPCION;

public class RealizarCompraPaquete implements Task {

    private static final int OPCION_MAS = 9;
    private static final int MAXIMO_PAGINAS_MENU = 5;

    private final String option;

    public RealizarCompraPaquete(String option) {
        this.option = option;
    }

    public static RealizarCompraPaquete comprapaquete(String option) {
        return new RealizarCompraPaquete(option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitFor.aTime(3000));

        for (int pagina = 1; pagina <= MAXIMO_PAGINAS_MENU; pagina++) {
            String textoMenu = ObtenerTextoUSSD.obtener(actor);
            int opcionEncontrada = obtenerNumeroOpcion(textoMenu, option);

            if (opcionEncontrada != -1) {
                enviarOpcion(actor, opcionEncontrada);
                return;
            }

            if (tieneOpcionMas(textoMenu)) {
                enviarOpcion(actor, OPCION_MAS);
                actor.attemptsTo(WaitFor.aTime(3000));
            } else {
                break;
            }
        }

        throw new IllegalArgumentException(
                "No se encontro el paquete '" + option + "' en el menu USSD.");
    }

    private void enviarOpcion(Actor actor, int opcion) {
        actor.attemptsTo(Enter.theValue(Integer.toString(opcion)).into(CJA_INGRESAR_OPCION));
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        actor.attemptsTo(Click.on(BTN_ENVIAR));
    }

    private int obtenerNumeroOpcion(String textoMenu, String opcion) {
        String[] opciones = textoMenu.split("\\d+\\. ");
        for (int i = 1; i < opciones.length; i++) {
            if (opciones[i].startsWith(opcion)) {
                return i;
            }
        }
        return -1;
    }

    private boolean tieneOpcionMas(String textoMenu) {
        return textoMenu.contains(OPCION_MAS + ". Mas");
    }
}
