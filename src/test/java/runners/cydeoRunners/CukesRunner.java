package runners.cydeoRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                //"rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
    },
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        tags = "@Regression"
        //publish = false

)
public class CukesRunner {
}

