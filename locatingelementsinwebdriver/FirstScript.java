package abcpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstScript {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		//WebDriver d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		//WebDriver d=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "E:\\Driver Executables\\IEDriverServer.exe");
		WebDriver d=new InternetExplorerDriver();
		d.get("https://www.facebook.com/");
		// Pause 4sec
		Thread.sleep(4000);
		// Close browser
		d.quit();

	}

}
