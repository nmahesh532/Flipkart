package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameDemo {
	
	WebDriver d;
	@Test
	public void testFrame() throws Exception
	{
		// Load web page
		d.get("https://jqueryui.com/autocomplete/");
		// Verify page title
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		// Switch driver focus to frame
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		// Type text
		d.findElement(By.id("tags")).sendKeys("selenium");
		Thread.sleep(3000);
		// Switch driver focus outside frame
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Button")).click();
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
