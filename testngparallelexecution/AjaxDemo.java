package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxDemo extends Common
{

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

		Thread.sleep(3000);
				
	}
	
	public void selectOption(WebElement ddlocator,String optionname)
	{
		Select dd=new Select(ddlocator);
		dd.selectByVisibleText(optionname);
	}


}
