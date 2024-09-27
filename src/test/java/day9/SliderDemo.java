package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		WebElement slider_1 = driver.findElement(By.id("slider"));
		Dimension d = slider_1.getSize();
		int width=d.getWidth();
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, width/2, 0).perform();
		Thread.sleep(2000);
		act.dragAndDropBy(slider, -(width/4), 0).perform();
	}

}
