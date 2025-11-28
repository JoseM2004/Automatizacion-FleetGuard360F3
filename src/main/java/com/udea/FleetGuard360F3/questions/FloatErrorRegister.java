package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.udea.FleetGuard360F3.userinterfaces.RegisterPage.FLOATING_MESSAGE;

public class FloatErrorRegister implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(FLOATING_MESSAGE).getText();
        WaitTime.putWaitTimeOf(1000);
        return msg;
    }
    public static FloatErrorRegister theMessage() {
        return new FloatErrorRegister();
    }
}