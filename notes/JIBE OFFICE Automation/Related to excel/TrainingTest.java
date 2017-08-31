package jibe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrainingTest {
	
	training t=new training();
	
	Login  l=new Login();
	
	
  @Test
  public void trainingmenu() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Users/Ankita/workspace/chromedriver.exe");
	  
		WebDriver driver = new ChromeDriver();
		
		l.Log(driver);
		
		Thread.sleep(1000);
		
		
		try
		{
			
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		t.training1(driver);
		
		String exp="Training/Drill List";
		
		String act=driver.getTitle().trim();
		
		Assert.assertEquals(act, exp);
		
		}
		catch(Exception e)
		{
			System.out.println("Error in training:");
			e.printStackTrace();
		}
		
		try 
		{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			t.ItemList(driver);
			
			String exp="Item List";
			
			String act=driver.getTitle().trim();
			
			Assert.assertEquals(act, exp);
		}
		catch (Exception e)
		{
		System.out.println("Error in Item list");
		}
		
		driver.close();
	
  }
  

  
  
  
  
  
}
