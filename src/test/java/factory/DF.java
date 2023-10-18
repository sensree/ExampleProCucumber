package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DF {
static 	WebDriver driver = null;
	public static WebDriver initbrow(String browserName) {
		
		if(browserName.equals("chrome")) {
			 driver = new ChromeDriver();
		}
			
		else if(browserName.equals("firefox")) {
	 driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("edge")) {
		 driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
}
	
	public static  WebDriver gD() {
		return driver;
	}
}
