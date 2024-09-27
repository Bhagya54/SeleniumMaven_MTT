package HandlingWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlradio.php");
		WebElement block = driver.findElement(By.xpath("(//div[@class='display'])[1]"));
		List<WebElement> allFoods=block.findElements(By.name("food"));
		System.out.println(allFoods.get(1).getText());
		allFoods.get(1).click();

	}

}
