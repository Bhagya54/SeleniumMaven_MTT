package Selenium4NewFeatures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo {

	public static void main(String[] args) {
		// id/name/xpath/cssselctor/linkText/partialLinkText/tagname/classname
		/*
		 * leftOf
		 * rightOf
		 * near
		 * above()
		 * below
		 * 
		 * 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		
		WebElement practiceForm=driver.findElement(By.xpath("//a[text()=' Practice Form']"));
		WebElement login=driver.findElement(RelativeLocator.with(By.tagName("a")).below(practiceForm));
		
		login.click();
		
		WebElement EmailLabel = driver.findElement(By.xpath("//label[@for='email']"));
		WebElement emailTxtbox=driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(EmailLabel));
		emailTxtbox.sendKeys("selenium");

	}

}
