package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Busqueda;
import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.time.LocalDate; // Importación CLAVE
import java.time.format.DateTimeFormatter; // Importación para análisis

public class BuscarViajes implements Task {

    private final String origen;
    private final String destino;
    private final String fecha; // Usamos 'fecha' como el atributo

    public BuscarViajes(String origen, String destino, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public static BuscarViajes conFiltros(String origen, String destino, String fecha) {
        return instrumented(BuscarViajes.class, origen, destino, fecha);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 1. Lógica de Extracción y Formato (Usamos 'fechaViaje' para evitar conflictos)
        LocalDate fechaViaje = LocalDate.parse(this.fecha, DateTimeFormatter.ISO_DATE);
        String dia = String.valueOf(fechaViaje.getDayOfMonth());

        // ORIGEN
        actor.attemptsTo(Click.on(Busqueda.CAMPO_ORIGEN));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Scroll.to(Busqueda.OPCION_CIUDAD(origen)));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Click.on(Busqueda.OPCION_CIUDAD(origen)));
        WaitTime.putWaitTimeOf(700);

        // DESTINO
        actor.attemptsTo(Click.on(Busqueda.CAMPO_DESTINO));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Click.on(Busqueda.OPCION_CIUDAD(destino)));
        WaitTime.putWaitTimeOf(700);

        // CALENDARIO
        actor.attemptsTo(Click.on(Busqueda.BOTON_ABRIR_CALENDARIO));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Scroll.to(Busqueda.DIA_DEL_CALENDARIO(dia)));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Click.on(Busqueda.DIA_DEL_CALENDARIO(dia)));
        WaitTime.putWaitTimeOf(700);


        // BUSCAR
        actor.attemptsTo(Click.on(Busqueda.BOTON_BUSCAR));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());
        WaitTime.putWaitTimeOf(700);

    }
}
