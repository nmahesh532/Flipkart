package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {

	public static void main(String[] args) throws Exception {
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		// Enter user name
		d.findElement(By.id("email")).sendKeys("selenium");
		// Enter password
		d.findElement(By.id("pass")).sendKeys("selenium");
		// Click on Login
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		// Pause 3sec
		Thread.sleep(3000);
		// Close the browser
		d.quit();

	}

}
