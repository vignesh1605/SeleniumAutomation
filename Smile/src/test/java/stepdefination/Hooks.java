package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import reusablecode.BrowserLaunch;

import java.io.IOException;

public class Hooks extends BrowserLaunch{

    @Before()
    public void preCondition() throws IOException, InterruptedException {

        BrowserLaunch.launchUrl();
        System.out.println("Execution is starter");

    }

    @AfterStep
    public void takeScreenShot(Scenario sc) {

        byte[] byteData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        sc.attach(byteData,"image/png",sc.getName());
    }

    @After()
    public void postCondition(){
        BrowserLaunch.closeBrowser();
        System.out.println("Execution is finished");

    }
}
