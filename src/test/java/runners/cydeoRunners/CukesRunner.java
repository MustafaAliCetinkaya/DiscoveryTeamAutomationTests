package runners.cydeoRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty", not necessary. Because basically it just prints out additional information about the scenario that is being executed.
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
    },

        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        tags = "@TC012"
        //publish = true will enable a functionality from cucumber to generate a public daily link for the report of our final execution of our code

)
public class CukesRunner {
}

