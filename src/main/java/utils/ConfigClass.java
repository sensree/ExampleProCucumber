package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigClass {
	public static Properties initProp() throws Exception {
		//Properties prop = new Properties();
//		//File propFile = new File(System.getProperty("C:\\Users\\chent\\eclipse-workspace\\ExamplePro\\src\\test\\resources1\\config\\config.properties"));
//		//File propFile = new File(System.getProperty("user.dir"+"\\src\\test\\resources1\\config\\config.properties"));
//		try {
//		FileInputStream fis = new FileInputStream(propFile);
//		prop.load(fis);
//		}catch(Throwable e) {
//			e.printStackTrace();
//		}
//		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\chent\\eclipse-workspace\\ExamplePro\\src\\test\\resources1\\config\\config.properties");
		prop.load(fis);
		return prop;
	}

	
}
