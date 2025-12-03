package com.udea.FleetGuard360F3.stepdefinitions;

import com.udea.FleetGuard360F3.questions.MensajeDeError;
import com.udea.FleetGuard360F3.questions.PanelDePasajero;
import com.udea.FleetGuard360F3.tasks.AbrirPaginaDeBusqueda;
import com.udea.FleetGuard360F3.tasks.IniciarSesion;
import com.udea.FleetGuard360F3.tasks.IniciarSesionConRecuerdame;
import com.udea.FleetGuard360F3.tasks.ReiniciarElNavegador;
import com.udea.FleetGuard360F3.userinterfaces.PaginaDeLogin;
import com.udea.FleetGuard360F3.utils.WaitTime;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;



import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver navegador;

    PaginaDeLogin paginaDeLogin;



    private Actor pasajero = Actor.named("Pasajero");

    @Before
    public void beforeEachScenario() {
        pasajero.can(BrowseTheWeb.with(navegador));     // Dar habilidad al actor
        pasajero.wasAbleTo(Open.browserOn().the(paginaDeLogin)); // Ir al login SIEMPRE
    }


    @When("intento iniciar sesión con credenciales incorrectas")
    @When("intento iniciar sesión")
    public void elPasajeroIntentaIniciarSesionConY(DataTable table) {

        Map<String, String> data = table.asMaps().get(0);
        pasajero.attemptsTo(
                IniciarSesion.conCredenciales(data.get("username"), data.get("password"))
        );
    }

    @Then("sigo autenticado hasta la expiración configurada")
    @Then("veo el panel de pasajero")
    public void elPanelDePasajeroDeberiaSerVisible() {
        pasajero.should(
                seeThat(PanelDePasajero.esVisible(), is(true))
        );
        WaitTime.putWaitTimeOf(500);
    }


    @Then("veo {string} sin indicar que campo falló")
    public void veoSinIndicarQueCampoFallo(String mensajeEsperado) {
        pasajero.should(
                seeThat(MensajeDeError.es(), containsString(mensajeEsperado))
        );
        WaitTime.putWaitTimeOf(500);
    }

    @Given("que marco Recordarme")
    public void queMarcoRecuerdameConElUsuarioYLaClave(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        pasajero.attemptsTo(

                IniciarSesionConRecuerdame.conCredenciales(data.get("username"), data.get("password"))
        );
    }

    @When("cierro y vuelvo a abrir la app")
    public void cierroYVuelvoAAbrirLaApp() {
        pasajero.attemptsTo(
                ReiniciarElNavegador.reiniciar(),
                AbrirPaginaDeBusqueda.en()
        );
        WaitTime.putWaitTimeOf(1500);
    }

}