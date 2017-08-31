package MenuTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import common_Function.WebDriverPass;

public class MenuTestingTest extends WebDriverPass{
	ExtentReports report;
	ExtentTest test;
	MenuTesting p =new MenuTesting();

	@Test(priority=1)
	  public void MenuTestingByUrl() throws Exception {
		  test=report.startTest("MenuTesting by URL");  
		  p.MenuTestingByUrl(driver);
		  Assert.assertTrue(true);
	      test.log(LogStatus.PASS, "MenuTesting by URL");

		    
	  }	  @AfterMethod
	  	public void afterMethod(ITestResult result) {
	  	    if (result.getStatus() == ITestResult.FAILURE) {
	  	        test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
	  	    } else if (result.getStatus() == ITestResult.SKIP) {
	  	        test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	  	    } else {
	  	        test.log(LogStatus.PASS, "Test passed");
	  	    }
	  	    report.endTest(test);
	  	    report.flush();
	  }
	  @BeforeSuite
	  public void beforeSu() {
	  	  report = MenuTesting.getReporter(path.concat("Report.html"));
	  }
	
	

}




