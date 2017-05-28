package Lecture7_backendTesting.Model;

import java.math.BigDecimal;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class Coordinates {


    private BigDecimal lon;
    private BigDecimal lat;

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public BigDecimal getLat() {
        return lat;
    }
}
