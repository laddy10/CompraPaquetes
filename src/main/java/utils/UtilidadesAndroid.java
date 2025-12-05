package utils;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesAndroid {

    public static void abrirLinkEnNavegador(Actor actor, String url) {

        try {
            AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

            Map<String, Object> intentArgs = new HashMap<>();
            intentArgs.put("command", "am");
            intentArgs.put("args", List.of(
                    "start",
                    "-a", "android.intent.action.VIEW",
                    "-d", url
            ));

            driver.executeScript("mobile: shell", intentArgs);

        } catch (Exception e) {
            throw new RuntimeException("Error al abrir link en navegador: " + url, e);
        }
    }
}
