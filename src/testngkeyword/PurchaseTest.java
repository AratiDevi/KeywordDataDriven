package testngkeyword;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import testcase.Purchase;


public class PurchaseTest extends JibeLoginTest{

Purchase p=new Purchase();

	
      @Test(priority=0)                                                          // CREATE REQSN     
	public void purchase() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
	   
	    
	//  p.purchaseCreateRequisition(driver); 
	
	}
      
      
      @Test(priority=1)                                                          //EXCEL
      public void purchase11() throws Exception
      {
    	  
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		Thread.sleep(1000);  
  		
  		
	  //  p.PurchaseProcess(driver);
	
	    
	 }
      
      
      @Test(priority=2)                                                            //WEB
      public void purchase12() throws Exception
      {
    	  
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		Thread.sleep(1000);  
  		
  		
	    p.PurchaseProcessWeb(driver);
      
      }
      
	
      
      

}
