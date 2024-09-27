package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		
		WebElement img = driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		Actions act=new Actions(driver);
		act.contextClick(img).perform();
		
		WebElement productInfo=driver.findElement(By.xpath("//table[@id='dm2m1i1it']/tbody/tr/td[text()='Product Info']"));
		act.moveToElement(productInfo).perform();
		
		WebElement Installation = driver.findElement(By.xpath("//table[@id='dm2m2i1it']/tbody/tr/td[text()='Installation']"));
		act.moveToElement(Installation).perform();
		
		WebElement howToSetup = driver.findElement(By.xpath("//table[@id='dm2m3i1it']/tbody/tr/td[text()='How To Setup']"));
		act.click(howToSetup).perform();
		

	}

}
