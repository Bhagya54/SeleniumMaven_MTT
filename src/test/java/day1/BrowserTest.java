package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserTest {

	static String browser = "firefox";
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
		}
		
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}

		//driver.get("https://google.com");
		driver.navigate().to("https://google.com");
		Thread.sleep(2000);
		driver.navigate().to("https://gmail.com");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		String expectedTitle="Google";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass the testcase");
		}
		else {
			System.out.println("Fail the testcase");
		}
		System.out.println("Current url is: " + driver.getCurrentUrl());
		System.out.println("Title of the webpage: " + actualTitle);
		//System.out.println("PageSourse is : " + driver.getPageSource());
		//driver.quit();
		
		
	}

}
