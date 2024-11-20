package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridDemo {
	/*
	 * 1.Selenium Webdriver 2.Selenium IDE - record and playblack 3.Selenium Grid -
	 * used for distributed execution
	 * 
	 * Standalone mode - hub/node same machines 
	 * Hub and Node 
	 */

	public WebDriver driver;
	public Capabilities cap;

	@Parameters({ "browser", "url" })
	@Test
	public void launchBrowser(String browser, String url) throws MalformedURLException {

		if (browser.equals("chrome")) {
			cap = new ChromeOptions();
		}

		else if (browser.equals("firefox")) {
			cap = new FirefoxOptions();
		}
		else if (browser.equals("Edge")) {
			cap = new EdgeOptions();
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Selenium " + browser);

	}
}
