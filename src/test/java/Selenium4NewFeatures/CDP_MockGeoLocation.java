package Selenium4NewFeatures;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.emulation.Emulation;

public class CDP_MockGeoLocation {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		DevTools dev = driver.getDevTools();
		dev.createSession();
		dev.send(Emulation.setGeolocationOverride(Optional.of(51.509865),Optional.of(-0.118092),Optional.of(100)));

		driver.get("https://www.gps-coordinates.net/my-location");
	}

}
