package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.Busqueda;
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

        actor.attemptsTo(
                // ORIGEN
                Click.on(Busqueda.CAMPO_ORIGEN),
                Scroll.to(Busqueda.OPCION_CIUDAD(origen)),
                Click.on(Busqueda.OPCION_CIUDAD(origen)),

                // DESTINO
                Click.on(Busqueda.CAMPO_DESTINO),
                Click.on(Busqueda.OPCION_CIUDAD(destino)),

                // CALENDARIO
                Click.on(Busqueda.BOTON_ABRIR_CALENDARIO),
                Scroll.to(Busqueda.DIA_DEL_CALENDARIO(dia)),
                Click.on(Busqueda.DIA_DEL_CALENDARIO(dia)),

                // BUSCAR
                Click.on(Busqueda.BOTON_BUSCAR),
                WaitUntil.angularRequestsHaveFinished()
        );
    }
}
