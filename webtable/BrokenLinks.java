package abcpack;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	WebDriver d;
	ArrayList<URL> al;
	@Test
	public void testLinks() throws Exception
	{
		// Load web page
		d.get("https://www.seleniumhq.org/");
		// Verify page title
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]/a"));
		System.out.println("No of links:"+l.size());
		for(WebElement e:l)
		{
			try
			{
				//System.out.println(e.getAttribute("href"));
				al=new ArrayList<URL>();
				if(e.getAttribute("href")!=null)
				{
					URL u=new URL(e.getAttribute("href"));
					HttpURLConnection con=(HttpURLConnection)u.openConnection();
					con.setConnectTimeout(60000);
					con.connect();
					if(con.getResponseCode()==200)
					{
						//System.out.println("Link:"+u+"---> is working fine");
					}
					else
					{
						//System.out.println("Link:"+u+"---> is not working");
						
						al.add(u);
					}
				}
			}
			catch(Exception ie)
			{
				System.out.println(ie);
			}
			
		}
		System.out.println("Broken links:"+al.size());
		System.out.println("****** Broken links are *******");
		for(URL u:al)
		{
			System.out.println(u);
		}
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		System.setProperty("webdriver.gecko.driver", "E:\\Driver Executables\\geckodriver.exe");
		//d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","E:\\Driver Executables\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(3,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
