package testngTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	
	WebDriver driver;
	
	@Parameters({"browserName","siteURL"})
	@BeforeMethod
	public void launchBrowser(String browser,String url)
	{
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void doLogin() {
				
		System.out.println(driver.getTitle());
	}
	

	@Test
	public void doUser() {
				
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
