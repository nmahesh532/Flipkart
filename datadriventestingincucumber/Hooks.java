package stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void beforeScenario()
	{
		System.out.println("******** Before Scenario ********");
		Common.launchBrowser();
	}
	@After
	public void afterScenario()
	{
		System.out.println("******** After Scenario ***********");
		Common.closeBrowser();
	}
	@Before("@DB")
	public void beforeScenario1()
	{
		System.out.println("******** Connect data base ********");
	}
	@After("@DB")
	public void afterScenario1()
	{
		System.out.println("******** Close data base connection ***********");
	}

}
