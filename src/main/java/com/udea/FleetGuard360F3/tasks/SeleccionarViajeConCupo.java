package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Reserva;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarViajeConCupo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Asume que después de la búsqueda, el primer resultado con cupo visible es clickeado.
        actor.attemptsTo(
                // 1. Clic en el elemento que representa el viaje (ej. el primer resultado de la lista)
                Scroll.to(Reserva.BOTON_RESERVA),
                Click.on(Reserva.BOTON_RESERVA)

        );
    }

    public static SeleccionarViajeConCupo seleccionar() {
        return instrumented(SeleccionarViajeConCupo.class);
    }
}
