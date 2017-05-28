package Lecture8;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 21/05/2017.
 */
public class MainQAPage {

    private static final By ADD_USER_BUTTON = By.xpath("//*[@href='addUser']");

    static WebUtils web;

    public static void openMain(String webPage) {
        web.open(webPage);
    }

    public static void addUser() throws Exception {
        web.waitUntil((visibilityOfElementLocated(ADD_USER_BUTTON)));
        web.click(ADD_USER_BUTTON);
    }

    public static boolean scoreIsDisplayed() throws Exception {
        By score = By.xpath("(//div[@class='score'])[last()]");
        web.waitUntil(visibilityOfElementLocated(score));
        return web.findElement(score).isDisplayed();
    }

    public static boolean nameIsDisplayed(String name) throws Exception {
        By userName = By.xpath("//*[@class='name' and text()='" + name + "']");
        web.waitUntil(visibilityOfElementLocated(userName));
        return web.findElement(userName).isDisplayed();
    }

    public static boolean surnameIsDisplayed(String surname) throws Exception {
        By surName = By.xpath("//*[@class='surname' and text()= '" + surname + "']");
        web.waitUntil(visibilityOfElementLocated(surName));
        return web.findElement(surName).isDisplayed();
    }

    public static boolean inputPhoneIsDisplayed(String phone) throws Exception {
        By phoneNumber = By.xpath("//*[@class='phone' and text()= '" + phone + "']");
        web.waitUntil(visibilityOfElementLocated(phoneNumber));
        return web.findElement(phoneNumber).isDisplayed();
    }

    public static boolean inputEmailIsDisplayed(String email) throws Exception {
        By userEmail = By.xpath("//*[@class='email' and text()= '" + email + "']");
        web.waitUntil(visibilityOfElementLocated(userEmail));
        return web.findElement(userEmail).isDisplayed();
    }

    public static boolean chooseGenderIsDisplayed(String gender) throws Exception {
        By userGender = By.xpath("//*[@class='gender' and text()= '" + gender + "']");
        web.waitUntil(visibilityOfElementLocated(userGender));
        return web.findElement(userGender).isDisplayed();
    }

    public static boolean inputIdIsDisplayed(String id) throws Exception {
        By userID = By.xpath("//*[@class='personId' and text()= '" + id + "']");
        web.waitUntil(visibilityOfElementLocated(userID));
        return web.findElement(userID).isDisplayed();
    }
}
