package day11;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotDemo {
	
	static WebDriver driver;
	public static void takeScreenshot() throws IOException {
		Date d=new Date();
		String fileName=d.toString().replace(" ","_").replace(":", "_")+".jpg";
		File screenshot1= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("./screenshots/"+fileName));
	}
	
	public static void takeEleScreenshot(WebElement ele) throws IOException {
		Date d=new Date();
		String fileName="Ele_"+d.toString().replace(" ","_").replace(":", "_")+".jpg";
		File screenshot1=ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("./screenshots/"+fileName));
	}
	
	public static void takeFullPageScreenshot() throws IOException {
		Date d=new Date();
		String fileName="FullPage_"+d.toString().replace(" ","_").replace(":", "_")+".jpg";
		File fullPageScreenshot=((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fullPageScreenshot, new File("./screenshots/"+fileName));
	}
	

	public static void main(String[] args) throws IOException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://makemytrip.com");
		
		driver.findElement(By.className("commonModal__close")).click();
		takeScreenshot();
		
		driver.navigate().to("https://facebook.com");
		takeScreenshot();
		
		WebElement email=driver.findElement(By.id("email"));
		takeEleScreenshot(email);
		
		takeFullPageScreenshot();
		
	}

}
