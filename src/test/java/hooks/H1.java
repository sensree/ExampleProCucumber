package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DF;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigClass;

public class H1 {
		WebDriver driver;
		
		@Before
		public void setUp() throws Exception{
		
		Properties prop = ConfigClass.initProp();
		driver =  DF.initbrow(prop.getProperty("browser"));	
//		DF.initbrow("chrome");
//		driver = DF.gD();
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		//driver.get("https://tutorialsninja.com/demo/");
		
		}
		
		@After
		public void tearDown(Scenario scenario)
		{
			String scean = scenario.getName().replaceAll(" ","_");
			if(scenario.isFailed()) {
				byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(srcScreenshot, "image/png",scean);
			}
			
			driver.quit();
		}
	}


