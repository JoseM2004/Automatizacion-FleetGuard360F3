package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLogin {

    public static final Target CAMPO_USER = Target.the("campo de email")
            .located(By.id("username"));

    public static final Target CAMPO_CONTRASENA = Target.the("campo de contraseña")
            .located(By.id("password"));

    public static final Target BOTON_INICIAR_SESION = Target.the("botón Iniciar sesión")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div/div[2]/form/button"));

    public static final Target MENSAJE_ERROR = Target.the("mensaje de credenciales inválidas")
            .located(By.xpath("//div[@id='root']/div[1]/ol/li/div/div[2]"));
}