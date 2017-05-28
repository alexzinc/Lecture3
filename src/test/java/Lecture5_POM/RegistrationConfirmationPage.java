package Lecture5_POM;

import org.openqa.selenium.By;

/**
 * Created by aleksandrs on 21/05/2017.
 */
public class RegistrationConfirmationPage {

    static WebUtils web;

    public static boolean userIsRegistered() throws Exception {
        By REGISTRATION_CONFIRMATION_TEXT = By.xpath("//*[@class='box-inner inner-content'");
        return web.findElement(REGISTRATION_CONFIRMATION_TEXT).isDisplayed();
    }
}
