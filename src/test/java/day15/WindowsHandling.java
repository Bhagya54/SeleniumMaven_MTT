package day15;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		String parentWindow=driver.getWindowHandle();
		//System.out.println(parentWindow);
		
		driver.findElement(By.linkText("Meta Store")).click();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String w:allWindows) {
			
			if(!(w.equals(parentWindow))) {
				
				driver.switchTo().window(w);
				
				
				System.out.println("Title of my child window: " + driver.getCurrentUrl());
			driver.findElement(By.xpath("//*[@id=\"mdc-main-content\"]/div/div[1]/div/div/div/div[3]/div/div[4]/div/div[1]/div/div/span")).click();
			}
		}
		
		driver.switchTo().window(parentWindow);
		System.out.println("Title of parent window: " + driver.getTitle());
		
		
		

	}

}
