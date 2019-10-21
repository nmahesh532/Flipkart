package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CHKDemo {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		// Load web page
		d.get("http://book.theautomatedtester.co.uk/chapter1");
		Thread.sleep(1000);
		// Check box
		WebElement chk=d.findElement(By.name("selected(1234)"));
		if(chk.isSelected())
		{
			System.out.println("Check box is already selected");
		}
		else
		{
			chk.click();
		}
		Thread.sleep(2000);
		// Close the browser
		d.quit();

	}

}
