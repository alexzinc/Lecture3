package Lecture7_backendTesting;

import Lecture7_backendTesting.Model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class weatherTest {
    @Test
    public void weatherTest() throws IOException {
        //Get response from server
        WeatherRequester requester = new WeatherRequester();
        Response response = requester.getWeather();
        //Check response
        Assert.assertEquals("Wrong LON:", BigDecimal.valueOf(-0.13), response.getCoord().getLon());
        Assert.assertEquals("Wrong LAT:", BigDecimal.valueOf(51.51), response.getCoord().getLat());
    }
}
