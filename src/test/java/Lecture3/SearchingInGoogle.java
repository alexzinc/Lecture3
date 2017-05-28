package Lecture3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by aleksandrs on 02/04/2017.
 */
public class SearchingInGoogle {

    private static final By SEARCH_BAR = By.xpath("//*[@id='lst-ib']");
    private static final By GROOVY_LIFE_SHOP = By.xpath("(//*[contains(text(),'groovyforlife')])[2]");


    @Test
    public void searchingGoogleForElement() {

        WebDriver driver = getDriver();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.get("http://google.lv");

        searchText(driver);
        WebElement groovyLifeShopIsDisplayed = (new WebDriverWait(driver, 4)
                .until(ExpectedConditions.presenceOfElementLocated(GROOVY_LIFE_SHOP)));
        assert groovyLifeShopIsDisplayed.isDisplayed();
        driver.quit();
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/aleksandrs/QAcourses/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public SearchingInGoogle searchText(WebDriver driver) {
        WebElement searchBarElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(SEARCH_BAR));
        searchBarElement.sendKeys("groovyforlife");
        searchBarElement.submit();
        return this;
    }
}
