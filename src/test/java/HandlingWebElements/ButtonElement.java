package HandlingWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonElement {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		WebElement loginBtn=driver.findElement(By.name("login"));
		loginBtn.click();
		
		WebElement errorMessage= driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]"));
		if(errorMessage.isDisplayed()) {
			System.out.println("Pass the testcase");
		}
		else {
			System.out.println("Fail");
		}

	}

}
