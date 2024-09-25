package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public static Properties prop;
		
	public WebDriver initializeDriver() throws IOException
	{
		try {
		prop= new Properties();
		FileInputStream fls= new FileInputStream(System.getProperty("user.dir") +"/src/main/java/resources/data.properties");
		prop.load(fls);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	driver.manage().window().maximize();
	return driver;
}	
	

	public void tearDown() {
		
	}

}
