package stepdef;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

public class LoginDef {
	
	WebDriver d;
	@Given("If user is on home page")
	public void if_user_is_on_home_page() {
		// Launch the browser
		System.setProperty("webdriver.gecko.driver","E:\\Driver Executables\\geckodriver.exe");
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
		// Load web page
		d.get("https://demo.cyclos.org/#home");
		// Verify page title
		assertTrue(d.getTitle().contains("Cyclos4 Communities"));
	}

	@When("Click on Signin link")
	public void click_on_Signin_link() throws Exception {
		// Click on Sign in
		d.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);
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
		assertTrue(d.findElement(By.linkText("Logout")).isDisplayed());
		d.findElement(By.linkText("Logout")).click();
	}

	@Then("Close the browser")
	public void close_the_browser() throws Exception {
	    Thread.sleep(2000);
	    d.quit();
	}


}
