package TestClass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



import CommanFunction.RW;

public class Schedule extends RW {
	
	public long LoagingStart;  // for page loading time

	public String Schedule1(WebDriver driver1) throws Exception {
		
		WebDriver driver = driver1;
//(1)	
		WebElement quality = driver.findElement(By.linkText(data.getData(3, 2, 3)));  // quality main menu
																					 
		Actions action = new Actions(driver);
		action.moveToElement(quality).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
//(2)		
		WebElement fms1 = driver.findElement(By.xpath(data.getData(3, 4, 3)));// FMS
																				// main
																				// menu
		action.moveToElement(fms1).build().perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		

		String title = driver.getTitle().trim();
		return title;

	}

	@SuppressWarnings("unused")
	public String Fmsmain(WebDriver driver1) throws Exception {

		WebDriver driver = driver1;
//(3)
		driver.findElement(By.linkText(data.getData(3, 5, 3))).click();// FMS sub menu fms main
		write_data.writedata(3, 5, 8, "Pass");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
//CALCULATE PAGE LOAD TIME FOR ALL OPERATION ---------------------------------------------------------------------------
		long LoagingStart = System.currentTimeMillis(); 
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));
		long Loadingstop = System.currentTimeMillis(); 
		double TotalTime = (Loadingstop - LoagingStart);
		String Result = Double.toString(TotalTime);
        System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");
        write_data.writedata(3, 5, 9, Result);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//----------------------------------------------------------------------------------------------------------------------        
        
       
//(4)
		driver.findElement(By.id(data.getData(3, 36, 3))).click();// select FOLDER POOJA SINGH1 FROM THE DOCUMENT TREE 
	    write_data.writedata(3, 36, 8, "Pass");
     	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
// (5)file name FOR DIFFERENT OPERATION 
		//driver.findElement(By.id(data.getData(3, 37, 3))).click();// click in file name 
		//driver.findElement(By.id("767")).click();
		//driver.findElement(By.id("766")).click();
		driver.findElement(By.id("769")).click();
		write_data.writedata(3, 37, 8, "Pass");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
//CALCULATE THE PAGE LOAD TIME WHEN ENTER IN I-FRAME ---------------------------------------------------------------
		List<WebElement> allLinks1 = driver.findElements(By.xpath("//*"));
    	long Loadingstop1 = System.currentTimeMillis();
        double TotalTime1 = (Loadingstop1 - LoagingStart);
        String Result1 = Double.toString(TotalTime1);
        write_data.writedata(3, 38, 9, Result1);
        String title = driver.getTitle().trim(); 
        return title;
	}
//6)SWITCH TO DEFAULT CONTENT TO I-FRAME--------------------------------------------------------------------------
	@SuppressWarnings("unused")
	public String iframe(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		
   WebElement iframe = driver.findElement(By.id(data.getData(3, 38, 3)));// SWITCH to I-frame
		driver.switchTo().frame(iframe);
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//(6)CALCULATE HOWMANY FRAME ARE AVALIABLE IN I-FRAME --------------------------------------------------
		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
//(7)
		driver.findElement(By.id(data.getData(3, 39, 3))).click(); // click in schedule icon button
              driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
               Thread.sleep(1000);
//(8)when click in schedule new window open give id and frame id of new window -----------------------------------------
		driver.findElement(By.id("dvScheduleInsp")); // go to document scheduling page by id
		WebElement iframe1 = driver.findElement(By.id("IframeScheduleInsp"));// SWITCH to I-frame
		driver.switchTo().frame(iframe1);
//(9)calculate page load time for next window ------------------------------------------------------------
		List<WebElement> allLinks1 = driver.findElements(By.xpath("//*"));
		long Loadingstop1 = System.currentTimeMillis(); 
		double TotalTime1 = (Loadingstop1 - LoagingStart);
		String Result1 = Double.toString(TotalTime1);
		write_data.writedata(3, 45, 9, Result1);
//(10)Selected file  assign and schedule foe any one vessel------------------------------------------------------------------
		
		//driver.findElement(By.id(data.getData(3, 41, 3))).click();// select assign vessel
		driver.findElement(By.id("gvVesselSch_ctl06_chkVesselAssign")).click();	//select assign to imara vessel
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		//driver.findElement(By.id(data.getData(3, 42, 3))).click(); // select schedule
		driver.findElement(By.id("gvVesselSch_ctl06_chkVesselAssign")).click();	//click in schedule imara vessel														
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);

		//driver.findElement(By.id(data.getData(3, 43, 3))).click();// click in action
		driver.findElement(By.id("gvVesselSch_ctl06_imgEditSchedule")).click();	//click in imara action 													
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
        String title = driver.getTitle().trim(); 
        return title;
	}
//(11)SELECT ONE TIEM FREQUENCY	-----------------------------------------------------------------------
	public String onetimefrequency1(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;  

		driver.findElement(By.id(data.getData(3, 46, 3))).click();// select one time frequency
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.id("txtRemark")).clear();
		driver.findElement(By.id("txtRemark")).sendKeys("save schedule for this file");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 48, 3))).click();// click in save schedule button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
//(12)Click in save schedule button alert window open -----------------------------------------------------------------
		// Switching to Alert 
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);
		// Accepting alert
		// alert.accept();

		String alertMessage1 = "Schedular Details Saved.";
		if (alertMessage.equals(alertMessage1)) {
			write_data.writedata(3, 49, 8, "Schedular Details Saved.");
		} else {
			write_data.writedata(3, 49, 8, "fail");
		}

		Assert.assertEquals(alertMessage, alertMessage1);
		alert.accept();
		Thread.sleep(1000);

		String title = driver.getTitle();

		return title;
	}
		
//(14)SELECT WEEKLY FREQUENCY------------------------------------------------------------------------------------------
	public String weeklyfrequency1(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;  
		driver.findElement(By.id("rdoFrequency_0")).click();//select weekly radio button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("txtEndDate")).click();//select end date 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("calEndDate_day_4_1")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("txtWeek")).clear();
		driver.findElement(By.id("txtWeek")).sendKeys(" 2");//enter reoccur every week 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		// select day by clicking in radio button
		
		driver.findElement(By.id("chkWeekDays_1")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkWeekDays_3")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkWeekDays_2")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkWeekDays_4")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("txtRemark")).clear();
		driver.findElement(By.id("txtRemark")).sendKeys("save schedule for this file");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 48, 3))).click();// click in save schedule button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
//(15)Click in save schedule button alert window open ---------------------------------------------------------------------
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);
		// Accepting alert
		// alert.accept();

		String alertMessage1 = "Schedular Details Saved.";
		if (alertMessage.equals(alertMessage1)) {
			write_data.writedata(3, 49, 8, "Schedular Details Saved.");
		} else {
			write_data.writedata(3, 49, 8, "fail");
		}

		Assert.assertEquals(alertMessage, alertMessage1);
		alert.accept();
		Thread.sleep(1000);

		String title = driver.getTitle();

		return title;
	}

//(15)Select monthly frequency---------------------------------------------------------------------------------------
	public String monthlyfrequency1(WebDriver driver1) throws Exception {
	WebDriver driver = driver1;  
	
	//select monthly frequency for haruka 
		
		
		driver.findElement(By.id("rdoFrequency_1")).click();//select monthly radio button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.id("txtEndDate")).click();//select end date 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("calEndDate_day_4_1")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("chkEOM")).click();//un check end of month 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement a = driver.findElement(By.id("txtDueDay"));//click in end of month
		a.sendKeys("10");
		
		//select month 
		
		driver.findElement(By.id("chkMonthWise_0")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkMonthWise_4")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkMonthWise_2")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.id("chkMonthWise_6")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("txtRemark")).clear();
		driver.findElement(By.id("txtRemark")).sendKeys("save schedule for this file");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 48, 3))).click();// click in save schedule button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
//(16)Click in save schedule button alert window open 
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);
		// Accepting alert
		// alert.accept();

		String alertMessage1 = "Schedular Details Saved.";
		if (alertMessage.equals(alertMessage1)) {
			write_data.writedata(3, 49, 8, "Schedular Details Saved.");
		} else {
			write_data.writedata(3, 49, 8, "fail");
		}

		Assert.assertEquals(alertMessage, alertMessage1);
		alert.accept();
		Thread.sleep(1000);

		String title = driver.getTitle();

		return title;
	}
		
//(17)Select repeat interval frequency------------------------------------------------------------------------
	public String repeatintervalfrequency1(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;  
		
		//for Repeat interval frequency 
		
		driver.findElement(By.id("rdoFrequency_3")).click();//click in repeat interval frquency
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		driver.findElement(By.id("txtEndDate")).click();//select end date 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("calEndDate_day_4_0")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		Select dropdown = new Select(driver.findElement(By.id("ddlDuration")));//LEVEL 1
		dropdown.selectByVisibleText("25");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
	
		driver.findElement(By.id("txtRemark")).clear();
		driver.findElement(By.id("txtRemark")).sendKeys("save schedule for this file");
		//driver.findElement(By.id(data.getData(3, 47, 3))).sendKeys("save schedule for this file");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
        driver.findElement(By.id(data.getData(3, 48, 3))).click();// click in save schedule button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Thread.sleep(1000);
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);
		// Accepting alert
		// alert.accept();

		String alertMessage1 = "Schedular Details Saved.";
		if (alertMessage.equals(alertMessage1)) {
			write_data.writedata(3, 49, 8, "Schedular Details Saved.");
		} else {
			write_data.writedata(3, 49, 8, "fail");
		}

		Assert.assertEquals(alertMessage, alertMessage1);
		alert.accept();
		Thread.sleep(1000);

		String title = driver.getTitle();

		return title;
	}
//(18)assign schedule after that switch to default content---------------------------------------------
	public String defaultContent(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
		Thread.sleep(1000);
//calculate page load time --------------------------------------------------------
		long LoagingStart = System.currentTimeMillis(); 
       @SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));
        long Loadingstop = System.currentTimeMillis();
       double TotalTime = (Loadingstop - LoagingStart);
       String Result = Double.toString(TotalTime);
        System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");
        write_data.writedata(3, 52, 9, Result);
       driver.findElement(By.id(data.getData(3, 36, 3))).click();// select FOLDER NAME POOJA SINGH1
	    write_data.writedata(3, 36, 8, "Pass");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
//again select same folder from the document tree 
		//driver.findElement(By.id(data.getData(3, 37, 3))).click();// click in FILE NAME
		driver.findElement(By.id("769")).click();//file name
		write_data.writedata(3, 37, 8, "Pass");
        Thread.sleep(1000);
//(19)Switch to delault content to i-frame for checking file status 
		WebElement iframe = driver.findElement(By.id(data.getData(3, 38, 3)));// SWITCH TO I -FRAME
		driver.switchTo().frame(iframe);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
//(20)IN schedule page click in refresh and view button then we check status of file 
		driver.findElement(By.id("btnRefresh")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("gvVesselDocHistory_ctl02_ImgAttach")).click();//click in view button

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		String title = driver.getTitle();

		return title;
	}
		/*//switch to default content 
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement iframe1= driver.findElement(By.id(data.getData(3, 38, 3)));// SWITCH TO I -FRAME
		driver.switchTo().frame(iframe1);													

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		
		driver.findElement(By.id("chkVesselAssign")).click();//click in By vesssel assignment radio button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("lnkPeriod")).click();//click in forms due in the next days
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("lnkPeriodGetFormsReceived('30');")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("txtMainSearch")).sendKeys(" inheritance.java"); //enter file name in search bar
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("btnMainsearch")).click();//click in search button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		
		driver.findElement(By.name("MainRepeater$ctl01$cdcatalog$ctl01$ctl06")).click();//click in view arrow
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		*/
	
//(21) Approval configuration for file  --------------------------------------------------------------------
	public String approvalconfiguration(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		long LoagingStart = System.currentTimeMillis(); // for get page load
														// time

		@SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));

		long Loadingstop = System.currentTimeMillis();

		double TotalTime = (Loadingstop - LoagingStart);

		String Result = Double.toString(TotalTime);

		System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");

		write_data.writedata(3, 53, 9, Result);
		driver.findElement(By.id(data.getData(3, 52, 3))).click();// click in APPROVAL CONFIGURATIONN BUTTON
																	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
//(23)click in Approval configuration new window open ,give new window id and frame id 
		driver.findElement(By.id("dvFileApproval")); 
		WebElement iframe1 = driver.findElement(By.id("IfrmFileApproval"));// SWITCH TO I-FRAME
		driver.switchTo().frame(iframe1);
		 driver.findElement(By.id(data.getData(3, 53, 3))).click(); //click in add level button
		
		Thread.sleep(1000);
		String title = driver.getTitle().trim();
         return title;
	}
//(24)assign L-1,L-2,AND L-3 approval name 
	public String L1(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		LoagingStart = System.currentTimeMillis(); // for get page load time
//calculate page load time for l-1
		@SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));
        long Loadingstop = System.currentTimeMillis();
        double TotalTime = (Loadingstop - LoagingStart);
        String Result = Double.toString(TotalTime);
         System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");
         write_data.writedata(3, 55, 9, Result);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.id(data.getData(3, 54, 3))).click();// click in L-1
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("grdUser_ctl17_chkUser")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("grdUser_ctl18_chkUser")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 56, 3))).click();// click in SAVE BUTTON
																	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String title = driver.getTitle();

		return title;
	}
//(25)this is for alert box --------------------------------------------------------------------
	public String isAlertPresent(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		
		try {

			// Switching to Alert
			Alert alert = driver.switchTo().alert();

			// Capturing alert message.
			String alertMessage = driver.switchTo().alert().getText();
			// Displaying alert message
			System.out.println(alertMessage);
			Thread.sleep(1000);
			// Accepting alert
			// alert.accept();

			String alertMessage1 = "Approver List Updated Successfully";

			if (alertMessage.equals(alertMessage1)) {
				write_data.writedata(3, 57, 8, "Approver List Updated Successfully");
			} else {
				write_data.writedata(3, 57, 8, "fail");
			}

			Assert.assertEquals(alertMessage, alertMessage1);
			alert.accept();
		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}

		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.name("grdLevel$ctl02$ImgSelectLevel")).click();// click L-1 ARROW SIGN
																				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		String title = driver.getTitle().trim();
        return title;

	}
//same as L-2------------------------------------------------------------------------------------
	public String L2(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		long LoagingStart = System.currentTimeMillis(); // for get page load  time
														

		@SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));

		long Loadingstop = System.currentTimeMillis();

		double TotalTime = (Loadingstop - LoagingStart);

		String Result = Double.toString(TotalTime);

		System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");

		write_data.writedata(3, 61, 9, Result);
		
		 driver.findElement(By.id(data.getData(3, 53, 3))).click(); //click in add level button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("grdLevel_ctl03_lnklevel")).click(); // click IN L-2
																		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);

		WebElement name= driver.findElement(By.xpath(".//*[@id='grdUser_ctl08_chkUser']"));
		
		name.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		WebElement name1=driver.findElement(By.xpath(".//*[@id='grdUser_ctl07_chkUser']"));
		name1.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();// click in SAVE BUTTON
																	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		try {
			// Switching to Alert
			Alert alert1 = driver.switchTo().alert();

			// Capturing alert message.
			String alertMessage = driver.switchTo().alert().getText();
			// Displaying alert message
			System.out.println(alertMessage);
			Thread.sleep(1000);
			// Accepting alert
			// alert.accept();

			String alertMessage2 = "Approver List Updated Successfully";

			if (alertMessage.equals(alertMessage2)) {
				write_data.writedata(3, 60, 8, "Approver List Updated Successfully");
			} else {
				write_data.writedata(3, 60, 8, "fail");
			}
			Assert.assertEquals(alertMessage, alertMessage2);
			alert1.accept();
		}

		catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}

		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.name("grdLevel$ctl03$ImgSelectLevel")).click();// click L_2 ARROW BUTTON
																
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		String title = driver.getTitle();

		return title;
	}
//for L-3 --------------------------------------------------------------------------------------------------
	public String L3(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		
		
		long LoagingStart = System.currentTimeMillis(); // for get page load time
														

		@SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));

		long Loadingstop = System.currentTimeMillis();

		double TotalTime = (Loadingstop - LoagingStart);

		String Result = Double.toString(TotalTime);

		System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");

		write_data.writedata(3, 62, 9, Result);
		
		 driver.findElement(By.id(data.getData(3, 53, 3))).click(); //click in add level button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("grdLevel_ctl04_lnklevel")).click(); // click in L-3 
																		

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("grdUser_ctl54_chkUser")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("grdUser_ctl55_chkUser")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id(data.getData(3, 56, 3))).click();// click in save button
																	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		try {
			// Switching to Alert
			Alert alert2 = driver.switchTo().alert();

			// Capturing alert message.
			String alertMessage1 = driver.switchTo().alert().getText();
			// Displaying alert message
			System.out.println(alertMessage1);
			Thread.sleep(1000);
			// Accepting alert
			// alert.accept();

			String alertMessage3 = "Approver List Updated Successfully";

			if (alertMessage1.equals(alertMessage3)) {
				write_data.writedata(3, 62, 8, "Approver List Updated Successfully");
			} else {
				write_data.writedata(3, 62, 8, "fail");
			}
			Assert.assertEquals(alertMessage1, alertMessage3);
			alert2.accept();
		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();

		}
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='grdLevel_ctl04_ImgSelectLevel']")).click();// click in arrow button
																							
																							
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.name("grdLevel$ctl04$ImgSelectLevel")).click();// click in cancel button
																				
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		String title = driver.getTitle();

		return title;
	}
	//(26)After that we check file status with the help of file same ----------------------------------------------------------------
	public String checkfilestatus(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		Thread.sleep(1000);
		
		//switch to document  default content 
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				WebElement iframe1= driver.findElement(By.id(data.getData(3, 38, 3)));// SWITCH TO I -FRAME
				driver.switchTo().frame(iframe1);													
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.id("chkVesselAssign")).click();//click in By vesssel assignment radio button
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
		        driver.findElement(By.id("ddlVesselSearch_imgCollapseExpandDDL")).click();//click in fleet drop down button
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    Thread.sleep(1000);
				driver.findElement(By.id("ddlVesselSearch_chkSelectAll")).click();//click in all radio button
				driver.findElement(By.id("ddlVesselSearch_chkSelectAll")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.id("ddlVesselSearch_CheckBoxListItems_2")).click();//select haruka
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.id("ddlVesselSearch_CheckBoxListItems_3")).click();//select imara
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.id("ddlVesselSearch_btnApplyFilter")).click();//clcik in ok 
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
						
				Select fromtype = new Select(driver.findElement(By.id("ddlFormTypeSearch")));//select from type 
            	fromtype.selectByVisibleText("VOYAGE_SAFETY");
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						Thread.sleep(1000);
						Select fromstatus = new Select(driver.findElement(By.id("ddlStatusSearch")));//select from status 

						 fromstatus.selectByVisibleText("Pending O/B");
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							Thread.sleep(1000);
						 Select Department = new Select(driver.findElement(By.id("ddlDepartmentSearch")));

						 Department.selectByVisibleText("IT");
						
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							Thread.sleep(1000);
				
				driver.findElement(By.id("lnkPeriod")).click();//click in forms due in the next days
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='UpdatePanel20']/div[1]/table/tbody/tr/td[2]/div/ul/li/ul/li[3]/a")).click();//select 30 days 
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.findElement(By.id("btnPending")).click();//click in due/overdue/rework pannel
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(5000);
				WebElement search = driver.findElement(By.id("txtMainSearch"));//.sendKeys(" inheritance.java"); //enter file name in search bar
				search.clear();
				search.sendKeys(" inheritance.java");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.findElement(By.id("btnMainsearch")).click();//click in search button
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(5000);
				driver.findElement(By.name("MainRepeater$ctl01$cdcatalog$ctl03$ctl06")).click();//click in view arrow
				
				Thread.sleep(1000);
				
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Thread.sleep(1000);
				String title = driver.getTitle().trim();
				return title;
	}
	//(27)select file from the document tree then directly assign and schedule by clicking save assignment button
	public String saveassignment(WebDriver driver1) throws Exception {
		WebDriver driver = driver1;
		
		
		
		long LoagingStart = System.currentTimeMillis(); // for get page load time
														

		@SuppressWarnings("unused")
		List<WebElement> allLinks = driver.findElements(By.xpath("//*"));

		long Loadingstop = System.currentTimeMillis();

		double TotalTime = (Loadingstop - LoagingStart);

		String Result = Double.toString(TotalTime);

		System.out.println(driver.getTitle().trim() + " Pageloading time is " + TotalTime + " Milisec");

		write_data.writedata(3, 67, 9, Result);
		WebElement quality = driver.findElement(By.linkText(data.getData(3, 2, 3)));// quality main menu
		
		Thread.sleep(1000);

		Actions action = new Actions(driver);

		action.moveToElement(quality).build().perform();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		WebElement fms1 = driver.findElement(By.xpath(data.getData(3, 4, 3)));// FMS main menu
																				

		Thread.sleep(1000);
		action.moveToElement(fms1).build().perform();
		
		driver.findElement(By.linkText(data.getData(3, 5, 3))).click();// FMS sub menu fms main
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

		
		driver.findElement(By.id(data.getData(3, 36, 3))).click();// select folder name pooja singh1
		
		write_data.writedata(3, 36, 8, "Pass");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

	
		driver.findElement(By.id(data.getData(3, 65, 3))).click();// click in file name 
																	
		write_data.writedata(3, 65, 8, "Pass");
		
		WebElement iframe = driver.findElement(By.id(data.getData(3, 38, 3)));// SWITCH to I-frame
		
		driver.switchTo().frame(iframe);

		Thread.sleep(1000);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		

		driver.findElement(By.id(data.getData(3, 39, 3))).click(); // click in
																	// schedule
																	// icon

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);

		driver.findElement(By.id("dvScheduleInsp")); // go to document
														// scheduling page by id

		WebElement iframe1 = driver.findElement(By.id("IframeScheduleInsp"));// SWITCH to I-frame
																			

		driver.switchTo().frame(iframe1);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(5000);
		
		//select multiply file from the tree 
		driver.findElement(By.id(data.getData(3, 67, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 68, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 69, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 70, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 71, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 72, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
	/*	driver.findElement(By.id(data.getData(3, 73, 3))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		*/
		driver.findElement(By.id(data.getData(3, 74, 3))).click();       //select assign 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 75, 3))).click();   ///select schedule 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 76, 3))).click();    ///click in save schedule button 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Thread.sleep(1000);
		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);
		// Accepting alert
		// alert.accept();

		String alertMessage1 = "The un-assigned forms will removed completely from the chosen vessels and the assigned forms will be synchronized to the chosen vessels.";
		if (alertMessage.equals(alertMessage1)) {
			write_data.writedata(3, 78, 8, "The un-assigned forms will removed completely from the chosen vessels and the assigned forms will be synchronized to the chosen vessels.");
		} else {
			write_data.writedata(3, 78, 8, "fail");
		}

		Assert.assertEquals(alertMessage, alertMessage1);
		alert.accept();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.id(data.getData(3, 20, 3))).click();// switch in default content and click in refresh button
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
	driver.findElement(By.id(data.getData(3, 36, 3))).click();// select folder name pooja singh1
		
		write_data.writedata(3, 36, 8, "Pass");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(1000);

	
		///driver.findElement(By.id(data.getData(3, 65, 3))).click();// click in file name 
																	
		//.writedata(3, 65, 8, "Pass");
									
	
		// Click on username textbox
		driver.findElement(By.id("771")).click();

		// Create action class object
		Actions ActionChains=new Actions(driver);

		// find the tooltip/helptext message xpath
		WebElement username_tooltip=driver.findElement(By.className("selected"));

		// Mouse hover to that text
		ActionChains.clickAndHold(username_tooltip).perform(); 

		// Extract the text from tooltip using getText
		String tooltip_msg=username_tooltip.getText();

		 // Print the tooltip message
		System.out.println("Tooltip message is "+tooltip_msg);

	//	// This is expected message should come and store in variable
		// expected_tooltip="You can use letters, numbers, and periods.";

		// It will compare if actual matches with expected then TC will fall else it will fail

	//.assertEquals(tooltip_msg, expected_tooltip);

		//System.out.println("Message verifed");
	//
		
		 
		String title = driver.getTitle();

		return title;

}
	//THIS IS FOR SCREEN SHOT WHEN TESTCASE IS FAILED---------------------------------------------------------
	public String SShot(String actual1, String title1, WebDriver driver1) throws IOException {

	String actual = actual1;
	String title = title1;
	WebDriver driver = driver1;

	if (title.contentEquals(actual)) {
		System.out.println(title + " page is open.");
	} else {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File("C:\\Users\\jibetest"+ driver.getTitle().trim() + "_" + System.currentTimeMillis() + ".jpg"));


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			

		driver.get(title); // if the page is not exceuted then it will
								// opne this url
	}

	return (null);
	
	
}
}
