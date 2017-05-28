package Lecture5_POM;

import org.joda.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 29/04/2017.
 */
public class RegistrationPage {

    private static final By SEARCHING_FOR_A_JOB_BUTTON = By.xpath("//*[text()='darba meklētājs']");
    private static final By USERNAME_INPUT_FIELD = By.xpath("//*[@id='first_name']");
    private static final By LASTNAME_INPUT_FIELD = By.xpath("//*[@id='last_name']");
    private static final By EMAIL_INPUT_FIELD = By.xpath("//*[@id='epost']");
    private static final By PHONE_NUMBER_INPUT_FIELD = By.xpath("//*[@id='contact_tel']");
    private static final By JOB_CATEGORY_DROPDOWN = By.xpath("//*[@id='desc_tegvk_id']");
    private static final By EMAIL_SPAM_RADIO_BUTTON = By.xpath("//*[@id='desc_spam_email']//ancestor::tr//*[@type='radio' and @name='andmed[spam_email]' and @value='2']");
    private static final By SMS_SPAM_RADIO_BUTTON = By.xpath("//*[@id='desc_spam_sms_jobad']//ancestor::tr//*[@type='radio' and @name='andmed[spam_sms_jobad]' and @value='2']");
    private static final By EMAIL_SMS_SPAM_RADIO_BUTTON = By.xpath("//*[@id='desc_spam_sms']//ancestor::tr//*[@type='radio' and @name='andmed[spam_sms]' and @value='2']");
    private static final By REGISTRATION_BUTTON = By.xpath("//*[@class='blue_submit']");

    static WebUtils web;

    public static void createAccount() throws Exception {
    }


    public static void openSearchForAJob() throws Exception {
        web.waitUntil(visibilityOfElementLocated(SEARCHING_FOR_A_JOB_BUTTON));
        web.click(SEARCHING_FOR_A_JOB_BUTTON);
    }

    public static void inputUsername(String username) throws Exception {
        web.waitUntil(visibilityOfElementLocated(USERNAME_INPUT_FIELD));
        web.click(USERNAME_INPUT_FIELD);
        web.type(USERNAME_INPUT_FIELD, username);

    }

    public static void inputLastname(String lastname) throws Exception {
        web.waitUntil(visibilityOfElementLocated(LASTNAME_INPUT_FIELD));
        web.click(USERNAME_INPUT_FIELD);
        web.type(LASTNAME_INPUT_FIELD, lastname);

    }

    public static void inputEmail(String email) throws Exception {
        web.waitUntil(visibilityOfElementLocated(EMAIL_INPUT_FIELD));
        web.click(EMAIL_INPUT_FIELD);
        web.type(EMAIL_INPUT_FIELD, email);

    }

    public static void inputPhone(String phoneNumber) throws Exception {
        web.waitUntil(visibilityOfElementLocated(PHONE_NUMBER_INPUT_FIELD));
        web.click(PHONE_NUMBER_INPUT_FIELD);
        web.type(PHONE_NUMBER_INPUT_FIELD, phoneNumber);

    }

    public static void chooseJobCategory(String category) throws Exception {
        web.waitUntil(visibilityOfElementLocated(JOB_CATEGORY_DROPDOWN));
        web.click(JOB_CATEGORY_DROPDOWN);

        WebElement jobCategory = web.findElement(By.xpath("//*[@class='text' and @name='andmed[tegvk_id]']"));
        Select mySelect = new Select(jobCategory);
        List<WebElement> jobOptions = mySelect.getOptions();
        for (WebElement option : jobOptions) {
            if (option.getText().equalsIgnoreCase(category)) {
                option.click();
            }
        }
    }

    public static void setEmailSpam() throws Exception {
        web.waitUntil(visibilityOfElementLocated(EMAIL_SPAM_RADIO_BUTTON));
        web.click(EMAIL_SPAM_RADIO_BUTTON);
    }

    public static void signUp() throws Exception {
        web.waitUntil(visibilityOfElementLocated(REGISTRATION_BUTTON));
        web.click(REGISTRATION_BUTTON);
    }

    public static void userIsRegistered() throws  Exception {

    }
}
