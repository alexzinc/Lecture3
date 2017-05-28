package Lecture3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by aleksandrs on 02/04/2017.
 */

public class SportDirect {

    private static final By CLOSE_DISCOUNT_PAGE_BUTTON = By.xpath("(//*[contains(@class,'modal-header')]//*[@class='close'])[1]");
    private static final By SPORTS_TAB_BUTTON = By.xpath("//*[contains(@class, 'sportsMenu')]/a[@href='/sport']");
    private static final By SWIMMING_TAB_BUTTON = By.xpath("//*[contains(@class,'sideNav')]//*[@href='/swimming']");
    private static final By SWIMSUITS_OPTION_BUTTON = By.xpath("//*[contains(@class,'sideNavContainer')]//*[contains(text(),'swimsuits')]");
    private static final By UNISEX_ADULTS_SWIMSUITS_BUTTON = By.xpath("//*[contains(text(), 'Unisex Adults') and @class='FilterName']");
    private static final By GIRLS_SWIMSUITS_BUTTON = By.xpath("//*[contains(text(), 'Girls') and @class='FilterName']");

    private static WebDriver driver;

    @Test
    public void checkingSportDirectItemCount() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/aleksandrs/QAcourses/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("http://lv.sportsdirect.com/");


        WebDriverWait waitForElement = new WebDriverWait(driver, 5);
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_DISCOUNT_PAGE_BUTTON));
        if (driver.findElement(CLOSE_DISCOUNT_PAGE_BUTTON).isDisplayed()) {
            driver.findElement(CLOSE_DISCOUNT_PAGE_BUTTON).click();
        }
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(SPORTS_TAB_BUTTON));
        driver.findElement(SPORTS_TAB_BUTTON).click();

        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(SWIMMING_TAB_BUTTON));
        Point hoverItem = driver.findElement(SWIMMING_TAB_BUTTON).getLocation();
        ((JavascriptExecutor) driver).executeScript("return window.title;");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (hoverItem.getY() - 400) + ");");
        driver.findElement(SWIMMING_TAB_BUTTON).click();

        openSwimmingTab();
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(UNISEX_ADULTS_SWIMSUITS_BUTTON));
        driver.findElement(UNISEX_ADULTS_SWIMSUITS_BUTTON).click();
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(GIRLS_SWIMSUITS_BUTTON));
        driver.findElement(GIRLS_SWIMSUITS_BUTTON).click();

        Thread.sleep(2000);
        List<WebElement> swimsuits = driver.findElements(By.xpath("//*[@class='rtimg MainImage img-responsive']"));
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='rtimg MainImage img-responsive']")));
        Assert.assertEquals(3, swimsuits.size());
        driver.quit();
    }

    public static void  openSwimmingTab() {
        WebDriverWait waitForElement = new WebDriverWait(driver, 5);
        waitForElement.until(ExpectedConditions.elementToBeClickable(SWIMSUITS_OPTION_BUTTON));
        driver.findElement(SWIMSUITS_OPTION_BUTTON).click();
    }
}