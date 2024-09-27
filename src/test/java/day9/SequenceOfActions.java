package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SequenceOfActions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		
		WebElement username=driver.findElement(By.id("email"));
		Actions act = new Actions(driver);
		act.keyDown(Keys.SHIFT).
		pause(Duration.ofSeconds(1)).
		sendKeys(username,"hello").
		pause(Duration.ofSeconds(1)).
		keyUp(Keys.SHIFT).
		pause(Duration.ofSeconds(1)).
		doubleClick(username).
		pause(Duration.ofSeconds(1)).
		contextClick(username).build().perform();
		
		

	}

}
