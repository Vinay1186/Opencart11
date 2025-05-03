package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
    
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement txtFirstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement txtLastname;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']") WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Telephone']") WebElement txtTelephone;
	
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txtPassword;
	
	@FindBy(xpath="//input[@placeholder='Password Confirm']") WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']") WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']") WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	public void firstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void email(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void telephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void password(String pswrd)
	{
		txtPassword.sendKeys(pswrd);
	}
	
	public void confrmPswrd(String pswrd)
	{
		txtConfirmPassword.sendKeys(pswrd);
	}
	
	
	public void checkBox()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	
	public String getMsgConfirmation()
	{
		try {
			return(msgConfirmation.getText());
		} 
		catch(Exception e)
		{
			return(e.getMessage());
		}
		
		
		
		
		
	}
	
	
	
}
