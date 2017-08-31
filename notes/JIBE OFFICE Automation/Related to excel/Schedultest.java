package TestNGClass;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestClass.Schedule;

public class Schedultest extends WebDriverPass {

	Schedule schedule2 = new Schedule();

	@Test(priority = 0)
	public void fms() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.Schedule1(driver);
		
		  String ExpectedTitle=data.getData(3,2,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);
	}

	@Test(priority = 1)
      public void fmsmain1() throws Exception {
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      Thread.sleep(1000);
	  schedule2.Fmsmain(driver);
	  String ExpectedTitle=data.getData(3,5,3).trim(); // It will taking the Expected Title name from the excel sheet.
		
	  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
		
	  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
		
		Assert.assertEquals(ExpectedTitle, ActuleTitle);
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
		  
		  Thread.sleep(100);
	}

	@Test(priority = 2)
	public void switchiframe() throws Exception {
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       Thread.sleep(1000);
		schedule2.iframe(driver);
		 String ExpectedTitle=data.getData(3,8,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);

	}
	@Test(priority = 3)
	public void onetimefrequency() throws Exception {
     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      Thread.sleep(1000);
      

	}
	@Test(priority = 4)
	public void weeklyfrequency() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.weeklyfrequency1(driver);

	}
	@Test(priority = 5)
	public void monthlyfrequency() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         Thread.sleep(1000);
		schedule2.monthlyfrequency1(driver);

	}
	@Test(priority = 6)
	public void repeatintervalfrequency() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		Thread.sleep(1000);
		 schedule2.repeatintervalfrequency1(driver);

	}
	@Test(priority = 7)
	public void defaultcontent() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         Thread.sleep(1000);
		schedule2.defaultContent(driver);

	}

	@Test(priority = 8)
	public void approvalconfiguration() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.approvalconfiguration(driver);
		 String ExpectedTitle=data.getData(3,52,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);

	}

	@Test(priority = 9)
	public void L1() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		schedule2.L1(driver);
		 String ExpectedTitle=data.getData(3,54,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);
	}

	@Test(priority = 10)
	public void isAlertPresent() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.isAlertPresent(driver);
	}

	@Test(priority = 11)
	public void L2() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.L2(driver);
		 String ExpectedTitle=data.getData(3,60,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);

	}

	@Test(priority = 12)
	public void L3() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.L3(driver);
		 String ExpectedTitle=data.getData(3,62,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);

	}
	@Test(priority = 13)
	public void checkfilestatus() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		schedule2.checkfilestatus(driver);

	}


	@Test(priority = 13)
	public void saveassignment() throws Exception {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		schedule2.saveassignment(driver);
		 String ExpectedTitle=data.getData(3,76,3).trim(); // It will taking the Expected Title name from the excel sheet.
			
		  String ActuleTitle=driver.getTitle().trim();		// taking the actual title name by the web site.
			
		  schedule2.SShot(ExpectedTitle, ActuleTitle, driver); // if Title is not matching they it will take screen shot n store in folder
			
			//
			
			Assert.assertEquals(ExpectedTitle, ActuleTitle);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Thread.sleep(100); 
			  
			  Thread.sleep(100);

	}
	
}
