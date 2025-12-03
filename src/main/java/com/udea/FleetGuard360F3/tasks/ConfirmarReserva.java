package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Reserva;
import com.udea.FleetGuard360F3.utils.WaitTime;
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
        WaitTime.putWaitTimeOf(700);

        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        WaitTime.putWaitTimeOf(700);
    }

    public static ConfirmarReserva con() {
        return instrumented(ConfirmarReserva.class);
    }
}
