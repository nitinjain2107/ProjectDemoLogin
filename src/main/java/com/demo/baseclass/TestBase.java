package com.demo.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.utilities.UtilClass;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try {
			
			
			
			prop = new Properties();
			FileInputStream fileInput = new FileInputStream("/Users/macbookair/Documents/workspace/ProjectDemoLogin/src/main/java/com/demo/configproperties/properties");
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace() ;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
		
	public static  void initilization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/macbookair/Downloads/chromedriver");
			driver =new ChromeDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.pageLoadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.implicitWaitTimeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
