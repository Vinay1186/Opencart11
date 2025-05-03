package testCases;
  
import org.testng.Assert; 
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	 
	
	@Test//(groups= {"Master"})
	public void verify_account_registration()  
	{
		logger.info("*****TC001_AccountRegistrationTest*****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAcct();
		logger.info("Clicked on MyAccount Link");
		hp.ClickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpg=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regpg.firstName(randomString().toUpperCase());
		regpg.lastName(randomString().toUpperCase());
		regpg.email((randomString())+"@gmail.com");
		regpg.telephone(randomNumber());
		String password= randomAlphaNumeric();
	    regpg.password(password);
	    regpg.confrmPswrd(password);
	    regpg.checkBox(); 
	    regpg.clickContinue();
	    
	    logger.info("validating expected message");
	   String confirmationmsg= regpg.getMsgConfirmation();
	
	   Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("*****Finished TC001_AccountRegistrationTest*****");
	}

	
}
