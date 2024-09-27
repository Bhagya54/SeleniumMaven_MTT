package day10;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
		
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		Alert al1=driver.switchTo().alert();
		System.out.println(al1.getText());
		Thread.sleep(2000);
		al1.accept();

		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		Alert al2=driver.switchTo().alert();
		al2.sendKeys("selenium");
		Thread.sleep(2000);
		al2.accept();
	}

}
