package Lecture7_backendTesting.Model;

import java.math.BigDecimal;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class Main {
    private BigDecimal temp;
    private BigDecimal pressure;
    private int humidity;
    private BigDecimal temp_min;
    private BigDecimal temp_max;

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(BigDecimal temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(BigDecimal temp_max) {
        this.temp_max = temp_max;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public BigDecimal getTemp_min() {
        return temp_min;
    }

    public BigDecimal getTemp_max() {
        return temp_max;
    }
}
