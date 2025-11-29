package com.udea.FleetGuard360F3.tasks;

import com.udea.FleetGuard360F3.userinterfaces.PaginaDeLogin;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EstarAutenticado implements Task {

    // 1. Usa tu PageObject de Login (que sí se puede instanciar)
    private PaginaDeLogin paginaDeInicio;

    private static final String USUARIO_AUTH = "JoseM";
    private static final String CLAVE_AUTH = "Jose3127674676";

    public EstarAutenticado() {
        // 2. Instancia tu PageObject concreto, no el abstracto de Serenity.
        this.paginaDeInicio = new PaginaDeLogin();
    }

    public static EstarAutenticado conCredencialesValidas() {
        return instrumented(EstarAutenticado.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 3. NAVEGACIÓN: Abre la URL base usando tu objeto concreto
                Open.browserOn().the(paginaDeInicio),

                // 4. TAREA DE LOGIN:
                IniciarSesion.conCredenciales(USUARIO_AUTH, CLAVE_AUTH)
        );
    }
}