package com.udea.FleetGuard360F3.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/register")
public class RegisterPage extends PageObject {
    public static final Target DESCRIPTION_REGISTER = Target.the("Description Register")
            .located(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div[1]/p"));

    public static final Target INPUT_TEXT_NAME = Target.the("Text Box Name")
            .located(By.id("nombre"));
    public static final Target INPUT_TEXT_LASTNAME = Target.the("Text Box Name")
            .located(By.id("apellido"));
    public static final Target INPUT_TEXT_USER = Target.the("Text Box Username")
            .located(By.id("username"));
    public static final Target BTN_TYPE_ID = Target.the("Btn Type ID")
            .located(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div[2]/form/div[3]/div[1]/button"));
    public static final Target SELECT_TYPE_ID = Target.the("Combobox Type ID")
            .located(By.cssSelector("select[aria-hidden]"));
    public static final Target INPUT_TEXT_ID = Target.the("Text Box ID")
            .located(By.id("identificacion"));
    public static final Target INPUT_TEXT_PHONE = Target.the("Text Box Phone")
            .located(By.id("phone"));
    public static final Target INPUT_TEXT_EMAIL = Target.the("Text Box Email")
            .located(By.id("email"));
    public static final Target INPUT_TEXT_PASS = Target.the("Text Box Pass")
            .located(By.id("password"));
    public static final Target PASSWORD_ERROR = Target.the("Password Error")
            .located(By.id("password-error"));
    public static final Target INPUT_TEXT_CONFIRM_PASS = Target.the("Text Box Confirm Pass")
            .located(By.id("confirmPassword"));
    public static final Target ACCEPT_TERMS = Target.the("Checkbox Accept Terms")
            .located(By.id("acceptTerms"));
    public static final Target ACCEPT_TERMS_ERROR = Target.the("Accept Terms Error")
            .located(By.id("acceptTerms-error"));

    public static final Target REGISTER_BUTTON = Target.the("Register Button")
            .located(By.xpath("//*[@id=\"root\"]/div[2]/main/div/div/div[2]/form/button"));


    public static final Target FLOATING_MESSAGE = Target.the("Floating message")
            .located(By.xpath("//*[@id=\"root\"]/div[1]/ol/li/div/div[2]"));

}
