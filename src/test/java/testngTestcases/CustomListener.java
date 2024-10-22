package testngTestcases;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		Reporter.log("Test case started: " + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Testcase is being failed : " +result.getName());
		
		Reporter.log("<a href=\"C:\\Users\\91733\\OneDrive\\Desktop\\new.png\" target=\"blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:\\Users\\91733\\OneDrive\\Desktop\\new.png\" target=\"blank\"><img src=\"C:\\Users\\91733\\OneDrive\\Desktop\\new.png\" width=200 height=200 /></a>");
	}
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Testcase has been skipped : " + result.getMethod().getMethodName());
	}
}
