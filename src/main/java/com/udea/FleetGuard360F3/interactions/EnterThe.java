package com.udea.FleetGuard360F3.interactions;

import com.udea.FleetGuard360F3.models.Passenger;
import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.udea.FleetGuard360F3.userinterfaces.RegisterPage.*;

public class EnterThe implements Interaction {
    Passenger data;

    public EnterThe(Passenger data) {
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(data.getFirstName()).into(INPUT_TEXT_NAME));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getLastName()).into(INPUT_TEXT_LASTNAME));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getUsername()).into(INPUT_TEXT_USER));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(SelectFromOptions.byValue( data.getDocumentType()).from(SELECT_TYPE_ID));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getDocumentNumber()).into(INPUT_TEXT_ID));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getPhone()).into(INPUT_TEXT_PHONE));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getEmail()).into(INPUT_TEXT_EMAIL));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getPassword()).into(INPUT_TEXT_PASS));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Enter.theValue(data.getConfirmPassword()).into(INPUT_TEXT_CONFIRM_PASS));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Click.on(ACCEPT_TERMS));
        WaitTime.putWaitTimeOf(700);

        actor.attemptsTo(Click.on(REGISTER_BUTTON));
        WaitTime.putWaitTimeOf(700);
    }
    public static EnterThe values(Passenger data) {
        return Tasks.instrumented(EnterThe.class, data);
    }
}