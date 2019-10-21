package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DDDemo {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		// Load web page
		d.get("https://www.facebook.com/");
		// DD
		Select dd=new Select(d.findElement(By.id("month")));
		System.out.println("Before Selection:"+dd.getFirstSelectedOption().getText());
		dd.selectByIndex(2);
		Thread.sleep(1000);
		dd.selectByValue("4");
		Thread.sleep(1000);
		dd.selectByVisibleText("Jun");
		Thread.sleep(1000);
		System.out.println("After Selection:"+dd.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		// Close the browser
		d.quit();

	}

}
