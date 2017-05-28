package Utils;

import org.joda.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 02/04/2017.
 */
class WebUtils {

    WebDriver driver;
    public static final int DEFAULT_WEBDRIVER_TIMEOUT_SECONDS = 30;


    public void waitForElement(By element, long millis) {
        WebDriverWait wait = new WebDriverWait(driver, millis);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void waitUntil(ExpectedCondition<?> until, Duration duration, boolean stopOnFailure) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, duration.getStandardSeconds());
        try {
            wait.until(until);
        } catch (Exception e) {
            if (stopOnFailure) {
                throw e;
            }
        }
    }

    public void waitUntil(ExpectedCondition<?> until, boolean stopOnFailure) throws Exception {
        waitUntil(until, Duration.standardSeconds(DEFAULT_WEBDRIVER_TIMEOUT_SECONDS), stopOnFailure);
    }
}