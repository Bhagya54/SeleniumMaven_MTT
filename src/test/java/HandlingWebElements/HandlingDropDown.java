package HandlingWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		WebElement lang = driver.findElement(By.id("searchLanguage"));
		Select langSelect = new Select(lang);
		langSelect.selectByValue("nan");
		Thread.sleep(5000);
		langSelect.selectByVisibleText("Afrikaans");
		Thread.sleep(5000);
		langSelect.selectByIndex(1);

		/*
		 * List<WebElement> allLanguages = langSelect.getOptions();
		 * System.out.println("No. of lang: " + allLanguages.size()); for(WebElement e:
		 * allLanguages) {
		 * 
		 * if(e.getText().equals("Afrikaans")) {
		 * System.out.println("Req lang is present in the dropdown"); }
		 * 
		 * System.out.println(e.getText()); }
		 */

		
	List<WebElement> allLang=driver.findElements(By.tagName("option"));
	for(WebElement e:allLang) {
		System.out.println(e.getText());
	}
	
	}

}
