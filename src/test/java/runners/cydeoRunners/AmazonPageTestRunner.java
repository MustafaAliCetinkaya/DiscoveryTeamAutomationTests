package runners.cydeoRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@amazonSearch",
        dryRun = false          //False-->Means directly start the tests / True-->Check for the missing methods, do not run
        //publish = true will enable a functionality from cucumber to generate a public daily link for the report of our final execution of our code

)
public class AmazonPageTestRunner {

}
