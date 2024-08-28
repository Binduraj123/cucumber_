package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {".//features/Registration.feature", ".//features/login.feature"},
	    //features=".//features/login.feature",// Adjust this to the correct path of your features
	    		//features={"@target/rerun.txt"},
	    glue = { "StepDefinition","Hooks"} ,// Ensure this points to all necessary packages, including where Hooks and step definitions are located
	plugin= {"pretty", "html:reports/myreport.html", 
		  "rerun:target/rerun.txt",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Testrun {

}
