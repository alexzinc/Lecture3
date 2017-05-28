package Lecture5_POM;

import org.joda.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class EmailPage {
    static WebUtils web;

    private static final By SUPPORT_LETTER = By.xpath("//*[@class='inc-mail-address']");
    private static final By EMAIL_APPROVAL_LINK = By.xpath("//*[contains(text(),'register/confirm')]");
    private static final By EMAIL = By.xpath("//*[@id='mailAddress']");

    public static String getEmail(String mailbox) throws Exception {
        web.open(mailbox);
        String azaza = web.findElement(EMAIL).getAttribute("value");
        System.out.println(azaza);
        return web.findElement(EMAIL).getAttribute("value");
    }

    public static void verifyEmail() throws Exception {
        web.waitFor(Duration.standardSeconds(40));
        web.refresh();
        web.waitUntil(visibilityOfElementLocated(SUPPORT_LETTER));
        web.click(SUPPORT_LETTER);
        web.waitUntil(visibilityOfElementLocated(EMAIL_APPROVAL_LINK));
        web.click(EMAIL_APPROVAL_LINK);
    }
}