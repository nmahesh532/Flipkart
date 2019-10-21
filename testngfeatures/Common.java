package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
	
	WebDriver d;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		// Launch the browser
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

		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
	}
	@AfterMethod
    public void tearDown()
    {
		// Close the browser
		d.quit();
    }

}
