package com.udea.FleetGuard360F3.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PanelDePasajero implements Question<Boolean> {


    public static final Target ENCABEZADO_BIENVENIDA = Target.the("encabezado del panel de pasajero")
            .located(By.xpath("//*[@id='root']/div[2]/header/div/p"));

    public static PanelDePasajero esVisible() {
        return new PanelDePasajero();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return ENCABEZADO_BIENVENIDA.resolveFor(actor).isVisible();
    }
}
