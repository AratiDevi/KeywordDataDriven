package testcase;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import commonfunct.RW;



public class Purchase extends RW {
	 
public static WebDriver driver;

 public void purchaseCreateRequisition(WebDriver driver1) throws Exception 
	{
		 WebDriver driver=driver1;
		 Actions action= new Actions(driver);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(1000);
		
		
		 WebElement purchasemenu= driver.findElement(By.linkText(data.getData(3, 1, 2)));   //purchase
		 Thread.sleep(1000);
		 Thread.sleep(1000);
		
		 action.moveToElement(purchasemenu).build().perform();
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(1000);
		
		 click_element(driver, "linkText", data.getData(3, 3, 2));            // Create new Requisition
		 
		 Thread.sleep(1000);
		 // dropdownCheckbox
		/* driver.findElement(By.linkText("Purchase Process")).click();
		 
		 Thread.sleep(1000);
		 
		 
		// dropdownCheckbox(driver,"id","ctl00_MainContent_DDLVessel_imgCollapseExpandDDL","ctl00_MainContent_DDLVessel_CheckBoxListItems_4","ctl00_MainContent_DDLVessel_btnApplyFilter");
		 
		 
		
		// driver.findElement(By.id("ctl00_MainContent_DDLFleet_imgCollapseExpandDDL")).click(); // downarrow
		 Thread.sleep(1000);
		
		// driver.findElement(By.id("ctl00_MainContent_DDLFleet_UpdatePanelheckBoxListItems")).click();  //dropdown box
		// Thread.sleep(1000);
		
		// driver.findElement(By.id("ctl00_MainContent_DDLFleet_CheckBoxListItems_3")).click();   // checkbox
		// Thread.sleep(1000);
		
		// driver.findElement(By.id("ctl00_MainContent_DDLFleet_btnApplyFilter")).click();  //OK Button
		
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(1000);*/
		
		 //Get the page load Time
		
		  long LoagingStart = System.currentTimeMillis();

		  List<WebElement> allLinks = driver.findElements(By.xpath("//*"));

		  long Loadingstop = System.currentTimeMillis();

		  double TotalTime = (Loadingstop-LoagingStart);

		  String Result  =  Double.toString(TotalTime);

		  System.out.println(driver.getTitle().trim()+"Pageloading time is "+ TotalTime + " Milisec");



		  write_data.writedata(1,1,2,Result);

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  Thread.sleep(1000);
		  
		  
		  dropdown(driver, "name", data.getData(3, 4, 2),data.getData(3, 5, 2));          // Select Fleet - Fleet-A
		
		
		  Thread.sleep(2000);
		
		  dropdown(driver, "name", data.getData(3, 6, 2),data.getData(3, 7, 2));        // Select Vessel  - SANTA MONICA
		
	
		  Thread.sleep(2000);
		
	    
		  radioButton(driver, "id", data.getData(3, 180, 2));           // Department Type -stores
		
	      Thread.sleep(2000);
	     
	     
	      dropdown(driver, "name", data.getData(3, 8, 2),data.getData(3, 9, 2));         //  Select Department-  Cabin & Catering
	   
		  Thread.sleep(2000);
		
		  dropdown(driver, "id", data.getData(3, 10, 2),data.getData(3, 11, 2));       //Select Catalogue - IMPA CATALOGUE
		
		  Thread.sleep(1000);
		
		  dropdown(driver, "id", data.getData(3, 12, 2),data.getData(3, 13, 2));            // Urgency  - Normal
		
		  Thread.sleep(1000);
		
		  dropdown(driver, "id", data.getData(3, 14, 2),data.getData(3, 15, 2));          //Reqsn Type - Piece meal
		    
		  Thread.sleep(1000);
		
		
		//Select Requisition_dd= new Select(driver.findElement(By.id(data.getData(3, 16, 2))));    // Select Requisition
		//Requisition_dd.selectByVisibleText("06/02/2017 / Arati / Normal");
		//Thread.sleep(1000);
		
		//driver.findElement(By.id(data.getData(3, 17, 2))).click();       //View Requisition
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		
		
		click_element(driver, "id", data.getData(3, 62, 2));        // New Reqtn
		
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		click_element(driver, "xpath", data.getData(3, 18, 2));          // Sub Catalogue -
		
		Thread.sleep(2000);
		
		click_element(driver, "xpath", data.getData(3, 19, 2));        //Add Item
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		sendkeys(driver, "id", data.getData(3, 20, 2), data.getData(3,21,2));      // Part Number
		
	    Thread.sleep(1000);  
	    
	    sendkeys(driver, "id", data.getData(3, 22, 2), data.getData(3,23,2));          // Item
		
		Thread.sleep(1000);
		
		sendkeys(driver, "id", data.getData(3, 24, 2), data.getData(3,25,2));          // Long Description
		
		Thread.sleep(1000);
		
		dropdown(driver, "id", data.getData(3, 26, 2),data.getData(3, 27, 2));        // Unit  
		
		Thread.sleep(1000);
		
		click_element(driver, "id", data.getData(3, 28, 2));          // Save & Close
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		sendkeys(driver, "id", data.getData(3, 29, 2), data.getData(3,30,2));        // write Description & search- handle
		
		Thread.sleep(1000);
		
		click_element(driver, "id", data.getData(3, 31, 2));           // Click Search button
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		clear_element(driver, "id", data.getData(3, 32, 2));         //clear
		sendkeys(driver, "id", data.getData(3, 32, 2), data.getData(3,33,2));         // Enter ROB 22
		
		Thread.sleep(1000);
		
		
		clear_element(driver, "id", data.getData(3, 34, 2));         //clear
		sendkeys(driver, "id", data.getData(3, 34, 2), data.getData(3,35,2));         //Enter Reqst Quantity- 44
		
	    Thread.sleep(1000);
	    
	    clear_element(driver, "id", data.getData(3, 36, 2));         //clear
	    
	    sendkeys(driver, "id", data.getData(3, 36, 2), data.getData(3,37,2));            // Write Comments- goodd
	    
	    Thread.sleep(1000);
	    
	    click_element(driver, "id", data.getData(3, 38, 2));           // Preview & Finalise
	    
	    Thread.sleep(2000);
	    
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	
	  	uploadFile(driver,"xpath", data.getData(3, 183, 2), data.getData(3,184,2),data.getData(3,185,2), data.getData(3, 186, 2), data.getData(3,187,2));  // upload File
	    
	    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		dropdown(driver, "id", data.getData(3, 39, 2),data.getData(3, 40, 2));          // Delivery Port- AMOY
		
		Thread.sleep(1000);
		
		sendkeys(driver, "id", data.getData(3, 41, 2), data.getData(3,42,2));         // Delivery Date
		
		Thread.sleep(1000);
		
		sendkeys(driver, "id", data.getData(3, 43, 2), data.getData(3,44,2));           // Reason for request
		
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 45, 2),data.getData(3, 46, 2));             // 1A.Spare for Routine/Breakdown main
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 47, 2),data.getData(3, 48, 2));               // 4. Technical Calculation/Implication False
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 49, 2),data.getData(3, 50, 2));              // 5. Any Other Information If Available False
		
		Thread.sleep(1000);
		
		sendkeys(driver, "name", data.getData(3, 51, 2), data.getData(3,52,2));                //  Delivery Query for Stores
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 53, 2),data.getData(3, 54, 2));                // Store type Objective
		
		Thread.sleep(1000);
		
		sendkeys(driver, "name", data.getData(3, 55, 2), data.getData(3,56,2));                  //Store type subj
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 57, 2),data.getData(3, 58, 2));                  // Test Store Type- edited
		
		Thread.sleep(1000);
		
		dropdown(driver, "name", data.getData(3, 59, 2),data.getData(3, 60, 2));              // Test1 Spare Type
		
		Thread.sleep(1000);
	
		click_element(driver, "id", data.getData(3, 61, 2));          //Save & Finalize
		
		Thread.sleep(2000);
		
		// Switching to Alert        
	    Alert alert1=driver.switchTo().alert();  

	    // Capturing alert message.    
	    @SuppressWarnings("unused")
		String alertMessage1=driver.switchTo().alert().getText();  
	    // Displaying alert message  
	    // System.out.println(alertMessage);   
	    Thread.sleep(1000);  
	    // Accepting alert  
	    alert1.accept();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		  
		  
		  	  	  
	}        
	
	                                //TEST SCENARIO- 2
	                                // FOR EXCEL EMAIL EDITOR
	
	
	/*  public void PurchaseProcess(WebDriver driver1) throws Exception
	      {
		
		
    	 WebDriver driver=driver1;
	     Actions action= new Actions(driver);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(1000);
		
		
		 WebElement purchasemenu= driver.findElement(By.linkText(data.getData(3, 1, 2)));   //purchase
		 Thread.sleep(1000); 
		
		 action.moveToElement(purchasemenu).build().perform();
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		 driver.findElement(By.linkText(data.getData(3, 76, 2))).click();    // Purchase Process
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(1000);
		
	//   driver.findElement(By.id(data.getData(3, 77, 2))).click();   // New Requisitions option by default
		
		 Thread.sleep(3000);
		
	     WebElement iframe1= driver.findElement(By.id((data.getData(3, 81, 2)))); //switch to i frame
		   
	     driver.switchTo().frame(iframe1);
		   
		   
	     Thread.sleep(2000);
		  
		   
		// String result1=driver.findElement(By.xpath(data.getData(3,100,2))).getText();   // Get text from web app (requisition order)
		   
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
		 String handleBefore = driver.getWindowHandle();       // Parent window
		 
		 driver.findElement(By.xpath(data.getData(3,100,2))).click();    // click reqsn order no
		   
	     Thread.sleep(1000);
	     
	     
	     
	     for (String handle : driver.getWindowHandles()) {          //Switch to new window
	    	 
	     driver.switchTo().window(handle);}
	     
	     
	     driver.findElement(By.id(data.getData(3,102,2))).click();    //Send RFQ
	     Thread.sleep(3000);
	     
	     
	     driver.close();   
	  
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
         Thread.sleep(3000);
		
         
 
        for (String handle : driver.getWindowHandles()) {           //Switch to new window
  
        driver.switchTo().window(handle);}
        
        Thread.sleep(3000);	
		
		
  	//  driver.findElement(By.xpath(data.getData(3, 83, 2))).click();   // Add Supplier Name1
    //  Thread.sleep(3000);
		 
		// driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_lstsupplier_ctrl5_btnSelect']")).click();
		 
		
	   	driver.findElement(By.xpath(data.getData(3, 84, 2))).click();   // Add Supplier Name2
	   	
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
		
		WebElement radiobtn1=driver.findElement(By.id(data.getData(3, 85, 2)));     // 2nd RFQ Type
		radiobtn1.click();
		
		//Select Vat_dd= new Select(driver.findElement(By.id(data.getData(3, 86, 2))));      // Vat 1st
		//Vat_dd.selectByVisibleText("Yes");
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.id(data.getData(3, 88, 2))).sendKeys(data.getData(3,89,2));  // Delivery remarks1  jjjj
		Thread.sleep(1000);
		
		//driver.findElement(By.name(data.getData(3, 90, 2))).sendKeys(data.getData(3,91,2));   // Delivery remarks2   vvv
		 
		// driver.findElement(By.xpath(data.getData(3, 88, 2))).click();
		
		Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(1000);
	    
	    
	    driver.findElement(By.xpath(data.getData(3, 96, 2))).click();    // down arrow 1
	    Thread.sleep(2000);
	    Thread.sleep(2000);
	    
	    
	    
		
		Select DeliveryPort1_dd= new Select(driver.findElement(By.id(data.getData(3, 92, 2))));    // Delivery Port1
		DeliveryPort1_dd.selectByVisibleText("AARHUS");
		
		Thread.sleep(2000);
	
		
		//driver.findElement(By.xpath(data.getData(3, 97, 2))).click();    // down arrow 2
	   // Thread.sleep(2000);
	   // Thread.sleep(2000);
		
		//Select DeliveryPort2_dd= new Select(driver.findElement(By.id(data.getData(3, 94, 2))));      // Delivery Port2
		//DeliveryPort2_dd.selectByVisibleText("ABU DHABI");
		
		//Thread.sleep(2000);
		Thread.sleep(2000);
		
	    driver.findElement(By.id(data.getData(3, 98, 2))).click();   // send to selected suppliers
		
	    Thread.sleep(2000);
	    
	    
	   
		
	    for (String handle : driver.getWindowHandles()) {    // Switch to window email editor
	    	 
	    driver.switchTo().window(handle);}
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
	    Thread.sleep(3000);
  
	    driver.findElement(By.id(data.getData(3, 103, 2))).click();  // Excel link
	    
	    
	    Thread.sleep(2000);
	    Thread.sleep(2000);
	    driver.close();
	    
	    
	    
	                                            // OUT OF SCOPE
	    
	    // driver.findElement(By.linkText("RFQ_19_IMRA-BS-170028-O_002593_123170201ABU DHABI.xls")).click();
	    
    	//  List<WebElement> emailLink = driver.findElements(By.tagName("a"));           
	    //	Iterator<WebElement> i = emailLink.iterator();
		 //   String href = "RFQ_";
		//    while (i.hasNext()) {
		 //   WebElement emailLinks = i.next();
		 //   	if (emailLinks.getAttribute("href").contains(href))               
			  
		//		System.out.print(href);
		//		emailLinks.click();
		//		System.out.print("Cliked");
		//		Thread.sleep(3000);
		//		break;
		 //  	}      
	   
	    
	    
	  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    Thread.sleep(3000);
	    
	    driver.switchTo().window(handleBefore);   // Switch to Parent
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id(data.getData(3, 111, 2))).click();  // Click on RFQ/Quotation
	    
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
	    Thread.sleep(3000);
	    
	    WebElement iframe2= driver.findElement(By.id((data.getData(3, 81, 2)))); //switch to i frame
		   
	    driver.switchTo().frame(iframe2);
	    
	    Thread.sleep(3000);
	    
	    
	    driver.findElement(By.id(data.getData(3, 112, 2))).click();   // Import excel RFQ
	    
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    
	    Thread.sleep(3000);
	    
	    
	    for (String handle : driver.getWindowHandles()) {    // Switch to window Import excel RFQ - upload Quotqn
	    	 
	    driver.switchTo().window(handle);}
	    
	    
	    driver.findElement(By.id(data.getData(3, 113, 2))).click();   // Browser to upload       
	    
	        
	    
    }      */
 
 
	                                   // SCENARIO-2

                                  //FOR WEB EMAIL EDITOR
	 
	    
	      public void PurchaseProcessWeb(WebDriver driver1) throws Exception  
	       {
	    	
	    	
		
		  WebDriver driver=driver1;
	 	  Actions action= new Actions(driver);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Thread.sleep(1000);
		
		
		  WebElement purchasemenu= driver.findElement(By.linkText(data.getData(3, 1, 2)));   //purchase
		  Thread.sleep(1000); 
		
		  action.moveToElement(purchasemenu).build().perform();
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  
		  click_element(driver, "linkText", data.getData(3, 76, 2));         // Purchase Process
		
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  Thread.sleep(3000);
		  
		  frameSwitchto(driver,"id","ctl00_MainContent_mainFrame");
			
	     // WebElement iframe1= driver.findElement(By.id((data.getData(3, 81, 2))));    //switch to i frame
		   
	     // driver.switchTo().frame(iframe1);
		   
	      Thread.sleep(2000);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  String handleBefore = driver.getWindowHandle();       // Parent window
		  
		  click_element(driver, "xpath", data.getData(3, 100, 2));            // click reqsn order no
		 
	      Thread.sleep(1000);
	      
	      WindowSwitchto(driver);  //Switch to new window
	     
	     // for (String handle : driver.getWindowHandles()) {          //Switch to new window
	    	 
	     // driver.switchTo().window(handle);}
	      
	      click_element(driver, "id", data.getData(3, 102, 2));         //Send RFQ
	      
	      Thread.sleep(3000);
	      
	      close_driver(driver);         //Close RFQ window
	      
	      Thread.sleep(3000);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	      Thread.sleep(3000);
	      
	      WindowSwitchto(driver);  //Switch to new window
			
	     // for (String handle : driver.getWindowHandles()) {           //Switch to new window
	  
	      //driver.switchTo().window(handle);}
	        
		  Thread.sleep(3000);
		 
		  click_element(driver, "xpath", data.getData(3, 83, 2));          // Add Supplier Name1
		  
		  Thread.sleep(3000);
		   
		  dropdown(driver, "id", data.getData(3, 86, 2),data.getData(3, 87, 2));             // Vat 1st
		   
		   Thread.sleep(2000);
		   
		   sendkeys(driver, "id", data.getData(3, 88, 2), data.getData(3,91,2));          // Delivery remarks1  vvv
		  
		   Thread.sleep(1000);
		   
		   click_element(driver, "xpath", data.getData(3, 96, 2));         // down arrow 1
		   
		   Thread.sleep(2000);
		   Thread.sleep(2000);
		   
		   dropdown(driver, "id", data.getData(3, 92, 2),data.getData(3, 95, 2));            // Delivery Port1
		
		   Thread.sleep(2000);
		  
		   click_element(driver, "id", data.getData(3, 98, 2));            // send to selected suppliers
		  
		   Thread.sleep(2000);
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   Thread.sleep(2000); 
		   
		   WindowSwitchto(driver);  //Switch to new window
			
		 //  for (String handle : driver.getWindowHandles()) {    // Switch to window email editor web
		    	 
		 //  driver.switchTo().window(handle);}
		   
		   Thread.sleep(3000);
		   
		   close_driver(driver);        // Close Email editor window
		   
		   Thread.sleep(3000);
		    
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		   
		   driver.switchTo().window(handleBefore);   // Switch to Parent
		   
		   
		   click_element(driver, "id", data.getData(3, 155, 2));            //Logout 1st userlogin Arati
		   
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
		   Thread.sleep(3000);
		   Thread.sleep(2000);   
		   
		   
		  
		  
		   //LOGIN AS SUPPLIER
		   
		   
		   driver.manage().deleteAllCookies();
		  
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arati\\workspace\\Driver\\chromedriver.exe");
			
		   driver= new ChromeDriver();
			
		   driver.get("http://114.79.180.66/JIBE/Account/Login.aspx?");
			
		   driver.manage().window().maximize();
			
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   
		   sendkeys(driver, "id", data.getData(2, 1, 2), data.getData(1,2,0));      // Read username from excelsheet    SUPPLIER     
		  
		   sendkeys(driver, "id", data.getData(2, 2, 2), data.getData(1,2,1));         //  Read Password from excelsheet   
		   
		   click_element(driver, "id", data.getData(2, 3, 2));             //  Read login button  from excelsheet
		   
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   Thread.sleep(3000);
		  
		   String handleBefore1 = driver.getWindowHandle();       // Parent window
		   
		   click_element(driver, "xpath", data.getData(3, 120, 2));        // Click View     
		   
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   Thread.sleep(3000);
		   
		   WindowSwitchto(driver);  //Switch to new window
		  
		   // for (String handle : driver.getWindowHandles()) {    // Switch to window 
		    	 
		  //  driver.switchTo().window(handle);}
		  
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Thread.sleep(3000);
		    
		    sendkeys(driver, "name", data.getData(3, 121, 2), data.getData(3,122,2));      // Currency  
		  
		    Thread.sleep(2000);
		    
		    sendkeys(driver, "id", data.getData(3, 123, 2), data.getData(3,124,2));          // Truck Charge
		    
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 125, 2), data.getData(3,126,2));           // Freight Cost   
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 127, 2), data.getData(3,128,2));           // Other Charge
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 129, 2), data.getData(3,130,2));            // Barge/Workboat Charge    
			
			Thread.sleep(2000);
			
			clear_element(driver, "id", data.getData(3, 131, 2));                    //clear
			sendkeys(driver, "id", data.getData(3, 131, 2), data.getData(3,132,2));             // Vat/GST(%) 
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 133, 2), data.getData(3,134,2));            // Pkg and handling Charges 
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 135, 2), data.getData(3,136,2));             // Reason for Other Charges
			
			Thread.sleep(2000); 
			
			clear_element(driver, "id", data.getData(3, 137, 2));                    //clear
			sendkeys(driver, "id", data.getData(3, 137, 2), data.getData(3,138,2));            //  Discount On Quot.(%)
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 139, 2), data.getData(3,140,2));               // Supplier Qtn. Ref 
			
			Thread.sleep(2000);
			
			sendkeys(driver, "id", data.getData(3, 141, 2), data.getData(3,142,2));               //  Reasons for trans/Pkg charges 
			
			Thread.sleep(2000);
			
			click_element(driver, "id", data.getData(3, 143, 2));             // Option Button
			
			Thread.sleep(2000);
			
			clear_element(driver, "id", data.getData(3, 144, 2));                    //clear
			sendkeys(driver, "id", data.getData(3, 144, 2), data.getData(3,145,2));       //  OEM   
			
			Thread.sleep(2000);
			
			clear_element(driver, "id", data.getData(3, 146, 2));                    //clear
			sendkeys(driver, "id", data.getData(3, 146, 2), data.getData(3,147,2));        //  Original
			
			Thread.sleep(2000);
			
			clear_element(driver, "id", data.getData(3, 148, 2));                    //clear
			sendkeys(driver, "id", data.getData(3, 148, 2), data.getData(3,149,2));          //  Replacement 
		
			Thread.sleep(2000);
			
			click_element(driver, "id", data.getData(3, 150, 2));       // Save
			
			Thread.sleep(3000);
			
			dropdown(driver, "id", data.getData(3, 151, 2),data.getData(3, 152, 2));               //  Item Type
			
			Thread.sleep(3000);
			
			click_element(driver, "id", data.getData(3, 153, 2));          //  Submit 
			
			// Switching to Alert        
		    Alert alert1=driver.switchTo().alert();  

		    // Capturing alert message.    
			@SuppressWarnings("unused")
		    String alertMessage1=driver.switchTo().alert().getText();  
			//  Displaying alert message  
			//  System.out.println(alertMessage);   
			Thread.sleep(1000);  
			// Accepting alert  
		    alert1.accept();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Thread.sleep(5000);
			 
			 
		    driver.switchTo().window(handleBefore1);   // Switch to Parent
		    
		    Thread.sleep(1000); 
		    
		    click_element(driver, "id", data.getData(3, 154, 2));           //logout supplier's  
		    
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		    Thread.sleep(5000);
		    
		   
			 
			 // LOGIN AS ARATI
			 
			 
			 driver.manage().deleteAllCookies();
			 
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arati\\workspace\\Driver\\chromedriver.exe");
				
		     driver= new ChromeDriver();
				
			 driver.get("http://114.79.180.66/JIBE/Account/Login.aspx?");
				
			 driver.manage().window().maximize();
				
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
			 
			 clear_element(driver, "id", data.getData(2, 1, 2));                        //clear
			 sendkeys(driver, "id", data.getData(2, 1, 2), data.getData(1,1,0));        // Read username from excelsheet  Arati
			 
			 
			 clear_element(driver, "id", data.getData(2, 2, 2));                        //clear
			 sendkeys(driver, "id", data.getData(2, 2, 2), data.getData(1,1,1));        //   Read Password from excelsheet
			
			 
			 click_element(driver, "id", data.getData(2, 3, 2));           //  Read login button  from excelsheet   
			 
			
			 Actions action1= new Actions(driver);
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 Thread.sleep(1000);
			
			
			 WebElement purchasemenu1= driver.findElement(By.linkText(data.getData(3, 1, 2)));   //purchase
			 Thread.sleep(1000); 
			
			 action1.moveToElement(purchasemenu1).build().perform();
			
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
			 
			 click_element(driver, "linkText", data.getData(3, 76, 2));           // Purchase Process
			
		     Thread.sleep(2000);
		     
		     
		     click_element(driver, "id", data.getData(3, 156, 2));            // 2nd stage RFQ/Quotation
		    
		     Thread.sleep(2000);
		     
		     frameSwitchto(driver,"id",data.getData(3, 81, 2));		 	 
		 	 
		 	// WebElement iframe2= driver.findElement(By.id((data.getData(3, 81, 2)))); //switch to i frame
			   
		    // driver.switchTo().frame(iframe2);
		     
		     Thread.sleep(2000);
		     
		     
		     String handleBefore2 = driver.getWindowHandle();       // Parent window
		     
		     click_element(driver, "id", data.getData(3, 157, 2));       // Click on Quotation no.    
		     
		     Thread.sleep(2000);
		     
		     WindowSwitchto(driver);  //Switch to new window
		     
		     
		   //  for (String handle : driver.getWindowHandles()) {          // Switch to new window Quotation Comparision
		    	 
			// driver.switchTo().window(handle);}
		     
		     
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     
		     Thread.sleep(2000);
		     
		     
		     click_element(driver, "id", data.getData(3, 158, 2));          //  Select Supplier Check box
		     
		     Thread.sleep(3000);
		     
		     
		     click_element(driver, "id", data.getData(3, 159, 2));         //  Compare Quotation 
		     
		     Thread.sleep(4000);
		     Thread.sleep(4000);
		     
		     
		     click_element(driver, "id", data.getData(3, 160, 2));              // Save Quotation Evaluation
		     
		   
		     Thread.sleep(3000);
		     
		     close_driver(driver);          // Close Quotation Comparision Page
		     
		   
		     Thread.sleep(3000);
		   
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		     driver.switchTo().window(handleBefore2);   // Switch to Parent
		     Thread.sleep(1000);  
	 
			 
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
		     Thread.sleep(3000);
		     
		     frameSwitchto(driver,"id",data.getData(3, 81, 2));     //switch to i frame
		   
		   //  WebElement iframe3= driver.findElement(By.id(data.getData(3, 81, 2))); //switch to i frame
		   
		   //  driver.switchTo().frame(iframe3);
		      
		     Thread.sleep(2000);
		     
		     
		     click_element(driver, "id", data.getData(3, 161, 2));          // Send To Supdt
		  
		     Thread.sleep(2000);
		     
		     dropdown(driver, "id", data.getData(3, 162, 2),data.getData(3, 163, 2));        // Approver
		    
		     Thread.sleep(2000);
		     
		     sendkeys(driver, "id", data.getData(3, 164, 2), data.getData(3,165,2));         //Remark 
		     
		     Thread.sleep(2000);
		     
		     click_element(driver, "id", data.getData(3, 166, 2));            // Save & Send For Approval
		     
		   
		     Thread.sleep(2000);
		   
		     driver.switchTo().window(handleBefore2);   // Switch to Parent
		     Thread.sleep(1000);
		     
		     click_element(driver, "id", data.getData(3, 155, 2));          // Logout Arati
		   
		  
		    Thread.sleep(2000);
		   
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);     
		   
		   
		   // LOGIN APPROVER (petar)
		   
		
		   driver.manage().deleteAllCookies();
			  
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arati\\workspace\\Driver\\chromedriver.exe");
			
		   driver= new ChromeDriver();
			
		   driver.get("http://114.79.180.66/JIBE/Account/Login.aspx?");
			
		   driver.manage().window().maximize();
			
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   
		   sendkeys(driver, "id", data.getData(2, 1, 2), data.getData(1,3,0));      // Read username from excelsheet    APPROVER    
		  
		   sendkeys(driver, "id", data.getData(2, 2, 2), data.getData(1,3,1));         //  Read Password from excelsheet  
		   
		   click_element(driver, "id", data.getData(2, 3, 2));          //  Read login button  from excelsheet 
		   
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   Thread.sleep(3000);
		   
		   Actions action2= new Actions(driver);
		   
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   Thread.sleep(1000);
			
			
		   WebElement purchasemenu2= driver.findElement(By.linkText(data.getData(3, 1, 2)));   //purchase
		   
		   Thread.sleep(1000); 
			
		   action2.moveToElement(purchasemenu2).build().perform();
			
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   
		   click_element(driver, "linkText", data.getData(3, 76, 2));         // Purchase Process 
			 
		   Thread.sleep(2000);
		   
		   click_element(driver, "id", data.getData(3, 170, 2));              //  Click 3rd Stage Quotation Approval
	  
		   Thread.sleep(3000);
		   
		   frameSwitchto(driver,"id",data.getData(3, 81, 2));
		   
           WebElement iframe4= driver.findElement(By.id(data.getData(3, 81, 2))); //switch to i frame
		   
		   driver.switchTo().frame(iframe4);
		   
		   Thread.sleep(3000);
		   
	   //  String handleBefore3 = driver.getWindowHandle();       // Parent window
		   
		   click_element(driver, "id", data.getData(3, 171, 2));           // Evaluate
		   
		   Thread.sleep(3000);
		   
		   WindowSwitchto(driver);  //Switch to new window
		   
		 //  for (String handle : driver.getWindowHandles()) {           //Switch to new window Quotation Comparision
				  
		 //  driver.switchTo().window(handle);}
		   
		   Thread.sleep(3000);
		  
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   
		   click_element(driver, "id", data.getData(3, 159, 2));            //  Compare Quotation
		  
		   Thread.sleep(3000);
		   
		   click_element(driver, "id", data.getData(3, 172, 2));          // Assign Budget code & Approve
		   
		   Thread.sleep(2000);
		   
		   dropdown(driver, "id", data.getData(3, 173, 2),data.getData(3, 177, 2));         // Budget Code   
		   
		   Thread.sleep(2000);
		   
		   sendkeys(driver, "id", data.getData(3, 174, 2), data.getData(3,175,2));          // Approver's Remark
		   
		   Thread.sleep(2000);
			
		   click_element(driver, "id", data.getData(3, 176, 2));         // Approve
			
	       //   driver.switchTo().window(handleBefore3);   // Switch to Parent
			
		   
			Thread.sleep(2000);
			// Switching to Alert        
		    Alert alert2=driver.switchTo().alert();  

		   // Capturing alert message.    
		   @SuppressWarnings("unused")
		   String alertMessage2=driver.switchTo().alert().getText();  
		   // Displaying alert message  
		   //  System.out.println(alertMessage);   
		   Thread.sleep(1000);  
		   // Accepting alert  
		   alert2.accept();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   Thread.sleep(5000);
	       
	       }
	    
	 
	
	
//THIS IS FOR SCREEN SHOT WHEN TESTCASE IS FAILED---------------------------------------------------------
public String SShot(String actual1, String title1, WebDriver driver1) throws IOException {

String actual = actual1;
String title = title1;
WebDriver driver = driver1;

if (title.contentEquals(actual)) {
 System.out.println(title + " page is open.\n");
} else {

 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 FileUtils.copyFile(scrFile, new File("C:\\Users\\Arati\\workspace\\KeywordDrivenJibe\\Screenshot\\purchase\\"+ driver.getTitle().trim() + "_" + System.currentTimeMillis() + ".jpg"));


 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   

 driver.get(Dashboard); // if the page is not exceuted then it will
       // opne this url
}

return (null);
}
}
	
	


