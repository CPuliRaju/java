package com.StepDefinations;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile",
                            glue="com.StepDefinations",
                            monochrome = true
                            )
public class TestRunner {
	

}
