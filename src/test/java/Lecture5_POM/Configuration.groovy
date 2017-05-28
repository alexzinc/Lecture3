package Lecture5_POM

/**
 * Created by aleksandrs on 21/05/2017.
 */
class Configuration {

    public static final String WEB_URL = "https://cv.lv"
    public static final String DEFAULT_PASSWORD = "test12345"

    public static String webUrl = getVar("web.url", WEB_URL)
    public static String browser = getVar("browser")

    static String getVar(String name, String defaultValue = null) {
        System.getenv(name) ?: System.getenv(name.toLowerCase()) ?: System.getProperty(name) ?: System.getProperty(name.toLowerCase()) ?: defaultValue
    }
}