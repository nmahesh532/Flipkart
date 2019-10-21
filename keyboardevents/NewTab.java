package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTab {
	
	WebDriver d;
	@Test
	public void testNewTab() throws Exception
	{
		// Load web page
		d.get("https://www.google.com/");
		// Verify page title
		assertEquals("Google",d.getTitle());
		WebElement link1=d.findElement(By.linkText("Gmail"));
		
		Actions a=new Actions(d);
		a.moveToElement(link1).keyDown(Keys.CONTROL).click(link1).build().perform();
		Thread.sleep(2000);
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		// Switch focus Google ---> GMail
		d.switchTo().window(al.get(1));
		Thread.sleep(2000);
		// Switch focus GMail ---> Google
		d.switchTo().window(al.get(0));
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void setup()
	{
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		//d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		d=new ChromeDriver();
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
