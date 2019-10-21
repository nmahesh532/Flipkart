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

public class SliderDemo {
	
	WebDriver d;
	@Test
	public void testSlider() throws Exception
	{
		// Load web page
		d.get("https://jqueryui.com/slider/");
		// Verify page title
		assertEquals("Slider | jQuery UI",d.getTitle());
		// Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		Thread.sleep(1000);
		//a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 200,0).perform();
		a.clickAndHold(d.findElement(By.xpath("//div[@id='slider']/span"))).moveByOffset(200,0).release().build().perform();
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
