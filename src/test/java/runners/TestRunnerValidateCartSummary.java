package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/tests/",
        glue = {"stepDefinitions"},
        tags = {"@ValidateCartSummary"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class TestRunnerValidateCartSummary {
}
