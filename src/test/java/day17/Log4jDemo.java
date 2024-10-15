package day17;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jDemo {
	static WebDriver driver;
	static Properties config = new Properties();
	static FileInputStream fis;
	static Properties or = new Properties();
	static Logger log;

	public static void main(String[] args) throws IOException {
		log = Logger.getLogger(Log4jDemo.class);
		fis = new FileInputStream("./src/test/resources/properties/log4j.properties");
		PropertyConfigurator.configure(fis);

		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		log.info("Config properties file has been loaded");

		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or.load(fis);
		log.info("OR properties file has been loaded");
		if (config.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome browser has been launched");
		} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox browser has been launched");
		} else if (config.getProperty("browser").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			log.info("Edge browser has been launched");
		}

		driver.manage().window().maximize();
		log.info("Browser has been maximized");
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));
		log.info("Testsite url: " + config.getProperty("testsiteurl") + " has been launched");

		try {
			type("username_ID", "training@gmail.com");
			type("pswd_NAME", "hello@123");
			click("loginBtn_XPATH");
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	static void click(String keyword) {

		getWebElement(keyword).click();
		log.info("Clicked on : " + keyword);
	}

	static void type(String keyword, String value) {

		getWebElement(keyword).sendKeys(value);
		log.info("Typed in the textbox: " + keyword + " with value as : " + value);

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
