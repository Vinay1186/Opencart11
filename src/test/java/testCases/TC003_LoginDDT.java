package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
   public void verify_loginDDT(String email, String pwd, String exp)
   {
		try
		{
	   HomePage hp=new HomePage(driver);
   	hp.clickMyAcct();
   	hp.clickLogin();
   	
   	LoginPage lp=new LoginPage(driver);
		lp.emailId(email);
		lp.password(pwd);
	    lp.clickLogin();
	    
	    MyAccountPage macc=new MyAccountPage(driver);
	    boolean targetpage=   macc.MyAccountPageExists();
	     
	    if(exp.equalsIgnoreCase("valid"))
	    {
	    	if(targetpage==true)
	    	{
	    		macc.clickLogout();
	    		Assert.assertTrue(true);
	    		
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    if(exp.equalsIgnoreCase("invalid"))
	    {
	    	if(targetpage==true)
	    	{
	    		macc.clickLogout();
	    		Assert.assertTrue(false);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(true);
	    	}
	    }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	    
   }
	
	
	
}
