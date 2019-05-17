package com.qa.test.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.qa.common.Timeouts;
import com.qa.common.WebDriverWrappers;
import com.qa.test.locators.Locators;
import com.sun.glass.events.KeyEvent;
import java.awt.Robot;

public class CommonMethods extends Timeouts {


	WebDriverWrappers wrapper = new WebDriverWrappers();

	public boolean closeBrowser(WebDriver driver, Logger logger) throws Exception{
		boolean flag = true;
		logger.info("Closing Browser for Test Suite");
		/*driver.close();
		Thread.sleep(SMALL_SLEEP);*/
		driver.quit();
		Thread.sleep(SMALL_SLEEP);
		return flag;
		
	}

	public boolean loginToTheApplication(WebDriver driver, Logger logger, String userName , String pwd) throws Exception{
		boolean catFlag = false;
		logger.info("Validating amazon logo in home page");
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.amazonLogo, SMALL_SLEEP_SECONDS);
		if(!catFlag){
			logger.info("Failed to validate amazon logo in home page.");
			return catFlag;
		} 
		logger.info("Successfully validated amazon logo in home page.");
		wrapper.click(driver, Locators.helloSignIn);
		logger.info("Successfully clicked on hello Sign In link at home page");
		Thread.sleep(SMALL_SLEEP);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.email, SMALL_SLEEP_SECONDS);
		if(!catFlag){
			logger.info("Failed to Locate email input box.");
			return catFlag;
		} 
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.email, userName);
		logger.info("Successfully entered email id in input box");
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.pwd, SMALL_SLEEP_SECONDS);
		if(!catFlag){
			logger.info("Failed to Locate email input box.");
			return catFlag;
		} 
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.pwd, pwd);
		logger.info("Successfully entered pwd in input box");
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.signInSubmit, SMALL_SLEEP_SECONDS);
		if(!catFlag){
			logger.info("Failed to validate sign In Submit button");
			return catFlag;
		} 
		logger.info("Successfully validated sign In Submit button");
		wrapper.click(driver, Locators.signInSubmit);
		logger.info("Successfully clicked on sign in submit button");
		String title = driver.getTitle();
		if(title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
			logger.info("Successfully validated the title as : "+ title);
		}else {
			logger.info("Not validated the title");
		}
		return catFlag;
	}
	
	public boolean selectFirstAvailableHeadphoneAndAddToCart(WebDriver driver, Logger logger) throws Exception{
		boolean flag = false;
		logger.info("Validating departments Section");
		flag = wrapper.waitUntilDisplayed(driver, Locators.departments, SMALL_SLEEP_SECONDS);
		if(!flag){
			logger.info("Failed to validate departments section");
			return flag;
		} 
		logger.info("Successfully validated departments section");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Departments')]/span[@class='nav-icon nav-arrow']"));
        action.moveToElement(ele).build().perform();
        flag = wrapper.waitUntilDisplayed(driver, Locators.electronics, SMALL_SLEEP_SECONDS);
		if(!flag){
			logger.info("Failed to validate electronics from the dropdown");
			return flag;
		} 
		logger.info("Successfully validated electronics from the dropdown");
		wrapper.click(driver, Locators.electronics);
		logger.info("Successfully clicked on electronics from the dropdown.");
		 flag = wrapper.waitUntilDisplayed(driver, Locators.headphones, SMALL_SLEEP_SECONDS);
			if(!flag){
				logger.info("Failed to validate headphones.");
				return flag;
			} 
			logger.info("Successfully validated headphones.");
			wrapper.click(driver, Locators.headphones);
			logger.info("Successfully clicked on headphones.");
			flag = wrapper.waitUntilDisplayed(driver, Locators.firstHeadPhone, MEDIUM_SLEEP_SECONDS);
			if(!flag){
				logger.info("Failed to validate first Head Phone.");
				return flag;
			} 
			logger.info("Successfully validated first Head Phone.");
			wrapper.click(driver, Locators.firstHeadPhone);
			logger.info("Successfully clicked on first head phone.");
			flag = wrapper.waitUntilDisplayed(driver, Locators.addToCartButton, MEDIUM_SLEEP_SECONDS);
			if(!flag){
				logger.info("Failed to validate add to cart button.");
				return flag;
			} 
			logger.info("Successfully validated add to cart button.");
			wrapper.click(driver, Locators.addToCartButton);
			logger.info("Successfully clicked on add to cart button.");
			flag = wrapper.waitUntilDisplayed(driver, Locators.AddToCartSuccessText, MEDIUM_SLEEP_SECONDS);
			if(!flag){
				logger.info("Failed to validate add to cart success text.");
				return flag;
			} 
			logger.info("Successfully validated add to cart  success text.");
			String successText = wrapper.getText(driver, Locators.AddToCartSuccessText);
			if(successText.equals("Added to Cart")) {
				logger.info("Successfully validated add to cart success text : "+ successText);
			}else {
				logger.info("Not validated validated add to cart success text");
			}
		return flag;
	}
	
}