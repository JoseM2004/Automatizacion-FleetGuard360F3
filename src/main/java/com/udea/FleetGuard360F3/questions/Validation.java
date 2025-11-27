package com.udea.FleetGuard360F3.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidationLoginPage implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(TITLE_PAGE_UNIVERSITY).getText();
        return msg;
    }
    public static Validation theUniversitySite() {
        return new Validation();
    }
}