package com.execui.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.execui.qa.util.Testutil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	// Initialization of the properties files 
	public TestBase() {
		FileInputStream fi;
		try {
			prop = new Properties();
			fi = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com//execui//qa/config//config.properties");	
			prop.load(fi); 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// Initialization of WebDriver and launch the web browser based  the given browser name in properties file 
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.endsWith("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.endsWith("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.out.println("Browser not defined ");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
				
	}
	

}
