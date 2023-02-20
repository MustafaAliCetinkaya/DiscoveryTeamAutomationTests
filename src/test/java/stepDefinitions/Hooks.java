package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;


public class Hooks {
    @After
    public void tearDown(Scenario scenario) {

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)
                    Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }

        Driver.closeDriver();
    }

}
/*2- byte [] screenshot = We are creating an array of bytes to be able to store our screenshot
3- ((TakesScreenshot)Driver.getDriver()) ---> we are downcasting our driver type to TakesScreenshot
4- .getScreenshotAs(OutputType.BYTES); ---> we are returning the screenshot as byte so we can use
5- scenario.attach() --> this method is able to attach the screenshot into our report
    - it accepts 3 arguments
    arg1 : array of bytes --> byte [] screenshot :
    arg2 : String image type -->  "image/png"
    arg3 : String scenario name --> scenario.getName()
*/