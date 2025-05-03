package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	public WebDriver driver;
    public Logger logger;
    public Properties p;
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass//(groups= {"Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	  {
		 //Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		  logger=LogManager.getLogger(this.getClass());
		
		  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		  {
			  DesiredCapabilities capabilities=new DesiredCapabilities();
			  //os
			  if(os.equalsIgnoreCase("windows"))
			  {
				  capabilities.setPlatform(Platform.WIN11);
			  }
			  else if(os.equalsIgnoreCase("linux"))
			  {
				  capabilities.setPlatform(Platform.LINUX);
			  }
			  else
			  {
				  System.out.println("no matching os");
				  return;
			  }
			  //br
			  switch(br.toLowerCase())
			  {
			  case "chrome" : capabilities.setBrowserName("chrome"); break;
			  case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			  case "firefox" : capabilities.setBrowserName("firefox"); break;
			  default : System.out.println("no matching os"); return;
			  }	  
		  
		    driver=new RemoteWebDriver(new  URL("http://localhost:4444/wd/hub"),capabilities);
		  }
		  
		  if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		  {
			  switch(br.toLowerCase())
			  {
			  case "chrome" :driver = new ChromeDriver(); break;
			  case "edge": driver = new EdgeDriver(); break;
			  case "firefox": driver = new FirefoxDriver(); break;
			  default : System.out.println("Invalid browser name..."); return;
			  } 
		  }
		   
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(p.getProperty("appURL"));
				
	  }
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
		public String randomString()
		{
			String generatedstring= RandomStringUtils.randomAlphabetic(5);
		    return generatedstring;
		}
		public String randomNumber()
		{
			String generatednumber= RandomStringUtils.randomNumeric(10);
		    return generatednumber;
		}
		public String randomAlphaNumeric()
		{
			String generatedalphanumberic= RandomStringUtils.randomAlphanumeric(6);
		    return generatedalphanumberic;
		}

}
