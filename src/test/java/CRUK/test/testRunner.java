package CRUK.test;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features/",
		glue = "steps",
		tags = "@donate",
		publish = true,
		plugin  = {"pretty",
				"html:target/cucumber-pretty",
				"json:target/cucumber.json"})
public class testRunner extends AbstractTestNGCucumberTests {

}