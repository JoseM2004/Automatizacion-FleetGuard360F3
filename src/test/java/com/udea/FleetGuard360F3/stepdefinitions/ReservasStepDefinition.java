package com.udea.FleetGuard360F3.stepdefinitions;

import com.udea.FleetGuard360F3.questions.LosViajesEncontrados;
import com.udea.FleetGuard360F3.tasks.BuscarViajes;
import com.udea.FleetGuard360F3.tasks.EstarAutenticado;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ReservasStepDefinition {

    // NOTA: En un proyecto real, el Actor y WebDriver se inicializan en Hooks (Clase común @Before)
    // Para simplificar, asumimos que 'pasajero' está configurado y tiene la habilidad BrowseTheWeb.
    private Actor pasajero = Actor.named("Pasajero Buscador");

    // 1. Declarar y gestionar el WebDriver
    @Managed(driver = "chrome")
    public WebDriver navegador;

    @Before
    public void setTheStage() {
        // ¡PASO CRÍTICO!: Asigna la habilidad de usar el navegador al Actor.
        pasajero.can(BrowseTheWeb.with(navegador));
    }

    @Given("que estoy autenticado como pasajero")
    public void queEstoyAutenticadoComoPasajero() {
        // Reutiliza la lógica de login
        pasajero.attemptsTo(
                EstarAutenticado.conCredencialesValidas()
        );
    }

    @When("busco viajes")
    public void buscoViajesDeAparaLaFecha(DataTable table) {

        Map<String, String> data = table.asMaps().get(0);

        pasajero.attemptsTo(
                BuscarViajes.conFiltros(data.get("origen"), data.get("destino"), data.get("fecha"))
        );
    }

    @Then("veo una lista de viajes que coinciden con su disponibilidad de asientos")
    public void veoUnaListaDeViajesQueCoincidenConSuDisponibilidadDeAsientos() {
        // Verifica la Question
        pasajero.should(
                seeThat(LosViajesEncontrados.sonVisibles(), is(true))
        );
    }
}