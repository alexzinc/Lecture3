package WebApplication;
        import org.openqa.selenium.*;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
        import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


        import java.util.ArrayList;

/**
 * Created by aleksandrs on 02/04/2017.
 */
class WebApplication {

}






class WebApplication {

    private static String lastActiveTab

    private static ArrayList<WebDriver> userDrivers

    private static WebDriver webDriver

    WebApplication(WebDriver webDriver) {
        this.webDriver = webDriver
        userDrivers = new ArrayList<>()
    }

    static WebDriver driver() {
        return webDriver
    }