package Lecture7_backendTesting.Model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by aleksandrs on 07/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {


    private Coordinates coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private int visibility;

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }


}
