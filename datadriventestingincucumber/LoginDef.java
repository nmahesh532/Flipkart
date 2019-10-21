package stepdef;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;

public class LoginDef extends Common
{
	
	OR page;
	@Given("If user is on home page")
	public void if_user_is_on_home_page() {
		// Launch the browser
		//launchBrowser();
		// Load web page
		d.get(url);
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
		page=new OR(d);
	}

	@When("Click on Signin link")
	public void click_on_Signin_link() throws Exception {
		// Click on Sign in
		//d.findElement(By.linkText("Sign in")).click();
		page.lnkSignin.click();
		Thread.sleep(1000);
	}
	
	@When("^Enter user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_user_name_as_and_password_as(String username, String password) throws Throwable {
		/*// Enter user name
		d.findElement(By.name("principal")).clear();
		d.findElement(By.name("principal")).sendKeys(username);
		// Enter password
		d.findElement(By.name("password")).clear();
		d.findElement(By.name("password")).sendKeys(password);
		// Click on Sign in button
		d.findElement(By.className("actionButtonText")).click();*/
		
		page.fillLogin(username, password);
		Thread.sleep(2000);
	}

	@When("Enter user name and password")
	public void enter_user_name_and_password() {
		// Enter user name
		d.findElement(By.name("principal")).clear();
		d.findElement(By.name("principal")).sendKeys("demo");
		// Enter password
		d.findElement(By.name("password")).clear();
		d.findElement(By.name("password")).sendKeys("1234");
		// Click on Sign in button
		d.findElement(By.className("actionButtonText")).click();
	}

	@Then("Verify logout link")
	public void verify_logout_link() {
		//assertTrue(d.findElement(By.linkText("Logout")).isDisplayed());
		assertTrue(page.lnkLogout.isDisplayed());
		//d.findElement(By.linkText("Logout")).click();
		page.lnkLogout.click();
	}

	@Then("Close the browser")
	public void close_the_browser() throws Exception {
	    Thread.sleep(2000);
	    //d.quit();
	    //closeBrowser();
	}
	@When("^Click Account Info link$")
	public void click_Account_Info_link() throws Throwable {
	    d.findElement(By.linkText("Account info")).click();
	    Thread.sleep(2000);
	}

	@Then("^Verify Account Info page$")
	public void verify_Account_Info_page() throws Throwable {
	    assertTrue(d.findElement(By.className("actionButtonText")).isDisplayed());
	}


}
