package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.testutil.TestUtil;
import com.freecrm.testutil.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	
	public static Properties prop;
	static EventFiringWebDriver e_driver;
	static WebEventListener webEventListener;
	
	public TestBase() {
		
	
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/freecrm/config/config.properties");
		prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/praveennaidu/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver","/Users/praveennaidu/Downloads/geckodriver");
				driver = new FirefoxDriver();
			}
e_driver = new EventFiringWebDriver(driver);
webEventListener = new WebEventListener();
	e_driver.register(webEventListener);
		driver = e_driver;
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		}
		
	}

