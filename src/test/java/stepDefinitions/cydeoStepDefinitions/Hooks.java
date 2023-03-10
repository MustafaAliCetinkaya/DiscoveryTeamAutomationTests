package stepDefinitions.cydeoStepDefinitions;

/*
 In the class we will be able to pass pre- & post- conditions to
 each scenario and each step

 @Before and @After is executed before each scenario. They resemble @BeforeMethod/@AfterMethod in TestNG.
 @BeforeStep and @AfterStep is executed for each Gherkin sentence (@Given/And/Then annotation)

Whatever happens in a Before hook is invisible to people who only read the features.
You should consider using a background as a more explicit alternative, especially
if the setup should be readable by non-technical people. Only use a Before hook for
low-level logic such as starting a browser or deleting data from a database.
 */

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;
import utilities.Driver;

public class Hooks {

    //import from io.cucumber.java not from junit
    //@Before (order = 1)
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    //@Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){
        System.out.println("====this will only apply to scenarios with @login tag");
    }

    //@Before (value = "@db", order = 0)    //Comes from cucumber-java. Do not select the Junit one.
    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After  //Comes from cucumber-java. Do not select the Junit one.
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        BrowserUtils.sleep(5);


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

   //@BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}