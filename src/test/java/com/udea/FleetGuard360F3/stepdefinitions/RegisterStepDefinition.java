package com.udea.FleetGuard360F3.stepdefinitions;

import com.udea.FleetGuard360F3.models.Passenger;
import com.udea.FleetGuard360F3.questions.*;
import com.udea.FleetGuard360F3.tasks.OpenThe;
import com.udea.FleetGuard360F3.tasks.SubmitForm;
import com.udea.FleetGuard360F3.userinterfaces.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterStepDefinition {

    public final Actor passenger = Actor.named("passenger");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        passenger.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("passenger");
    }

    @Given("I am in the registration page")
    public void iAmInTheRegistrationPage() {
        passenger.attemptsTo(OpenThe.navigator(new RegisterPage()));
    }
    @When("I am submit a valid form")
    public void iAmSubmitAValidForm(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);

        Passenger data = Passenger.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .username(row.get("username"))
                .documentType(row.get("typeId"))
                .documentNumber(row.get("id"))
                .phone(row.get("phone"))
                .email(row.get("email"))
                .password(row.get("password"))
                .confirmPassword(row.get("confirmPassword"))
                .acceptTerms(Boolean.parseBoolean(row.get("acceptTerms")))
                .build();

        passenger.attemptsTo(
                SubmitForm.withData(data)
        );
    }
    @Then("I can see the login page")
    public void iCanSeeTheLoginPage() {
        passenger.should(GivenWhenThen.seeThat(Validation.theLoginPage(), Matchers.containsString("Ingresa tus credenciales para acceder a tu cuenta")));
    }


    @When("I am submitting a valid form with an existing email address")
    public void iAmSubmittingAValidFormWithAnExistingEmailAddress(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);

        Passenger data = Passenger.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .username(row.get("username"))
                .documentType(row.get("typeId"))
                .documentNumber(row.get("id"))
                .phone(row.get("phone"))
                .email(row.get("email"))
                .password(row.get("password"))
                .confirmPassword(row.get("confirmPassword"))
                .acceptTerms(Boolean.parseBoolean(row.get("acceptTerms")))
                .build();

        passenger.attemptsTo(
                SubmitForm.withData(data)
        );
    }
    @Then("I see {string} floating message")
    public void iSeeFloatingMessage(String floatingError) {
        passenger.should(GivenWhenThen.seeThat(FloatErrorRegister.theMessage(), Matchers.containsString(floatingError)));
    }
    @Then("I cannot create my account")
    public void iCannotCreateMyAccount() {
        passenger.should(GivenWhenThen.seeThat(DescriptionRegisterPage.theText(), Matchers.containsString("Completa todos los campos obligatorios para registrarte en FleetGuard360")));
    }









    @When("I try to submit the form with an invalid password")
    public void iTryToSubmitTheFormWithAnInvalidPassword(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);

        Passenger data = Passenger.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .username(row.get("username"))
                .documentType(row.get("typeId"))
                .documentNumber(row.get("id"))
                .phone(row.get("phone"))
                .email(row.get("email"))
                .password(row.get("password"))
                .confirmPassword(row.get("confirmPassword"))
                .acceptTerms(Boolean.parseBoolean(row.get("acceptTerms")))
                .build();

        passenger.attemptsTo(
                SubmitForm.withData(data)
        );
    }
    @Then("I see {string} error")
    public void iSeeError(String passwordError) {
        passenger.should(GivenWhenThen.seeThat(ErrorPasswordRegister.theMessage(), Matchers.containsString(passwordError)));
    }




    @When("I try to register without accepting the terms")
    public void iTryToRegisterWithoutAcceptingTheTerms(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);

        Passenger data = Passenger.builder()
                .firstName(row.get("firstName"))
                .lastName(row.get("lastName"))
                .username(row.get("username"))
                .documentType(row.get("typeId"))
                .documentNumber(row.get("id"))
                .phone(row.get("phone"))
                .email(row.get("email"))
                .password(row.get("password"))
                .confirmPassword(row.get("confirmPassword"))
                .acceptTerms(Boolean.parseBoolean(row.get("acceptTerms")))
                .build();

        passenger.attemptsTo(
                SubmitForm.withData(data)
        );
    }
    @Then("I see an error that contains {string}")
    public void iSeeAnErrorThatContains(String acceptTerms) {
        passenger.should(GivenWhenThen.seeThat(ErrorAcceptTermsRegister.theMessage(), Matchers.containsString(acceptTerms)));
    }

}