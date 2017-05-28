package Lecture4;

import org.apache.log4j.Logger;
import org.joda.time.Duration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Testing comments on rus.delfi.lv
 */
public class DelfiMainPage {

    private static final Logger LOGGER = Logger.getLogger(DelfiMainPage.class);
    private static final By FIRST_ARTICLE_COMMENT = By.xpath("(//*[@class='comment-count'])[1]");
    private static final By FIRST_ARTICLE = By.xpath("(//*[@class='top2012-title'])[1]");
    private static final By OPEN_COMMENTS = By.xpath("//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']");
    private static final By ANONYMOUS_COMMENTS = By.xpath("//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']");
    int commentCount = 0;
    private static WebDriver webDriver;

    static WebDriver driver() {
        return webDriver;
    }


    @Test
    public void delfiCommentIsDisplayed() throws Exception {
        LOGGER.info("We are starting our test");
        LOGGER.info("Setting global property for driver");
        LOGGER.info("We are opening rus.delfi.lv homepage");
        WebDriver driver = getDriver();
        driver.get("http://rus.delfi.lv");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        LOGGER.info("getting comment count in the article");
        WebElement waitForElement = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(FIRST_ARTICLE_COMMENT));
        commentCount = getCommentCount(driver);

        LOGGER.info("open first article");
        WebElement openFirstArticle = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(FIRST_ARTICLE));
        openFirstArticle.click();

        LOGGER.info("Getting comment count from title on article page");
        WebElement waitForArticleComment = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(FIRST_ARTICLE));

        Assert.assertEquals("wrong comment count article page,", commentCount, getCommentCount(driver), 0);

        LOGGER.info("moving to article comment page");


        LOGGER.info("getting registered users comment count");

        getCommentCount(driver);


        LOGGER.info("getting unregister user comment count");

        LOGGER.info("checking whole comment count");

        LOGGER.info("We are closing our browser");
        driver.quit();


    }

    public static void waitUntil(ExpectedCondition<?> until, Duration duration) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver(), duration.getStandardSeconds());
        try {
            wait.until(until);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @returns comment count of article
     */
    private Integer getCommentCount(WebDriver driver) {
        WebElement firstArticleCount = driver.findElement(FIRST_ARTICLE_COMMENT);
        String count = firstArticleCount.getText();
        commentCount = Integer.parseInt(count.substring(1, count.length() - 1));
        return commentCount;
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "/Users/aleksandrs/QAcourses/geckodriver");
        LOGGER.info("Opening firefox browser");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

//    public String waitForElement(String item) {
//        WebDriverWait wait = new WebDriverWait(driver,30).until(
//                ExpectedConditions.elementToBeClickable(By.id(item)));
//        return item;
//    }


}


// дописать этот тест
// в отдельном классе ( открываем делфи, запоминаем первых 5 статей (название, кол-во комментариев к этой статье, переходим на мобильную версию сайта и проверяем названия, кол-во комментариев к этой статье)
// в отдельном классе (получить список названий новостей + кол-во комментариев проверить, перейти на страницу пер)
// реализовывать pageobject


//    static Dimension getWindowSize() {
//        return webDriver.manage().window().getSize();
//    }
//
//    public static void  scroll(int x, int y) {
//        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
//        jse.executeScript("window.scrollBy($x,$y)");
//        return this;
//
//    }
//
//    static void scrollUp() {
//        scroll(windowSize.height - 1, 0);
//        waitFor(Duration.standardSeconds(1));
//    }
//
//    static void scrollDown() {
//        scroll(0, windowSize.height - 1);
//        waitFor(Duration.standardSeconds(1));
//    }
//
//    static void scrollTo(String text) {
//        scrollTo(By.xpath("//*[text()='$text']"));
//    }
//
//    static void scrollTo(By locatorBy) throws Exception {
//        int tries = 20;
//        boolean int scrollTimes = tries;
//        try {
//            while (scrollTimes != 0) {
//                waitUntil(ExpectedConditions.visibilityOfElementLocated(locatorBy), Duration.standardSeconds(1));
//                if (isDisplayed(locatorBy)) {
//                    break;
//                }
//                if (tries > 0) {
//                    scrollDown();
//                    scrollTimes--;
//                } else {
//                    scrollUp();
//                    scrollTimes++;
//                }
//            }
////            if (!isDisplayed(locatorBy)) throw new NoSuchElementException("Unable to find element $locatorBy by scrolling ${amount(tries).abs()} times ${tries > 0 ? "DOWN" : "UP"}!")
//        } catch (Exception exception) {
//            throw exception;
//        }
//    }
