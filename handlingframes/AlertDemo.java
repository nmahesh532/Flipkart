package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertDemo {
	
	WebDriver d;
	@Test
	public void testAlert() throws Exception
	{
		// Load web page
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		// Verify page title
		assertEquals("State Bank of India - Personal Banking",d.getTitle());
		// Click on CONTINUE TO LOGIN
		d.findElement(By.xpath("//a[text()='CONTINUE TO LOGIN']")).click();
		// Click on Login
		d.findElement(By.id("Button2")).click();
		// Switch driver focus to alert
		Alert al=d.switchTo().alert();
		// Verify alert text
		assertEquals("Enter username",al.getText());
		// ok
		al.accept();
		// Enter user name
		d.findElement(By.id("username")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.id("Button2")).click();
		// ok
		al.accept();
		// Enter password
		d.findElement(By.id("label2")).sendKeys("selenium");
		Thread.sleep(3000);
		
	}
	@BeforeEach
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
	@AfterEach
    public void tearDown()
    {
		// Close the browser
		d.quit();
    }


}
