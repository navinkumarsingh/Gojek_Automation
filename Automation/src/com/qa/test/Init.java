package com.qa.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

import com.qa.common.WebDriverBase;

public class Init extends WebDriverBase {
	public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	String propfile = currDirectory + File.separator + "global" + File.separator + "global.properties";
	Properties prop = new Properties();
	
	@BeforeClass
	public void launchApplication()  {
		try{
		prop.load(new FileInputStream(propfile));
		String url = prop.getProperty("WEBSITE_URL");
		driver.get(url);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		}catch(Exception e)
		{
			logger.info("Exception is " + e.getMessage());
		}
	}

}
