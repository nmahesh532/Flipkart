package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoComplete {
	
	WebDriver d;
	@Test
	public void testAutocomplete() throws Exception
	{
		// Load web page
		d.get("https://jqueryui.com/autocomplete/");
		// Verify page title
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		// Switch driver focus to frame
		d.switchTo().frame(0);
		// Type text
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions:"+s.size());
		for(WebElement e:s)
		{
			//System.out.println(e.getText());
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			if(e.getText().equals("Asp"))
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(1000);
		}
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
