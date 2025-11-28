package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.userinterfaces.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class MensajeDeError implements Question<String> {
    public static MensajeDeError es() {
        return new MensajeDeError();
    }

    @Override
    public String answeredBy(Actor actor) {
        // Obtenemos el texto del Target del mensaje de error
        return Text.of(PaginaLogin.MENSAJE_ERROR).answeredBy(actor);
    }
}