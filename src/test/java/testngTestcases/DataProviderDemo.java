package testngTestcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelReader;
import utility.KeywordDemo;


public class DataProviderDemo {
	WebDriver driver;
	KeywordDemo read;
	@Parameters({"browserName","siteURL"})
	@BeforeMethod
	public void lauchBrowser(String browser,String url) throws IOException {
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		read=new KeywordDemo(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	
	  @AfterMethod 
	  public void tearDown()
	  { 
		  driver.quit();
	  }
	 
	
	@Test(dataProvider ="Data" )
	public void doLogin(String username,String password) throws InterruptedException {
		
		/*
		 * System.out.println("Enter username: " + username);
		 * System.out.println("Enter password: " + password);
		 * System.out.println("Clicking on the login button");
		 */
		
		read.type("username_ID",username);
		read.type("pswd_NAME",password);
		read.click("loginBtn_XPATH");
		//Thread.sleep(5000);
		//WebElement passwordWrong = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]/text()"));
		//Assert.assertTrue(passwordWrong.isDisplayed(), "Pasword error message didnot display");
	}
	
	@DataProvider(name="Data")
	public Object[][] getData(){
		
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testData.xlsx");
		String sheetName="login";
		int noOfRows = excel.getRowCount(sheetName);//3
		int noOfCols = excel.getColumnCount(sheetName);//2
		
		Object[][] credentials = new Object[noOfRows-1][noOfCols];
		
		for(int row=2;row<=noOfRows;row++) {//3
			for(int col = 0;col<noOfCols;col++) {
				credentials[row-2][col] = excel.getCellData(sheetName, col,row);//0,2
			}
		}
		/*
		 * credentials[0][0] = excel.getCellData(sheetName, 0,2); credentials[0][1] =
		 * excel.getCellData(sheetName,1,2);
		 * 
		 * credentials[1][0] = excel.getCellData(sheetName, 0, 3); credentials[1][1] =
		 * excel.getCellData(sheetName, 1, 3);
		 */
		
			
		return credentials;
	}
	
}
