package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"stepDefinitions"},
        plugin = { "pretty",
                "html:target/report/cucumber.html"},
        tags = "@smoke"
)

public class Runner extends AbstractTestNGCucumberTests {


}
