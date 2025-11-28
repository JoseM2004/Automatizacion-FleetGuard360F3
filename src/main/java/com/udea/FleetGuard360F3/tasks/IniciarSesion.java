package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {

    private final String user;
    private final String contrasena;

    public IniciarSesion(String email, String contrasena) {
        this.user = email;
        this.contrasena = contrasena;
    }

    public static IniciarSesion conCredenciales(String user, String contrasena) {
        return instrumented(IniciarSesion.class, user, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(PaginaLogin.CAMPO_USER),
                Enter.theValue(contrasena).into(PaginaLogin.CAMPO_CONTRASENA),
                Click.on(PaginaLogin.BOTON_INICIAR_SESION)
        );
    }
}
