package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/testdesign"},
        glue = {"stepdefination"},
        plugin = {"pretty",
                "html:target/testreport/htmltrport.html",
                "json:target/testreport/jsonreport.json",
                "junit:target/testreport/xmlreport.xml"},
        tags = "@regressiontest"

)
public class RegressionRunner {
}
