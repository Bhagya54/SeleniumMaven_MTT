package testngTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	@BeforeTest
	public void openDBConnection() {
		System.out.println("Create DB connection");
	}
	
	@AfterTest
	public void closeDBConnection() {
		System.out.println("Close DB connection");
	}
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	
	@Test(priority=-22)
	public void doUserReg() {
		System.out.println("User Reg Test");
	}
	
	@Test(priority=-12)
	public void doLogin() {
		System.out.println("Login Test");
	}
	
	
}
