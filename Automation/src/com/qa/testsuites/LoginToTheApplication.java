package com.qa.testsuites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.common.WebDriverWrappers;
import com.qa.test.Init;
import com.qa.test.methods.CommonMethods;

public class LoginToTheApplication extends Init{
	
	WebDriverWrappers wrapper = new WebDriverWrappers();
	CommonMethods methods = new CommonMethods();
	public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	Properties prop = new Properties();
	
	@BeforeClass
	public void loadDataProperties() throws Exception{
		String dataDirectory = currDirectory + File.separator + "global" + File.separator + "Kodiak_CAT_Suite1_Data.properties";
		String dataFile = dataDirectory;
		prop.load(new FileInputStream(dataFile));
	
	}
	
	@Test(enabled = true, priority=1)
	public void validatingLogin() throws Exception{
		logger.info("Test Purpose: Login to Application");
		String userName = prop.getProperty("userName");
		String pwd = prop.getProperty("pwd");
		boolean flag = false;
		flag = methods.loginToTheApplication(driver, logger, userName, pwd);
		Assert.assertTrue(flag, "Failed to validate application login");
	}
	
	
	@Test(enabled = true, priority=2)
	public void ValidatingHeadphoneAndAddToCart() throws Exception{
		logger.info("Test Purpose: Select First Available Headphone And Add To Cart");
		boolean flag = false;
		flag = methods.selectFirstAvailableHeadphoneAndAddToCart(driver, logger);
		Assert.assertTrue(flag, "Failed to Select First Available Headphone And Add To Cart");
	}
	
	@Test(enabled=true, priority=3)
	public void validatingCloseBrowser() throws Exception{
	boolean flag = false;
	flag = methods.closeBrowser(driver, logger);
	Assert.assertTrue(flag, "Failed to Close the Browser");
	
	}
	
	
	
	
	


}
