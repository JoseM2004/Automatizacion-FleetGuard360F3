package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.udea.FleetGuard360F3.userinterfaces.RegisterPage.PASSWORD_ERROR;

public class ErrorPasswordRegister implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(PASSWORD_ERROR).getText();
        WaitTime.putWaitTimeOf(1000);
        return msg;
    }
    public static ErrorPasswordRegister theMessage() {
        return new ErrorPasswordRegister();
    }
}