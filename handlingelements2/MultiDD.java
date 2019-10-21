package abcpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDD {

	public static void main(String[] args) throws Exception {
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		// Load web page
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		// Switch driver focus to frame
		d.switchTo().frame("iframeResult");
		// Multi DD
		Select dd=new Select(d.findElement(By.name("cars")));
		
		for(int i=0;i<dd.getOptions().size();i++)
		{
			//dd.selectByIndex(i);
			if(dd.getOptions().get(i).getText().equals("Audi"))
			{
				dd.selectByIndex(i);
				break;
			}
		}
		Thread.sleep(2000);
		dd.deselectAll();
		Thread.sleep(2000);
		// Close the browser
		d.quit();

	}

}
