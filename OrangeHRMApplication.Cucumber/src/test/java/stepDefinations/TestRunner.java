package stepDefinations;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith()
@CucumberOptions(features={"/src/main/java/OHRMApplication.Feature"},//Folder info of the feature file
                           glue={"stepDefinations"},//Create a connection between the feature file and the 
                                                  //package - in with the methods 
                           monochrome=true
                           )


public class TestRunner {

}
