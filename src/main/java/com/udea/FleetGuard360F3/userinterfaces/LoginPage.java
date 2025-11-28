package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target DESCRIPTION_LOGIN = Target.the("Title Login")
            .located(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div[1]/p"));
}