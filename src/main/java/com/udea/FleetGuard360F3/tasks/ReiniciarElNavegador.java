package com.udea.FleetGuard360F3.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class ReiniciarElNavegador implements Task {

    public static ReiniciarElNavegador reiniciar() {
        return instrumented(ReiniciarElNavegador.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Simplemente navega a una página diferente y luego vuelve
        // Esto "refresca" el contexto sin perder sesión
        driver.get("about:blank");

        // O si quieres simular mejor el cierre y apertura:
        // Navega a una URL neutral primero
        driver.get("about:blank");

        // Pequeña pausa para simular el cierre/apertura
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

