package TestNGClass;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;
public class ReporterLogs {
  
	private static WebDriver driver;
  
	private static Logger Log = Logger.getLogger(Log.class.getName());

  @Test

	public static void test() {

		DOMConfigurator.configure("log4j.xml");

      driver = new ChromeDriver();

      Log.info("New driver instantiated");

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      Log.info("Implicit wait applied on the driver for 10 seconds");

      driver.get("http://114.79.141.160/JIBE/Account/Login.aspx?");

      Log.info("Web application launched");

      // Our first step is complete, so we produce a main event log here for our reports.

      Reporter.log("Application Lauched successfully | ");

    

      driver.findElement(By.id("ctl00_MainContent_LoginUser_UserName")).sendKeys("pooja");

      Log.info("Username entered in the Username text box");

      driver.findElement(By.id("ctl00_MainContent_LoginUser_Password")).sendKeys("jibe@1234");

      Log.info("Password entered in the Password text box");

      driver.findElement(By.id("ctl00_MainContent_LoginUser_LoginButton")).click();

      Log.info("Click action performed on Submit button");

      // Here we are done with our Second main event

      Reporter.log(" File Management System  " );

      driver.findElement(By.id("ctl00_HeadLoginView_HeadLoginStatus"));

      Log.info("Click action performed on Log out link");

      driver.quit();

      Log.info("Browser closed");

      // This is the third main event

      Reporter.log("User is Logged out and Application is closed | ");

	}
}

