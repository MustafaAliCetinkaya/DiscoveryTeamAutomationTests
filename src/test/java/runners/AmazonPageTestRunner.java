package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@amazonSearch",
        dryRun = false          //False-->Means directly start the tests / True-->Check for the missing methods, do not run
)
public class AmazonPageTestRunner {

}
