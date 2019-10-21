package stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Common {
	
	static String url="https://demo.cyclos.org/#home";
	static String browser="FF";
	static WebDriver d;
	
	public static void launchBrowser()
	{
		if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
			d=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Driver Executables\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
	}
	
	public static void closeBrowser()
	{
		d.quit();
	}


}
