package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IframeDemo {
	
	WebDriver d;
	@Test
	public void testIframe() throws Exception
	{
		// Load web page
		d.get("https://paytm.com/electricity-bill-payment");
		// Verify page title
		//assertEquals("State Bank of India",d.getTitle());
		d.findElement(By.xpath("//li[text()='Log In/Sign Up']")).click();
		Thread.sleep(6000);
		// Switch driver focus to iframe
		d.switchTo().frame(0);
		d.findElement(By.cssSelector(".qrcode-footer-text > span")).click();
		Thread.sleep(4000);
	}
	@BeforeEach
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver","E:\\Driver Executables\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		d=new ChromeDriver(options);
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Executables\\geckodriver.exe");
		//d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterEach
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}


}
