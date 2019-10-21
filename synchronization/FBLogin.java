package abcpack;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {
	
	WebDriver d;
	@BeforeEach
	public void setup()
	{
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		d=new FirefoxDriver();
	}
	@Test
	public void testFBLogin() throws Exception
	{
		// Load web page
		d.get("https://www.facebook.com/");
		// Verify page title
		assertEquals("Facebook – log in or sign up",d.getTitle());
		// Radio button
		assertFalse(d.findElement(By.name("sex")).isSelected());
		// Print page title
		//System.out.println("Page title:"+d.getTitle());
		// Enter user name
		assertTrue(d.findElement(By.id("email")).isDisplayed());
		d.findElement(By.id("email")).sendKeys("selenium");
		System.out.println("User Name:"+d.findElement(By.id("email")).getAttribute("value"));
		// Enter password
		d.findElement(By.id("pass")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		// Pause 3sec
		Thread.sleep(3000);
	}
	@AfterEach
    public void tearDown()
    {
		// Close the browser
		d.quit();
    }




}
