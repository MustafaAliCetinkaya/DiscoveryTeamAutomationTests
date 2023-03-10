package runners.cydeoRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "stepDefinitions",
        features = "@target/rerunFailedTests.txt"
)
public class FailedTestRunner {
}