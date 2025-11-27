package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.interactions.EnterThe;
import com.udea.FleetGuard360F3.models.Passenger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SubmitForm implements Task {
    Passenger data;

    public SubmitForm(Passenger data) {
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.values(data));
    }
    public static SubmitForm withData(Passenger data) {
        return Tasks.instrumented(SubmitForm.class, data);
    }
}
