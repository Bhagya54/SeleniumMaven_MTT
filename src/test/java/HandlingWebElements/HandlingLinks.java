package HandlingWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingLinks {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("No. of links: " + allLinks.size());
		for(int i=0;i<allLinks.size();i++) {
			System.out.println(allLinks.get(i).getText());
		}

	}

}
