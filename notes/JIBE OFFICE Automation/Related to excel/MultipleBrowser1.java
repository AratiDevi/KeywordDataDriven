package TestNGClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestClass.MultipleBrowser;

public class MultipleBrowser1  {
	public static final WebDriver driver1 = null;
	MultipleBrowser  test = new MultipleBrowser();
	WebDriver driver = driver1;

	  @BeforeTest
	  @Parameters("browser")
	  // Passing Browser parameter from TestNG xml

	  public void logintest( String browser) throws Exception {
		  
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			Thread.sleep(1000);
	
	  

	  // If the browser is Firefox, then do this

	  if(browser.equalsIgnoreCase("firefox")) {

		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
	  // If browser is IE, then do this	  

	  }else if (browser.equalsIgnoreCase("crome")) { 

		  // Here I am setting up the path for my crome Driver

		  System.setProperty("webdriver.chrome.driver", "C:/Users/Pooja/jibetest/FmsTest/chromedriver.exe");

		  driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(1000);
}
	  }

@Test 

public void login1() throws Exception {


	test.login(driver);
}

@AfterTest public void afterTest() {

	driver.quit();

}

}