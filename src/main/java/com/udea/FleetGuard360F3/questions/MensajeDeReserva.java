package com.udea.FleetGuard360F3.questions;
import com.udea.FleetGuard360F3.userinterfaces.Reserva;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeDeReserva implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        // Verifica que el mensaje de éxito de la reserva esté visible
        return Reserva.EXITO.resolveFor(actor).isVisible();
    }

    public static MensajeDeReserva esVisible() {
        return new MensajeDeReserva();
    }
}
