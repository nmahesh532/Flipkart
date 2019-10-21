package stepdef;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
//import io.cucumber.
//import io.cucumber.junit.CucumberOptions;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Feature Files"},
		glue={"stepdef"},
		//plugin = {"html:Reports" }
		//dryRun = true,
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Reports/cucumber-reports/report.html"},
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Reports/cucumber-reports/report.html"}
		tags= {"@Sanity"}

		)
 
public class TestRunner 
{
	
 
}
