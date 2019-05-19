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

public class TestSuite extends Init{
	
	WebDriverWrappers wrapper = new WebDriverWrappers();
	CommonMethods methods = new CommonMethods();
	public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	Properties prop = new Properties();
	
	@BeforeClass
	public void loadDataProperties() throws Exception{
		String dataDirectory = currDirectory + File.separator + "global" + File.separator + "data.properties";
		String dataFile = dataDirectory;
		prop.load(new FileInputStream(dataFile));
	
	}
	
	@Test(enabled = true, priority=1)
	public void validatingLoginAndLogoutFromApplication() throws Exception{
		logger.info("Test Purpose: Login to Application");
		String userName = prop.getProperty("userName");
		String pwd = prop.getProperty("pwd");
		boolean flag = false;
		flag = methods.loginAndLogoutFromApplication(driver, logger, userName, pwd);
		Assert.assertTrue(flag, "Failed to validate application login");
	}
	
	
	@Test(enabled = true, priority=2)
	public void ValidatingFirstAvailableHeadphoneAddToCart() throws Exception{
		logger.info("Test Purpose: Select First Available Headphone And Add To Cart");
		String userName = prop.getProperty("userName");
		String pwd = prop.getProperty("pwd");
		boolean flag = false;
		flag = methods.selectFirstAvailableHeadphoneAddToCart(driver, logger, userName, pwd);
		Assert.assertTrue(flag, "Failed to Select First Available Headphone And Add To Cart");
	}
	
	@Test(enabled = true, priority=3)
	public void ValidatingMacBookProAddedToCart() throws Exception{
		logger.info("Test Purpose: Search Mac Book Pro and add to cart");
		String macBookPro = prop.getProperty("macBookPro");
		boolean flag = false;
		flag = methods.macBookProAddedToCart(driver, logger, macBookPro);
		Assert.assertTrue(flag, "Failed to search Mac Book Pro and add to cart");
	}
	
	
	@Test(enabled = true, priority=4)
	public void ValidatingSelectCartAndRemoveHeadphoneReduceMacQuantityAndCheckout() throws Exception{
		logger.info("Test Purpose: Select cart and remove headphone, reduce Mac quantity and checkout");
		boolean flag = false;
		flag = methods.selectCartAndRemoveHeadphoneReduceMacQuantityAndCheckout(driver, logger);
		Assert.assertTrue(flag, "Failed to select cart and remove headphone, reduce Mac quantity and checkout");
	}
	

	
	@Test(enabled=true, priority=5)
	public void validatingCloseBrowser() throws Exception{
	boolean flag = false;
	flag = methods.tearDown(driver, logger);
	Assert.assertTrue(flag, "Failed to Close the Browser");
	
	}
	
	
	
	
	


}
