package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Reserva;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmarReserva implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Reserva.BOTON_CONFIRMA)
        );

        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
    }

    public static ConfirmarReserva con() {
        return instrumented(ConfirmarReserva.class);
    }
}
