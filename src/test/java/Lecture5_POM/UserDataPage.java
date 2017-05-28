package Lecture5_POM;


import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 14/05/2017.
 */
public class UserDataPage {

    static WebUtils web;
    private static final By LOG_OUT = By.xpath("//*[@href='/darba-mekletajiem?logout=1']");

    public static void logOut() throws Exception {
        web.waitUntil(visibilityOfElementLocated(LOG_OUT));
        web.click(LOG_OUT);
    }
}
