package Lecture8;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by aleksandrs on 21/05/2017.
 */
public class ScorePage {
    static WebUtils web;

    private static final By ADD_SCORE_BUTTON = By.xpath("//*[@class='score']");
    private static final By AGE_INPUT_FIELD = By.xpath("//*[@class='age']");
    private static final By CITY_INPUT_FIELD = By.xpath("//*[@class='city']");
    private static final By COUNTRY_INPUT_FIELD = By.xpath("//*[@class='country']");
    private static final By CHILDREN_COUNT_INPUT_FIELD = By.xpath("//*[@class='childrenCount']");

    private static final By SUBMIT_BUTTON = By.xpath("//*[@type='submit']");


    public static void addScore() throws Exception {
        web.waitUntil(visibilityOfElementLocated(ADD_SCORE_BUTTON));
        web.click(ADD_SCORE_BUTTON);
    }

    public static void inputAge(Integer age) throws Exception {
        web.waitUntil(visibilityOfElementLocated(AGE_INPUT_FIELD));
        web.click(AGE_INPUT_FIELD);
        web.typeInt(AGE_INPUT_FIELD, age);
    }

    public static void inputCity(String city) throws Exception {
        web.waitUntil(visibilityOfElementLocated(CITY_INPUT_FIELD));
        web.click(CITY_INPUT_FIELD);
        web.type(CITY_INPUT_FIELD, city);

    }

    public static void inputCountry(String country) throws Exception {
        web.waitUntil(visibilityOfElementLocated(COUNTRY_INPUT_FIELD));
        web.click(COUNTRY_INPUT_FIELD);
        web.type(COUNTRY_INPUT_FIELD, country);

    }

    public static void inputChildrenCount(Integer childrenCount) throws Exception {
        web.waitUntil(visibilityOfElementLocated(CHILDREN_COUNT_INPUT_FIELD));
        web.click(CHILDREN_COUNT_INPUT_FIELD);
        web.typeInt(CHILDREN_COUNT_INPUT_FIELD, childrenCount);

    }

    public static void submit() throws Exception {
        web.waitUntil(visibilityOfElementLocated(SUBMIT_BUTTON));
        web.click(SUBMIT_BUTTON);
    }


//    private static class Range {
//        public int upper, value;
//    }
//
//        NavigableMap<Integer,Range> map = new TreeMap<Integer, Range>();
//        map.put(23, new Range(35, 300));
//        map.put(36, new Range(50, 250));
//        map.put(51, new Range(60, 200));
//        map.put(61, new Range(200, 100));
//    Map.Entry<Integer,Range> entry = map.floorEntry(key);
//    if (entry==null)
//
//    {
//
//    }


//        Score for age:
//        <=22 – 200
//        23 – 35 – 300
//        35 – 50 – 250
//        51 – 60 – 200
//        61 - … - 100

}
