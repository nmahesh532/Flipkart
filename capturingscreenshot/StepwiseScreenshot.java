package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepwiseScreenshot {
	
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		// Load web page
		d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
		// Verify page title
		assertEquals("Bank IFSC Codes: Find IFSC for Major Banks in India",d.getTitle());
		Thread.sleep(1000);
		getScreenshot();
		selectOption(d.findElement(By.id("selBank")),"Axis Bank");
		Thread.sleep(1000);
		getScreenshot();
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
		Thread.sleep(1000);
		getScreenshot();
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		Thread.sleep(1000);
		getScreenshot();
		selectOption(d.findElement(By.id("selBranch")),"Gachibowli");
		Thread.sleep(3000);
		getScreenshot();
				
	}
	
	public void getScreenshot() throws Exception
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Aug19\\Screenshots\\"+df.format(dt)+".png"));
	}
	
	public void selectOption(WebElement ddlocator,String optionname)
	{
		Select dd=new Select(ddlocator);
		dd.selectByVisibleText(optionname);
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
