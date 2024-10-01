package HandlingWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableDemo {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		List<WebElement> headers = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/thead/tr/th"));
		for(WebElement head: headers) {
			System.out.println(head.getText());
		}
		
		WebElement EleSecondRowFourthCol = driver.
				findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[2]/td[4]"));
		System.out.println(EleSecondRowFourthCol.getText());
		
		
		
		
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
		int noOfRows=allRows.size();
		
		for(int row=0;row<noOfRows;row++) {
			int rowValue=row+1;
			List<WebElement> rowRelatedCols = driver.
		findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+rowValue+"]/td"));//tr[1]/td
			int noOfCols= rowRelatedCols.size();
			
			for(int col=0;col<noOfCols;col++) {
				int colValueN=col+1;
				WebElement colValue=driver.
			findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr["+rowValue+"]/td["+colValueN+"]"));
				System.out.print(colValue.getText() + " ");
			}
			System.out.println();
		}
		driver.close();
	
	}

}
