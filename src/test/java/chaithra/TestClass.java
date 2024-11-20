package chaithra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.getCurrentUrl();
		WebElement blockchk=driver.findElement(By.xpath("(//div[@class='display'])[1]"));
	    List<WebElement> sport = blockchk.findElements(By.name("sports"));
	   
	  for (WebElement spt :sport) {
		 String s=spt.getAttribute("value");
		 System.out.println(s);
		  if(s.equals("football")) {
		  spt.click();
	  }
	  
		
	}

}

	

}
