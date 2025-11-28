package com.udea.FleetGuard360F3.questions;

import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.udea.FleetGuard360F3.userinterfaces.RegisterPage.ACCEPT_TERMS_ERROR;

public class ErrorAcceptTermsRegister implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(ACCEPT_TERMS_ERROR).getText();
        WaitTime.putWaitTimeOf(1000);
        return msg;
    }
    public static ErrorAcceptTermsRegister theMessage() {
        return new ErrorAcceptTermsRegister();
    }
}