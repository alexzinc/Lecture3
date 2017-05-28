package Lecture8;

import org.joda.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


/**
 * Created by aleksandrs on 02/04/2017.
 */
class WebUtils {

    public static final int DEFAULT_WEBDRIVER_TIMEOUT_SECONDS = 30;
    WebDriver driver;

    public void waitForElement(By element, long millis) {
        WebDriverWait wait = new WebDriverWait(driver, millis);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void waitUntil(ExpectedCondition<?> until, Duration duration) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, duration.getStandardSeconds());
        try {
            wait.until(until);
        } catch (Exception e) {
            throw e;
        }
    }

    public void waitUntil(ExpectedCondition<?> until) throws Exception {
        waitUntil(until, Duration.standardSeconds(DEFAULT_WEBDRIVER_TIMEOUT_SECONDS));
    }

    public WebElement findElement(By by) throws Exception {
        waitUntil(visibilityOfElementLocated(by), Duration.standardSeconds(2));
        WebElement elementToFind = null;
        try {
            elementToFind = driver.findElement(by);
        } catch (Exception e) {
            throw e;
        }
        return elementToFind;
    }

    public void type(By by, String text) throws Exception {
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    public void typeInt(By by, Integer num) throws Exception {
        findElement(by).clear();
        findElement(by).sendKeys(num.toString());
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void waitFor(Duration duration) throws Exception {
        try {
            waitUntil(visibilityOfElementLocated(By.xpath("//nonexisting")), duration);
        } catch (Exception e) {
            throw e;
        }
    }

    public Select select(By by) throws Exception {
        return new Select(findElement(by));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void open(String path) {
        System.setProperty("webdriver.gecko.driver", Configuration.browserPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(path);
    }

    public static boolean isDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}