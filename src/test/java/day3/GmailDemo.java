package day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailDemo {
	/*
	 * implicit wait
	 * explicit wait
	 * 
	 * WebDriverWait
	 */

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		/*
		 * Options m = driver.manage(); Window w = m.window(); w.maximize();
		 * 
		 * 5
		 */
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("identifierId")).sendKeys("info@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		//Thread.sleep(5000);//static wait
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Passwd"))).sendKeys("dfsdfdf");
		//driver.findElement(By.name("Passwd")).sendKeys("ghghjdgf");
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"))).click();
		//driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span")).getText());

	}

}
