package com.udea.FleetGuard360F3.stepdefinitions;

import com.udea.FleetGuard360F3.questions.EstadoDelViaje;
import com.udea.FleetGuard360F3.questions.LosViajesEncontrados;
import com.udea.FleetGuard360F3.questions.MensajeDeReserva;
import com.udea.FleetGuard360F3.tasks.BuscarViajes;
import com.udea.FleetGuard360F3.tasks.ConfirmarReserva;
import com.udea.FleetGuard360F3.tasks.EstarAutenticado;
import com.udea.FleetGuard360F3.tasks.SeleccionarViajeConCupo;
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


    public void setTheStage() {
        // ¡PASO CRÍTICO!: Asigna la habilidad de usar el navegador al Actor.
        pasajero.can(BrowseTheWeb.with(navegador));
        pasajero.attemptsTo(
                EstarAutenticado.conCredencialesValidas()
        );
    }

    @Given("que estoy autenticado como pasajero")
    public void queEstoyAutenticadoComoPasajero() {
        setTheStage();
        // Reutiliza la lógica de login
        /*pasajero.attemptsTo(
                EstarAutenticado.conCredencialesValidas()
        );*/
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

    @Given("que selecciono un viaje con cupo")
    public void queSeleccionoUnViajeConCupo(DataTable table) {

        setTheStage();
        buscoViajesDeAparaLaFecha(table);
        // Nota: Asume que el actor ya buscó viajes antes (del escenario anterior)
        pasajero.attemptsTo(
                SeleccionarViajeConCupo.seleccionar()
        );
    }

    // Paso 2: When elijo la cantidad de asientos (mayor o igual a 1) y confirmo
    @When("confirmo la reserva")
    public void elijoLaCantidadDeAsientosYConfirmo() {
        pasajero.attemptsTo(
                ConfirmarReserva.con()
        );
    }

    // Paso 3: Then el sistema verifica cupos, bloquea asientos y crea la reserva.
    @Then("veo que la disponibilidad se confirma, mi asiento queda bloqueado y mi reserva queda creada")
    public void elSistemaVerificaCuposBloqueaAsientosYCreaLaReserva() {
        // Asumes que la creación exitosa se refleja en un mensaje o una nueva pantalla.
        pasajero.should(
                seeThat("el mensaje de confirmación de reserva es visible",
                        MensajeDeReserva.esVisible(), is(true))
                // O: seeThat(LaReserva.fueCreada(), is(true))
        );
    }

    @Given("un viaje sin cupo")
    public void unViajeSinCupo(DataTable table) {
        setTheStage();
        buscoViajesDeAparaLaFecha(table);

    }

    @When("aparece en resultados")
    public void apareceEnResultados() {
        // No se requiere acción. Es un estado de la interfaz después de la búsqueda.
    }

    // Then se muestra con estado Agotado y el botón Reservar deshabilitado
    @Then("veo el viaje marcado como Agotado y noto que el botón Reservar está deshabilitado")
    public void seMuestraConEstadoAgotadoYElBotonReservarDeshabilitado() {
        pasajero.should(
                seeThat("el viaje sin cupo tiene el estado 'Agotado' y el botón de reserva deshabilitado",
                        EstadoDelViaje.sinCupo(),
                        is(true))
        );
    }
}