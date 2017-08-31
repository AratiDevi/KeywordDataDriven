package testngkeyword;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import commonfunct.JibeLogin;
import commonfunct.RW;

public class JibeLoginTest extends RW{
	
public static WebDriver driver;

JibeLogin l= new JibeLogin();
	
	@BeforeSuite
	
	public void beforeSuite() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arati\\workspace\\Driver\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get(url);
		
	    driver.manage().window().maximize();
		
	    l.Log(driver);
		
	 
		
		Thread.sleep(100);
		
		
	  
  }
	
	
  
@AfterSuite
  
  public void afterSuite()
  {
	  driver.quit();
  } 
  
  
}
