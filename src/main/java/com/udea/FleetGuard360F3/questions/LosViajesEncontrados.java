package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.userinterfaces.Busqueda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LosViajesEncontrados implements Question<Boolean> {

    public static LosViajesEncontrados sonVisibles() {
        return new LosViajesEncontrados();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verifica si el contenedor de resultados de viajes está visible
        // Reutilizamos la sintaxis moderna que corrige el error anterior:
        return Busqueda.LISTA_VIAJES.resolveFor(actor).isVisible();
    }
}
