package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * CTRL+SHIFT+O
 * 
 */
public class LocatingElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.facebook.com/");
		Navigation n = driver.navigate();
		n.to("https://www.facebook.com");
		
		//driver.manage().window().maximize();
		Options m = driver.manage();
		Window w = m.window();
		w.maximize();
		/*
		 * WebElement username = driver.findElement(By.id("email"));
		 * username.sendKeys("bhagya");
		 */
		
		//method chaining
		driver.findElement(By.id("email")).sendKeys("bhagya");
		
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys("hjghgds");

		driver.findElement(By.xpath("//*[starts-with(@id,'u_0_5')]")).click();
		//u_0_5_0f
		//driver.close();
	}

}
