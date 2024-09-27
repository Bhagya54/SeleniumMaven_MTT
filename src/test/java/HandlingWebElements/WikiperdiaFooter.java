package HandlingWebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikiperdiaFooter {

	public static void main(String[] args) {
		// site-license
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.wikipedia.org/");
		
		List<WebElement> footerEle=driver.findElements(By.xpath("//p[@class='site-license']/small/a"));
		for(WebElement ele: footerEle) {
			if(ele.getText().equals("Terms of Use")) {
				ele.click();
				break;
			}
		}

	}

}
