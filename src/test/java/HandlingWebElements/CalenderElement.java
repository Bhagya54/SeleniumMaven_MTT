package HandlingWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderElement {

	public static void main(String[] args) {
		// //div[@class='DayPicker-Month'][1]/div[3]/div[3]/div[3]/div/p[1]
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.className("commonModal__close")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='departure']/span")));
		driver.findElement(By.xpath("//label[@for='departure']/span")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]/div[3]/div[3]/div[3]/div/p[1]")).click();

		WebElement ele = driver.findElement(By.xpath("//p[@data-cy='departureDate']/span[1]"));
		if(ele.getText().equals("15")) {
			System.out.println("Pass the testcase");
		}
	}

}
