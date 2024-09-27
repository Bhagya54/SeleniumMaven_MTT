package Selenium4NewFeatures;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.emulation.Emulation;
import org.openqa.selenium.devtools.v127.network.Network;

import com.google.common.collect.ImmutableList;

public class CDP_BlockNetworkRequests {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		DevTools dev = driver.getDevTools();
		dev.createSession();
		dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dev.send(Network.setBlockedURLs(ImmutableList.of("*.jpg*","*.png","*.jpeg")));
		
		

		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.className("commonModal__close")).click();
	}

}
