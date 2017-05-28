package Lecture8;

import Lecture7_backendTesting.Model.Gender;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 21/05/2017.
 */
public class AddUserPage {

    static WebUtils web;

    private static final By NAME_INPUT_FIELD = By.xpath("//*[@name='name']");
    private static final By SURNAME_INPUT_FIELD = By.xpath("//*[@name='surname']");
    private static final By PHONE_INPUT_FIELD = By.xpath("//*[@name='phone']");
    private static final By EMAIL_INPUT_FIELD = By.xpath("//*[@name='email']");
    private static final By GENDER_DROPDOWN_LIST = By.xpath("//*[@type='submit']");
    private static final By ID_INPUT_FIELD = By.xpath("//*[@type='submit']");
    private static final By ADD_USER_BUTTON = By.xpath("//*[@type='submit']");

    public static void inputName(String name) throws Exception {
        web.waitUntil(visibilityOfElementLocated(NAME_INPUT_FIELD));
        web.click(NAME_INPUT_FIELD);
        web.type(NAME_INPUT_FIELD, name);
    }

    public static void inputSurname(String surname) throws Exception {
        web.waitUntil(visibilityOfElementLocated(SURNAME_INPUT_FIELD));
        web.click(SURNAME_INPUT_FIELD);
        web.type(SURNAME_INPUT_FIELD, surname);
    }

    public static void inputPhone(String phone) throws Exception {
        web.waitUntil(visibilityOfElementLocated(PHONE_INPUT_FIELD));
        web.click(PHONE_INPUT_FIELD);
        web.type(PHONE_INPUT_FIELD, phone);
    }

    public static void inputEmail(String email) throws Exception {
        web.waitUntil(visibilityOfElementLocated(EMAIL_INPUT_FIELD));
        web.click(EMAIL_INPUT_FIELD);
        web.type(EMAIL_INPUT_FIELD, email);
    }

    public static void chooseGender(Gender gender) throws Exception {
        web.select(GENDER_DROPDOWN_LIST).selectByValue(gender == Gender.MALE ? "2" : "1");
    }

    public static void inputId(String userId) throws Exception {
        web.waitUntil(visibilityOfElementLocated(ID_INPUT_FIELD));
        web.click(ID_INPUT_FIELD);
        web.type(ID_INPUT_FIELD, userId);
    }

    public static void createUser() throws Exception {
        web.waitUntil(visibilityOfElementLocated(ADD_USER_BUTTON));
        web.click(ADD_USER_BUTTON);
    }
}