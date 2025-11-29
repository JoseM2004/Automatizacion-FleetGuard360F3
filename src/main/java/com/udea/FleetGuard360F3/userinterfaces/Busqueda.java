package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Busqueda {

    // Asume que esta es la página a la que llega el usuario después del login

    // Target para el botón que abre el selector de Origen (el que tiene role='combobox')
    public static final Target CAMPO_ORIGEN = Target.the("campo/boton origen del viaje")
            // Selector robusto para el combobox de origen
            .located(By.xpath("//button[@role='combobox' and span[text()='Seleccionar origen']]"));

    public static final Target CAMPO_DESTINO = Target.the("campo/boton destino del viaje")
            // Asumimos un patrón similar para el destino
            .located(By.xpath("//button[@role='combobox' and span[text()='Seleccionar destino']]"));

    public static final Target BOTON_ABRIR_CALENDARIO = Target.the("botón para seleccionar la fecha")
            .located(By.xpath("//button[@aria-haspopup='dialog' and contains(., 'Seleccionar fecha')]"));

    public static Target DIA_DEL_CALENDARIO(String dia) {
        return Target.the("día " + dia + " en el calendario")
                .located(By.xpath("//button[@role='gridcell' and text()='" + dia + "' and not(@disabled)]"));
    }

    public static Target OPCION_CIUDAD(String ciudad) {
        return Target.the("opcion de ciudad " + ciudad)
                .located(By.xpath("//div[contains(@id, 'radix')]//*[text()='" + ciudad + "']"));
    }

    public static final Target BOTON_BUSCAR = Target.the("botón Buscar viajes")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div[2]/div[2]/form/div[4]/button")); // AJUSTAR SELECTOR REAL

    public static final Target LISTA_VIAJES = Target.the("lista de viajes encontrados")
            .located(By.xpath("//*[@id='root']/div[2]/main/div/div[3]/div[1]/h3"));

    public static final Target ETIQUETA_ESTADO_AGOTADO = Target.the("Etiqueta de estado Agotado en la tarjeta")
            // Buscamos el span que tiene la clase 'font-medium' y el texto 'Agotado'
            .located(By.xpath("//span[contains(@class, 'font-medium') and text()='Agotado']"));

    public static final Target BOTON_AGOTADO_DESHABILITADO = Target.the("Boton 'Agotado' Deshabilitado")
            .located(By.xpath("//button[@disabled and text()='Agotado']"));
}

