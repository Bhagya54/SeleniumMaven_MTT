package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ReadProperties {

	static WebDriver driver;
	static Properties config = new Properties();
	static FileInputStream fis;
	static Properties or = new Properties();

	public ReadProperties(WebDriver driver) throws IOException {
		this.driver = driver;
		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);

		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or.load(fis);	

	}

	public void click(String keyword) {

		getWebElement(keyword).click();
	}

	public void type(String keyword, String value) {

		getWebElement(keyword).sendKeys(value);

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
