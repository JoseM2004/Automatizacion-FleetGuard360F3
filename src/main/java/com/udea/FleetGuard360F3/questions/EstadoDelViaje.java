package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.userinterfaces.Busqueda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EstadoDelViaje implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // 1. Verificar que la etiqueta 'Agotado' es visible.
        boolean estadoAgotadoVisible = Busqueda.ETIQUETA_ESTADO_AGOTADO
                .resolveFor(actor)
                .isVisible();

        // 2. Verificar que el botón de acción esté deshabilitado.
        boolean botonDeshabilitado = Busqueda.BOTON_AGOTADO_DESHABILITADO
                .resolveFor(actor)
                .isDisabled(); // Esto verifica la presencia del atributo 'disabled'

        // El paso es exitoso solo si ambas condiciones se cumplen.
        return estadoAgotadoVisible && botonDeshabilitado;
    }

    public static EstadoDelViaje sinCupo() {
        return new EstadoDelViaje();
    }
}
