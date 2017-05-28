package Lecture5_POM

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
 * Created by aleksandrs on 01/05/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test", features = "src/test/java/Lecture5_POM", glue = "src/test/java/Lecture5_POM")
class TestRunner {
}