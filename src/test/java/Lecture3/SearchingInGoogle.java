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
        System.setProperty("webdriver.gecko.driver", "/Users/aleksandrs/QAcourses/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.lv");
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        WebElement searchBarElement = driver.findElement(SEARCH_BAR);
        searchBarElement.sendKeys("groovyforlife");
        searchBarElement.submit();
        WebDriverWait waitForElement = new WebDriverWait(driver, 4);
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(GROOVY_LIFE_SHOP));
        assert driver.findElement(GROOVY_LIFE_SHOP).isDisplayed();
        driver.quit();
    }
}
