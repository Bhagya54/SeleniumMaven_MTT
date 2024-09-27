package HandlingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingTextElement {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		WebElement textElem = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/h2"));
		System.out.println("text that is being displayed is : " +textElem.getText());
	
	}

}
