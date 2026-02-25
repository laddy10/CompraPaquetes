package interactions.scroll;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ScrollRecyclerView implements Interaction {

    private final String numero;

    public ScrollRecyclerView(String numero) {
        this.numero = numero;
    }

    public static ScrollRecyclerView hastaNumero(String numero) {
        return Tasks.instrumented(ScrollRecyclerView.class, numero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        AndroidDriver driver =
                (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()" +
                                ".className(\"androidx.recyclerview.widget.RecyclerView\"))" +
                                ".setAsVerticalList()" +
                                ".setMaxSearchSwipes(4)" +
                                ".scrollIntoView(new UiSelector().textContains(\"" + numero + "\"));"
                )
        );

        try {
            Thread.sleep(700);
        } catch (InterruptedException ignored) {
        }
    }
}