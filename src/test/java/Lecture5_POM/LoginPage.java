package Lecture5_POM;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 02/05/2017.
 */
public class LoginPage {
    static WebUtils web;

    private static final By FORGOT_PASSWORD_BUTTON = By.xpath("//*[@class='forgot arrow']");
    private static final By PASSOWRD_RECOVERY_INPUT_FIELD = By.xpath("//*[@id='email']");
    private static final By PASSWORD_RECOVERY_SUBMIT_BUTTON = By.xpath("//*[@class='blue_submit']");
    private static final By USERNAME_INPUT_FIELD = By.xpath("//*[@id='kasutajanimi']");
    private static final By PASSWORD_INPUT_FIELD = By.xpath("//*[@id='parool']");

    public static void openPasswordRecovery() throws Exception {
        web.waitUntil(visibilityOfElementLocated(FORGOT_PASSWORD_BUTTON));
        web.click(FORGOT_PASSWORD_BUTTON);
    }

    public static void recoverPassword(String email) throws Exception {
        web.waitUntil(visibilityOfElementLocated(PASSOWRD_RECOVERY_INPUT_FIELD));
        web.click(PASSOWRD_RECOVERY_INPUT_FIELD);
        web.type(USERNAME_INPUT_FIELD, email);
        web.click(PASSWORD_RECOVERY_SUBMIT_BUTTON);
    }

    public static void logIn(String email, String password) throws Exception {
        web.waitUntil(visibilityOfElementLocated(USERNAME_INPUT_FIELD));
        web.type(USERNAME_INPUT_FIELD, email);
        web.type(PASSWORD_INPUT_FIELD, password);
    }
}
