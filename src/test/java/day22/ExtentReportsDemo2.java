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

import extentlisteners.ExtentListeners;

public class ExtentReportsDemo2 {

	
	
	@Test
	public void doLogin() {
			ExtentListeners.test.info("Entering username");
			ExtentListeners.test.info("Entering password");
			ExtentListeners.test.info("Clicking on login");
	}
	
	@Test
	public void doUserReg() {
		
		
		Assert.fail("User Reg is failed");
		
	}
	
	@Test
	public void doSkip() {
		
		throw new SkipException("Intentianally skipping the test");
		
	}
	
	
	
}
