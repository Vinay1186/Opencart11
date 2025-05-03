package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

public class HomePage extends BasePage 
{ 
	
	 public HomePage(WebDriver driver)
	{
		 super(driver);
		
	}
	
	
	@FindBy(xpath="//span[text()='My Account']") WebElement my_acct;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement linkregst;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;
	
	
	public void clickMyAcct()
	{
		my_acct.click();
	}
	
	public void ClickRegister()
	{
		linkregst.click();
	}
	
	
	public void clickLogin()
	{
		login.click();
	}
	
	
	
	
}
