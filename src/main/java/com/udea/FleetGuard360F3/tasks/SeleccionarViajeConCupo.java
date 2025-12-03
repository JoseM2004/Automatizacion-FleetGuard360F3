package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Reserva;
import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarViajeConCupo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Asume que después de la búsqueda, el primer resultado con cupo visible es clickeado.

        // 1. Clic en el elemento que representa el viaje (scroll al botón)
        actor.attemptsTo(Scroll.to(Reserva.BOTON_RESERVA));
        WaitTime.putWaitTimeOf(200);

        // 2. Clic en el botón de reserva
        actor.attemptsTo(Click.on(Reserva.BOTON_RESERVA));
        WaitTime.putWaitTimeOf(700);
    }

    public static SeleccionarViajeConCupo seleccionar() {
        return instrumented(SeleccionarViajeConCupo.class);
    }
}
