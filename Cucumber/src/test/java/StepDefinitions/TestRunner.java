package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "OHRM_Feature",
                             glue="StepDefinitions",
                             monochrome = true,
                            // dryRun=true
                             tags="@OrangeHRMApplicationLoginTest"
                             )

public class TestRunner {

}
