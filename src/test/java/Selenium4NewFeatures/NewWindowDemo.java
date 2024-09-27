package Selenium4NewFeatures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class NewWindowDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://makemytrip.com");

		driver.findElement(By.className("commonModal__close")).click();
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Washington DC");
		System.out.println(driver.getTitle());
		
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://redbus.com");
		System.out.println(driver.getTitle());	
		

	}

}
