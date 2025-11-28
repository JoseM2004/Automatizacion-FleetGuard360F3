package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.PaginaDeBusqueda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPaginaDeBusqueda implements Task {

    private PaginaDeBusqueda paginaDeBusqueda;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(paginaDeBusqueda)
        );
    }

    public static AbrirPaginaDeBusqueda en() {
        return instrumented(AbrirPaginaDeBusqueda.class);
    }
}

