package com.qa.common;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
 


public class WebDriverBase {
	public static String RUNTYPE="";
	public static String BROWSER = "";
	public WebDriver driver=null;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	public String HUB_URL = "";
	public Logger logger ;
	public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	

	@BeforeClass
	public void initFramewotk() throws Exception{
		loadProperties();
		initiateDriver();
	}
	
	@BeforeMethod
	public void setupLogger(Method method) throws Exception{
		String logpath = currDirectory + File.separator + "logs" + File.separator;
		
		logger = Logger.getLogger(logpath + method.getName()+ "_result.txt");
		
		FileHandler handler = new FileHandler(logpath + method.getName()+ "_result.txt");
		logger.addHandler(handler);
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		handler.setFormatter(new SimpleFormatter());
	}
	public void loadProperties() throws Exception {
		
		String propfile = currDirectory + File.separator + "global" + File.separator + "global.properties";
		Properties prop = new Properties();
		prop.load(new FileInputStream(propfile));
		RUNTYPE = prop.getProperty("RUNTYPE");
		HUB_URL = prop.getProperty("HUB_URL");
		BROWSER = prop.getProperty("BROWSER");
		
	}
	
	public void initiateDriver() throws Exception {
	
		
		if (BROWSER.equalsIgnoreCase("IE")){
			
			
			File file = new File(currDirectory + File.separator + "IEDriverServer.exe");
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);  
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		
		} else if(BROWSER.equalsIgnoreCase("GC")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		} else {
		
			driver = new FirefoxDriver();
		}
	}
	

}
