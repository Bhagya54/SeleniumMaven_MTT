package testngTestcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {

	@Test
	public void verifyTitle() {
		String expectedTitle = "google.com";
		String actualTitle="gmail.com";
		
		/*if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass the testcase");
		}
		else {
			System.out.println("Fail the testcase");
		}*/
		
		
		//Hard Assert - whenever there is a failure, it terminates the program
		/*
		 * Assert.assertTrue(actualTitle.equals(expectedTitle),"Assert true is failing");
			Assert.assertEquals(actualTitle,expectedTitle,"Titles are not matching");
		*/
		
		
		//Soft Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle,expectedTitle,"Assert Equals>> Titles are not matching");
		softAssert.assertTrue(false,"Assert True>> Failure occured");
		Reporter.log("Soft Assert --  Testcase 2");
		softAssert.assertAll();
		
	
	}
}
