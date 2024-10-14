package day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		
		Properties or = new Properties();
		fis = new FileInputStream("./src/test/resources/properties/or.properties");
		or.load(fis);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(or.getProperty("username_ID"));
	}

}
