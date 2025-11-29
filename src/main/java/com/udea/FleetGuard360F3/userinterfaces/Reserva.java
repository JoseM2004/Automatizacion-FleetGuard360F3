package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Reserva {
    public static final Target BOTON_RESERVA = Target.the("reservar")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div[3]/div[2]/div/div[1]/div/div/div[4]/a"));


    public static final Target BOTON_CONFIRMA = Target.the("Confirmar reserva con 1 asiento")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div/div[2]/form/button"));

    public static final Target EXITO = Target.the("Confirmar reserva con 1 asiento")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div[1]/div[1]/h3"));

}
