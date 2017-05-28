package Lecture7_backendTesting.Model;

import java.math.BigDecimal;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class Wind {
    private BigDecimal speed;
    private BigDecimal deg;

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public void setDeg(BigDecimal deg) {
        this.deg = deg;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public BigDecimal getDeg() {
        return deg;
    }
}
