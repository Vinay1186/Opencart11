package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@placeholder='E-Mail Address']") WebElement txt_email;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_password;
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement btn_login;
	
	
	
	public void emailId(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void password(String password)
	{
		txt_password.sendKeys(password);
	}
	public void clickLogin()
	{
		btn_login.click();
	}
	
	
}
