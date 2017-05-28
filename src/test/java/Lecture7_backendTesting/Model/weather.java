package Lecture7_backendTesting.Model;

/**
 * Created by aleksandrs on 07/05/2017.
 */
public class Weather {

    private long id;
    private String main;
    private String description;
    private String icon;

    public void setId(long id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
