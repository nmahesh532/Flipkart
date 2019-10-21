package abcpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR {
	
	OR(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	@FindBy(linkText="Sign in") public WebElement lnkSignin;
	@FindBy(name="principal") public WebElement tfieldUsername;
	@FindBy(name="password") public WebElement tfieldPassword;
	@FindBy(className="actionButtonText") public WebElement btnSignin;
	@FindBy(linkText="Logout") public WebElement lnkLogout;
	
	public void fillLogin(String uname,String password)
	{
		lnkSignin.click();
		tfieldUsername.sendKeys(uname);
		tfieldPassword.sendKeys(password);
		btnSignin.click();
	}

}
