package abcpack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiWindow {
	
	WebDriver d;
	@Test
	public void testMultiWindow() throws Exception
	{
		// Load web page
		d.get("https://www.onlinesbi.com/");
		// Verify page title
		//assertEquals("State Bank of India - Personal Banking",d.getTitle());
		// Click on Yono
		d.findElement(By.xpath("//img[@alt='Yono Login']")).click();
		Thread.sleep(3000);
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		/*Set<String> h=d.getWindowHandles();
		System.out.println("No of handles:"+h.size());
		for(String s:h)
		{
			System.out.println(s);
		}*/
		// Switch driver focus from SBI to Yono
		d.switchTo().window(al.get(1));
		assertTrue(d.findElement(By.xpath("//div[@class='marT70 pad-r-0']//span[contains(text(),'LOGIN')]")).isDisplayed());
		Thread.sleep(1000);
		// Switch driver focus From Yono to SBI page
		d.switchTo().window(al.get(0));
		assertTrue(d.findElement(By.xpath("//img[@alt='Yono Login']")).isDisplayed());
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
