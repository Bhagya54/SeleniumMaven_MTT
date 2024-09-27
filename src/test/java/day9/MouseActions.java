package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.carwale.com/");
		WebElement newCar=driver.findElement(By.xpath("//*[text()='NEW CARS']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(newCar).perform();
		
		WebElement findNewCar=driver.findElement(By.xpath("//*[text()='Find New Cars']"));
		act.click(findNewCar).perform();
		
		WebElement NewCarTitle = driver.findElement(By.xpath("//h1"));
		if(NewCarTitle.getText().equals("New Cars"))
		{
			System.out.println("New cars page is successfully displayed");
		}
		else {
			System.out.println("Not displaying New Cars page");
		}
	}

}
