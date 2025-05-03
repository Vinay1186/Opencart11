package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{ 
    @Test//(groups= {"Master"})
	public void verify_login()
	{
    	logger.info("*****Strating TC002_LoginTest*****");
    
    	try
    	{
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAcct();
    	hp.clickLogin();
    	
    	LoginPage lp=new LoginPage(driver);
		lp.emailId(p.getProperty("email"));
		lp.password(p.getProperty("password1"));
	    lp.clickLogin();
	    
	    MyAccountPage macc=new MyAccountPage(driver);
	    boolean targetpage=   macc.MyAccountPageExists();
	    //Assert.assertEquals(targetpage, true, "Login Failed");
	    Assert.assertTrue(targetpage);
    	}
    	catch(Exception e)
    	{
    		//Assert.fail();
    	}
	    logger.info("********FinishedTC002_LoginTest*****");
	    
	}
	
}
