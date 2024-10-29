package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import day17.Log4jDemo;
import extentlisteners.ExtentListeners;


public class KeywordDemo {

	 WebDriver driver;
	 Properties config = new Properties();
	 FileInputStream fis;
	 Properties or = new Properties();
	 Logger log;
	
	public KeywordDemo(WebDriver driver) throws IOException {
		this.driver = driver;
		log = Logger.getLogger(KeywordDemo.class);
		fis = new FileInputStream("./src/test/resources/properties/log4j.properties");
		PropertyConfigurator.configure(fis);
		
		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		log.info("Config properties file has been loaded");
		
		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or.load(fis);	
		log.info("OR properties file has been loaded");
	}

	public void click(String keyword) {

		getWebElement(keyword).click();
		log.info("Clicked on : " + keyword);
		ExtentListeners.test.info("Clicked on : " + keyword);
	}

	public void type(String keyword, String value) {

		getWebElement(keyword).sendKeys(value);
		log.info("Typed in the textbox: " + keyword + " with value as : " + value);
		ExtentListeners.test.info("Typed in the textbox: " + keyword + " with value as : " + value);
	
	}

	public WebElement getWebElement(String keyword) {

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
