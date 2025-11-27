package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.interactions.EnterThe;
import com.udea.FleetGuard360F3.models.Passenger;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SubmitRegistrationForm implements Task {
    Passenger data;

    public SubmitRegistrationForm(Passenger data) {
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.values(data));
    }
    public static SubmitRegistrationForm withData(Passenger data) {
        return Tasks.instrumented(SubmitRegistrationForm.class, data);
    }
}
