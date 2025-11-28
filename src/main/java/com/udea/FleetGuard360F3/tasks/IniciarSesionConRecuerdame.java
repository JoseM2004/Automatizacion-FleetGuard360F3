package com.udea.FleetGuard360F3.tasks;


import com.udea.FleetGuard360F3.userinterfaces.PaginaLogin;
import com.udea.FleetGuard360F3.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionConRecuerdame implements Task {

    private final String user;
    private final String contrasena;

    public IniciarSesionConRecuerdame(String user, String contrasena) {
        this.user = user;
        this.contrasena = contrasena;
    }

    public static IniciarSesionConRecuerdame conCredenciales(String email, String contrasena) {
        return instrumented(IniciarSesionConRecuerdame.class, email, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Ingresa credenciales
                Enter.theValue(user).into(PaginaLogin.CAMPO_USER),
                Enter.theValue(contrasena).into(PaginaLogin.CAMPO_CONTRASENA),

                // 2. Marca la casilla "Recuérdame"
                Click.on(PaginaLogin.CHECKBOX_RECORDARME),

                // 3. Presiona el botón

                Click.on(PaginaLogin.BOTON_INICIAR_SESION)
        );

        WaitTime.putWaitTimeOf(2000);
    }
}
