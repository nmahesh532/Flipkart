package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo {
	
	WebDriver d;
	@Test
	public void testMouseOver() throws Exception
	{
		// Load web page
		d.get("https://www.aptransport.in/tgcfstonline/");
		// Verify page title
		assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA",d.getTitle());
		// Mouse Over
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.linkText("DEALER"))).perform();
		Thread.sleep(2000);
		// Click on Query Response
		d.findElement(By.linkText("Query Response")).click();
		Thread.sleep(3000);
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
