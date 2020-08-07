package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"feature files/zoopla.feature"},
		glue = {"com.step.def"},
		plugin = {"pretty", "html:target" , "json:target/cucumber.json" , 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome = true	
		//dryRun=false,
		//strict=false
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
