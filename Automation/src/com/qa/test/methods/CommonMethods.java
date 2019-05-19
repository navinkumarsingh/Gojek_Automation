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

	public boolean closeBrowser(WebDriver driver, Logger logger) throws Exception {
		boolean flag = true;
		logger.info("Closing Browser for Test Suite");
		driver.quit();
		return flag;

	}

	public boolean loginAndLogoutFromApplication(WebDriver driver, Logger logger, String userName, String pwd)
			throws Exception {
		boolean flag = false;
		logger.info("Validating amazon logo in home page");
		flag = wrapper.waitUntilDisplayed(driver, Locators.logo, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate amazon logo in home page.");
			return flag;
		}
		logger.info("Successfully validated amazon logo in home page.");
		wrapper.click(driver, Locators.helloSignIn);
		logger.info("Successfully clicked on hello Sign In link at home page");
		Thread.sleep(SMALL_SLEEP);
		flag = wrapper.waitUntilDisplayed(driver, Locators.email, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to Locate email input box.");
			return flag;
		}
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.email, userName);
		logger.info("Successfully entered email id in input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.pwd, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to Locate email input box.");
			return flag;
		}
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.pwd, pwd);
		logger.info("Successfully entered pwd in input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.signInSubmit, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate sign In Submit button");
			return flag;
		}
		logger.info("Successfully validated sign In Submit button");
		wrapper.click(driver, Locators.signInSubmit);
		logger.info("Successfully clicked on sign in submit button");
		String title = driver.getTitle();
		if (title.equals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
			logger.info("Successfully validated the title as : " + title);
		} else {
			logger.info("Not validated the title");
		}
		
		//############
		String cartCountNo = wrapper.getText(driver, Locators.cartCount);
		System.out.println(cartCountNo);
		if (!cartCountNo.equals("0")) {
			/*logger.info("Successfully validated cart count number : " + cartCountNo);
		} else {
			logger.info("Failed to validate cart count number as its not 2 :" +cartCountNo);
			flag = false;
			return flag;
		}
		if()*/
		flag = wrapper.waitUntilDisplayed(driver, Locators.cart, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate add to cart button.");
			return flag;
		}
		logger.info("Successfully validated add to cart button.");
		wrapper.click(driver, Locators.cart);
		logger.info("Successfully clicked on add to cart button.");
		
		flag = wrapper.waitUntilDisplayed(driver, Locators.delete, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate delete label");
			return flag;
		}
		logger.info("Successfully validated delete label.");
		wrapper.click(driver, Locators.delete);
		logger.info("Successfully deleted list");
		flag = wrapper.waitUntilDisplayed(driver, Locators.helloSignIn, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate hello Sign In section");
			return flag;
		}
		logger.info("Successfully validated hello Sign In section");
		Actions action = new Actions(driver);
		WebElement ele = driver
				.findElement(By.xpath("//span[contains(text(),'Hello,')]"));
		action.moveToElement(ele).build().perform();
		flag = wrapper.waitUntilDisplayed(driver, Locators.logout, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate sign out from the drop down");
			return flag;
		}
		logger.info("Successfully validated sign out from the drop down");
		String text = wrapper.getText(driver, Locators.logout);
		wrapper.click(driver, Locators.logout);
		Thread.sleep(MEDIUM_SLEEP_SECONDS);
		logger.info("Successfully logged out");
		driver.getTitle();
		return flag;
        }else {
        	flag = wrapper.waitUntilDisplayed(driver, Locators.helloSignIn, MEDIUM_SLEEP_SECONDS);
    		if (!flag) {
    			logger.info("Failed to validate hello Sign In section");
    			return flag;
    		}
    		logger.info("Successfully validated hello Sign In section");
    		Actions action = new Actions(driver);
    		WebElement ele = driver
    				.findElement(By.xpath("//span[contains(text(),'Hello,')]"));
    		action.moveToElement(ele).build().perform();
    		flag = wrapper.waitUntilDisplayed(driver, Locators.logout, MEDIUM_SLEEP_SECONDS);
    		if (!flag) {
    			logger.info("Failed to validate sign out from the drop down");
    			return flag;
    		}
    		logger.info("Successfully validated sign out from the drop down");
    		String text = wrapper.getText(driver, Locators.logout);
    		wrapper.click(driver, Locators.logout);
    		Thread.sleep(MEDIUM_SLEEP_SECONDS);
    		logger.info("Successfully logged out");
    		driver.getTitle();
    		return flag;
        }
	}
		

	public boolean selectFirstAvailableHeadphoneAddToCart(WebDriver driver, Logger logger, String userName, String pwd) throws Exception {
		boolean flag = false;
		flag = wrapper.waitUntilDisplayed(driver, Locators.email, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to Locate email input box.");
			return flag;
		}
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.email, userName);
		logger.info("Successfully entered email id in input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.pwd, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to Locate email input box.");
			return flag;
		}
		logger.info("Successfully validated email input box");
		wrapper.type(driver, Locators.pwd, pwd);
		logger.info("Successfully entered pwd in input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.signInSubmit, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate sign In Submit button");
			return flag;
		}
		logger.info("Successfully validated sign In Submit button");
		wrapper.click(driver, Locators.signInSubmit);
		logger.info("Successfully clicked on sign in submit button");
		flag = wrapper.waitUntilDisplayed(driver, Locators.departments, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate departments section");
			return flag;
		}
		logger.info("Successfully validated departments section");
		Actions action = new Actions(driver);
		WebElement ele = driver
				.findElement(By.xpath("//span[contains(text(),'Departments')]/span[@class='nav-icon nav-arrow']"));
		action.moveToElement(ele).build().perform();
		Thread.sleep(MEDIUM_SLEEP_SECONDS);
		flag = wrapper.waitUntilDisplayed(driver, Locators.electronics, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate electronics from the drop down");
			return flag;
		}
		logger.info("Successfully validated electronics from the drop down");
			wrapper.click(driver, Locators.electronics);
			logger.info("Successfully clicked on electronics from the drop down.");
		flag = wrapper.waitUntilDisplayed(driver, Locators.headphones, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate headphones.");
			return flag;
		}
		logger.info("Successfully validated headphones.");
		wrapper.click(driver, Locators.headphones);
		logger.info("Successfully clicked on headphones.");
		flag = wrapper.waitUntilDisplayed(driver, Locators.firstHeadPhone, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate first Head Phone.");
			return flag;
		}
		logger.info("Successfully validated first Head Phone.");
		wrapper.click(driver, Locators.firstHeadPhone);
		logger.info("Successfully clicked on first head phone.");
		flag = wrapper.waitUntilDisplayed(driver, Locators.addToCartButton, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate add to cart button.");
			return flag;
		}
		logger.info("Successfully validated add to cart button.");
		wrapper.click(driver, Locators.addToCartButton);
		logger.info("Successfully clicked on add to cart button.");
		flag = wrapper.waitUntilDisplayed(driver, Locators.addToCartSuccessText, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate add to cart success text.");
			return flag;
		}
		logger.info("Successfully validated add to cart  success text.");
		String successText = wrapper.getText(driver, Locators.addToCartSuccessText);
		if (successText.equals("Added to Cart")) {
			logger.info("Successfully validated add to cart success text : " + successText);
		} else {
			logger.info("Failed to validate add to cart success text");
		}
		
		return flag;
		}
	
	
	
	

	public boolean macBookProAddedToCart(WebDriver driver, Logger logger, String macBookPro) throws Exception {
		boolean flag = false;
		logger.info("Validating Mac Book Pro added to cart");
		flag = wrapper.waitUntilDisplayed(driver, Locators.searchInputBox, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate search input box");
			return flag;
		}
		logger.info("Successfully validated search input box");
		
		wrapper.type(driver, Locators.searchInputBox, macBookPro);
		logger.info("Successfully enter Mac Book Pro into search input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.submit, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to locate go.");
			return flag;
		}
		logger.info("Successfully located go");
		wrapper.click(driver, Locators.submit);
		logger.info("Successfully clicked on go after entering Mac Book Pro into search input box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.checkboxMacBookPro, LARGE_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate Brand Mac Book Pro checkbox.");
			return flag;
		}
		logger.info("Successfully validated Brand Mac Book Pro checkbox.");
		wrapper.click(driver, Locators.checkboxMacBookPro);
		logger.info("Successfully checked the MacBook Pro check box");
		flag = wrapper.waitUntilDisplayed(driver, Locators.secondMacBookPro, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate second Mac Book Pro in the list");
			return flag;
		}
		logger.info("Successfully validated second Mac Book Pro in the list");
		wrapper.click(driver, Locators.secondMacBookPro);
		
		logger.info("Successfully selected second Mac Book Pro in the list");
		WebElement ele = driver.findElement(By.id("quantity"));
		Select sel = new Select(ele);
		sel.selectByVisibleText("2");
        logger.info("Successfully Selected second dropdown from the dropdown list");
		flag = wrapper.waitUntilDisplayed(driver, Locators.addToCartButton, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate add to cart button.");
			return flag;
		}
		logger.info("Successfully validated add to cart button.");
		wrapper.click(driver, Locators.addToCartButton);
		logger.info("Successfully clicked on add to cart button.");
		flag = wrapper.waitUntilDisplayed(driver, Locators.addToCartSuccessText, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate add to cart success text.");
			return flag;
		}
		logger.info("Successfully validated add to cart  success text.");
		String successText = wrapper.getText(driver, Locators.addToCartSuccessText);
		if (successText.equals("Added to Cart")) {
			logger.info("Successfully validated add to cart success text : " + successText);
		} else {
			logger.info("Failed to validate add to cart success text");
			flag = false;
			return flag;
		}
		flag = wrapper.waitUntilDisplayed(driver, Locators.cartCount, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate cart count webelement");
			return flag;
		}
		logger.info("Successfully validated cart count webelement");
		String cartCountNo = wrapper.getText(driver, Locators.cartCount);
		System.out.println(cartCountNo);
		if (cartCountNo.equals("3")) {
			logger.info("Successfully validated cart count number : " + cartCountNo);
		} else {
			logger.info("Failed to validate cart count number as its not 3 :" +cartCountNo);
			flag = false;
			return flag;
		}
		return flag;
		
	}
	
	public boolean selectCartAndRemoveHeadphoneReduceMacQuantityAndCheckout(WebDriver driver, Logger logger) throws Exception {
		boolean flag = false;
		logger.info("Validating Cart And Remove Headphone");
		flag = wrapper.waitUntilDisplayed(driver, Locators.cartCount, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate cart count webelement");
			return flag;
		}
		logger.info("Successfully validated cart count webelement");
		wrapper.click(driver, Locators.cartCount);
		logger.info("Successfully clicked on cart");
		wrapper.waitUntilDisplayed(driver, Locators.headPhoneDelete, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate head phone delete webelement");
			return flag;
		}
		logger.info("Successfully validated head phone delete webelement");
		wrapper.click(driver, Locators.headPhoneDelete);
		Thread.sleep(LARGE_SLEEP_SECONDS);
		logger.info("Successfully deleted headphone from the list");
		WebElement ele1 = driver.findElement(By.name("quantity"));
		Select sel1 = new Select(ele1);
		sel1.selectByVisibleText("1");
		Thread.sleep(SMALL_SLEEP_SECONDS);
        logger.info("Successfully Selected first dropdown from the dropdown list");
        wrapper.waitUntilDisplayed(driver, Locators.checkout, MEDIUM_SLEEP_SECONDS);
		if (!flag) {
			logger.info("Failed to validate checkout webelement");
			return flag;
		}
		logger.info("Successfully validated checkout webelement");
		wrapper.click(driver, Locators.checkout);
		logger.info("Successfully clicked on the checkout");
		return flag;
		
	}
	
}