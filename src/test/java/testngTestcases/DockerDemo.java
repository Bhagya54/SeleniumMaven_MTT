package testngTestcases;

import java.io.IOException;
import java.net.URI;
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

public class DockerDemo {

WebDriver driver;
Capabilities cap;
	
	@Parameters({"browserName","siteURL"})
	@Test
	public void launchBrowser(String browser,String url) throws IOException
	{
		if(browser.equals("chrome")) {
			cap=new ChromeOptions();
		}
		else if(browser.equals("firefox")) {
			cap=new FirefoxOptions();
		}
		else if(browser.equals("edge")) {
			cap=new EdgeOptions();
		}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("Hello browser: " + browser);
	}
}
