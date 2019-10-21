package abcpack;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginResults {
	
	WebDriver d;
	String path="E:\\Selenium_Scripts_Aug19\\Test Data\\Login.xlsx";
	XSSFWorkbook wb;
	XSSFSheet s;
	XSSFRow r;
	XSSFCell cell;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/#home");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		// Read test data from excel
		FileInputStream fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		s=wb.getSheetAt(0);
		for(int i=1;i<s.getLastRowNum()+1;i++)
		{
			// Click on Sign in
			d.findElement(By.linkText("Sign in")).click();
			Thread.sleep(1000);
			// Enter user name
			d.findElement(By.name("principal")).clear();
			d.findElement(By.name("principal")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.name("principal")).getAttribute("value");
			// Enter password
			d.findElement(By.name("password")).clear();
			d.findElement(By.name("password")).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			String password=d.findElement(By.name("password")).getAttribute("value");
			// Click on Sign in button
			d.findElement(By.className("actionButtonText")).click();
			Thread.sleep(2000);
			
			// Blank user name and blank password
			if(uname.equals("") && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".notificationText > ul")).getText().contains("Login name is required\nPassword is required"));
				setCellData(i,2,"Fail",path);
			}
			// Blank user name and valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				assertTrue(d.findElement(By.cssSelector(".notificationText > ul")).getText().contains("Login name is required"));
				setCellData(i,2,"Fail",path);
			}
			// Blank password and valid/invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".notificationText > ul")).getText().contains("Password is required"));
				setCellData(i,2,"Fail",path);
			}
			// Valid user name and valid password
			else if(isElementPresent(d,By.linkText("Logout")))
			{
				d.findElement(By.linkText("Logout")).click();
				setCellData(i,2,"Pass",path);
			}
			// invalid user name and invalid password
			else
			{
				assertTrue(d.findElement(By.cssSelector(".notificationText")).getText().contains("The given name / password are incorrect."));
				setCellData(i,2,"Fail",path);
			}
			Thread.sleep(1000);
		}
		


		Thread.sleep(2000);
	}
	
	public void setCellData(int rowindex,int colindex, String result,String path) throws Exception
	{
		cell=s.getRow(rowindex).getCell(colindex);
		if(cell==null)
		{
			cell=r.createCell(colindex);
			cell.setCellValue(result);
		}
		else
		{
			cell.setCellValue(result);
		}
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	
	public boolean isElementPresent(WebDriver driver, By b)
	{
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		try
		{
			driver.findElement(b);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			    
	}
	@BeforeMethod
	public void setup()
	{
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\Driver Executables\\chromedriver.exe");
		//d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
	}
	@AfterMethod
    public void tearDown()
    {
		// Close the browser
		d.quit();
    }

}
