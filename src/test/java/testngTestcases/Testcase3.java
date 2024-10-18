package testngTestcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase3 {

	@Test(priority=1)
	public void doUserReg() {
		System.out.println("User Reg Test");
		Assert.fail("User Registration Test is failed intentionally");
	}
	
	@Test(priority=2,dependsOnMethods = {"doUserReg"})
	public void doLogin() {
		System.out.println("Login Test");
		
	}
	
	@Test
	public void doSkip() {
		throw new SkipException("Skipping the test intentionally");
	}
	
}
