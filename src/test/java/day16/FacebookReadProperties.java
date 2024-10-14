package day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookReadProperties {

	static WebDriver driver;
	static Properties config = new Properties();
	static FileInputStream fis;
	static Properties or = new Properties();

	public static void main(String[] args) throws IOException {

		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);

		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or.load(fis);
		if (config.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));

		/*
		 * driver.findElement(By.id(or.getProperty("username_ID"))).sendKeys(
		 * "training@gmail.com");
		 * driver.findElement(By.name(or.getProperty("pswd_NAME"))).sendKeys("hello@123"
		 * ); driver.findElement(By.xpath(or.getProperty("loginBtn_XPATH"))).click();
		 */

		type("username_ID", "training@gmail.com");
		type("pswd_NAME", "hello@123");
		click("loginBtn_XPATH");

	}

	static void click(String keyword) {

		getWebElement(keyword).click();
	}

	static void type(String keyword, String value) {

		getWebElement(keyword).sendKeys(value);

	}

	static WebElement getWebElement(String keyword) {

		WebElement ele = null;
		if (keyword.endsWith("_ID")) {
			ele = driver.findElement(By.id(or.getProperty(keyword)));
		} else if (keyword.endsWith("_NAME")) {
			ele = driver.findElement(By.name(or.getProperty(keyword)));
		} else if (keyword.endsWith("_XPATH")) {
			ele = driver.findElement(By.xpath(or.getProperty(keyword)));
		} else if (keyword.endsWith("_CSS")) {
			ele = driver.findElement(By.name(or.getProperty(keyword)));
		} else if (keyword.endsWith("_CLASS")) {
			ele = driver.findElement(By.className(or.getProperty(keyword)));
		}
		
		return ele;
	}

}
