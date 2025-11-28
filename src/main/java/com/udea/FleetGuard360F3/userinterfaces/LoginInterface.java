package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginInterface {

    // Identificador para el campo de email
    public static final Target CAMPO_USER = Target.the("campo de email")
            .located(By.id("username"));

    // Identificador para el campo de contrase├▒a
    public static final Target CAMPO_CONTRASENA = Target.the("campo de contraseña")
            .located(By.id("password"));

    // Identificador para el bot├│n de iniciar sesi├│n
    public static final Target BOTON_INICIAR_SESION = Target.the("boton Iniciar sesión")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div/div[2]/form/button")); // Usando XPATH de texto como ejemplo
}
