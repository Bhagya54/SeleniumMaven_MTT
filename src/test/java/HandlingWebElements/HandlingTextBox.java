package HandlingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingTextBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("selenium");
		Thread.sleep(6000);
		email.clear();
		
		System.out.println("Placeholder for email field: " + email.getAttribute("placeholder"));
		
	}

}
