package abcpack;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryDemo {
	
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/#home");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		
		OR page=new OR(d);
		
		page.fillLogin("demo", "1234");
		
		// Click on signin link
		/*page.lnkSignin.click();
		// Enter user name
		page.tfieldUsername.sendKeys("demo");
		// Enter password
		page.tfieldPassword.sendKeys("1234");
		// Click on sign in button
		page.btnSignin.click();*/
		Thread.sleep(2000);
		// Click on Logout
		page.lnkLogout.click();
		Thread.sleep(2000);
		
	}
	@BeforeMethod
	public void setup()
	{
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
	}
	@AfterMethod
    public void tearDown()
    {
		// Close the browser
		d.quit();
    }

}
