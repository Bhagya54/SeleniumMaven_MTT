package Selenium4NewFeatures;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetFullPageScreenshotDemo {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://makemytrip.com");
		driver.findElement(By.className("commonModal__close")).click();
		
		File fullPageScreenshot=((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fullPageScreenshot, new File("./screenshots/fullPage.png"));
	}

}
