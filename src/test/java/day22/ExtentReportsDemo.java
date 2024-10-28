package day22;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {

	public ExtentSparkReporter htmlReporter;//html report
	public ExtentReports extent;//create a test and add some configuration
	public ExtentTest test; // test status - pass/fail/skip
	
	
	
	@BeforeTest
	public void setReports() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Learning Extent Reports");
		htmlReporter.config().setReportName("Web Automation");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Testers", "bhagya");
		extent.setSystemInfo("company name", "epam");
		extent.setSystemInfo("version", "2.0");
		
		
	}
	
	@Test
	public void doLogin() {
		test=extent.createTest("Login Test");
		System.out.println("Login Test");
		test.info("Enter username");
		test.info("Enter password");
		test.info("Click on login");
		
		
	}
	
	@Test
	public void doUserReg() {
		test=extent.createTest("User Registration");
		test.info("Enter firstname");
		test.info("Enter lastname");
		test.info("Click on register");
		
		Assert.fail("User Reg is failed");
		
	}
	
	@Test
	public void doSkip() {
		test=extent.createTest("Skip Test");
		test.info("Enter firstname");
		test.info("Enter lastname");
		throw new SkipException("Intentianally skipping the test");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		Markup m;
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			m = MarkupHelper.createLabel(methodName+" method has been passed", ExtentColor.GREEN);
			//test.pass(methodName+" method has been passed");
			test.pass(m);
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			m = MarkupHelper.createLabel(methodName+" method has been failed", ExtentColor.RED);
			test.fail(m);
			//test.fail(methodName+" method has been failed");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			m = MarkupHelper.createLabel(methodName+" method has been skipped", ExtentColor.ORANGE);
			test.skip(m);
			//test.skip(methodName+" method is skipped");
		}
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}
