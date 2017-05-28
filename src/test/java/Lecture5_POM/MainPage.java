package Lecture5_POM;

import org.joda.time.Duration;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


/**
 * регистрация в cv.lv
 * проверка востановление пароля на cv.lv
 */

public class MainPage extends WebUtils {

    static WebUtils web;
    private static final By REGISTRATION_BUTTON = By.xpath("//*[text()='Reģistrēties']");

    public static void openRegistration() throws Exception {
        web.waitUntil(visibilityOfElementLocated(REGISTRATION_BUTTON));
        web.click(REGISTRATION_BUTTON);
    }

    public static void openWeb(String webPage) {
        web.open(webPage);
    }


    public static void closePopupAds() throws Exception {
        By closePopup = By.xpath("//*[@class='close']");
        if (web.findElement(closePopup).isDisplayed()) {
            web.waitUntil(visibilityOfElementLocated(closePopup), Duration.standardSeconds(6));
            web.click(closePopup);
        }
    }
}
