package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingElements {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		// Id
		// d.findElement(By.id("email")).sendKeys("selenium");
		// Name
		// d.findElement(By.name("email")).sendKeys("Appium");
		// Class name
		// d.findElement(By.className("inputtext")).sendKeys("QTP");
		// Link Text
		// d.findElement(By.linkText("Forgotten account?")).click();
		// Partial Link Text
		// d.findElement(By.partialLinkText("account")).click();
		// Xpath
		// d.findElement(By.xpath("//input[@id='email']")).sendKeys("Cucumber");
		// TagName
		// System.out.println("No of Links:"+d.findElements(By.tagName("a")).size());
		// CSS
		d.findElement(By.cssSelector("#email")).sendKeys("selenium");
		// Pause 3sec
        Thread.sleep(3000);
        // Close the browser
        d.quit();
	}

}
