package abcpack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxDemo {
	
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		// Load web page
		d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
		// Verify page title
		assertEquals("Bank IFSC Codes: Find IFSC for Major Banks in India",d.getTitle());
	 
		selectOption(d.findElement(By.id("selBank")),"Axis Bank");
		selectOption(d.findElement(By.id("selState")),"Andhra Pradesh");
		selectOption(d.findElement(By.id("selCity")),"Hyderabad");
		selectOption(d.findElement(By.id("selBranch")),"Gachibowli");
		
		/*	// Select bank
		Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByVisibleText("Axis Bank");
		
		// ExplicitWait
		WebDriverWait wait=new WebDriverWait(d,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Andhra Pradesh']")));
		
		// Select state
		Select state=new Select(d.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		// Select city
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		// Select branch
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Gachibowli");*/
		Thread.sleep(3000);
				
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
