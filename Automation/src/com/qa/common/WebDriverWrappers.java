package com.qa.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qa.test.locators.Locators;

public class WebDriverWrappers {

public WebElement getWebElement(WebDriver driver, String locator) throws Exception {
		
		return driver.findElement(By.xpath(locator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String locator) throws Exception {
		
		return driver.findElements(By.xpath(locator));
	}
	
	
	public int getsize(WebDriver driver, String locator) throws Exception{
		return driver.findElements(By.xpath(locator)).size();
	}
	
	
	


	public void click(WebDriver driver, String locator) throws Exception {
		
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void click(WebElement we) throws Exception {
		
		we.click();
	}
	
	public void doubleClick(WebDriver driver, String locator) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(locator))).doubleClick().perform();
	}
	
	
	
	public void doubleClick(WebDriver driver, WebElement we) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(we).doubleClick().perform();
	}
	
	public void type(WebDriver driver, String locator, String inputValue) throws Exception {
		
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(inputValue);
	}
	
	public void sendKeys(WebDriver driver, String locator, String inputValue) throws Exception{
		driver.findElement(By.xpath(locator)).sendKeys(inputValue);
	}
	
	public String getTitle(WebDriver driver, String locator, String text) throws Exception{
		return driver.findElement(By.xpath(locator)).getText();
		
		
	}
	
	
	
	
	
	public void selectByVisibleText(WebDriver driver, String locator, String text) throws Exception {
		Select sel = new Select(driver.findElement(By.xpath(locator)));
		sel.selectByVisibleText(text);
	}
	
	public String getText(WebDriver driver, String locator) throws Exception {
		return driver.findElement(By.xpath(locator)).getText();
	}
	
	public String getText(WebElement we) throws Exception {
		return we.getText();
	}
	
	public String getAttribute(WebDriver driver, String locator, String attribute) throws Exception {
		return driver.findElement(By.xpath(locator)).getAttribute(attribute);
	}
	

	public void check(WebDriver driver, String locator) throws Exception {
		if(!driver.findElement(By.xpath(locator)).isSelected()){
			driver.findElement(By.xpath(locator)).click();
		}
	}
	
	public void uncheck(WebDriver driver, String locator) throws Exception {
		
		if(driver.findElement(By.xpath(locator)).isSelected()){
			driver.findElement(By.xpath(locator)).click();
		}
	}
	
	public boolean isDisplayed(WebDriver driver, String locator) throws Exception {
		
			return driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
	public boolean isEnabled(WebDriver driver, String locator) throws Exception {
		
		return driver.findElement(By.xpath(locator)).isEnabled();
}
	
	public boolean waitUntilDisplayed(WebDriver driver, String locator, int seconds) throws Exception {
		boolean wflag = false;
		WebElement we;
		for(int i=0; i < seconds; i++){
			try{
				we = getWebElement(driver, locator);
				if((we.isDisplayed()) && (we.getSize().getWidth() > 0)){
					return true;
				}
					
			} catch(Exception e){
				
			}
			Thread.sleep(1000);
		}
		return wflag;
	}
	
	public boolean waitUntilEnabled(WebDriver driver, String locator, int seconds) throws Exception {
		boolean wflag = false;
		
		for(int i=0; i < seconds; i++){
			if( !driver.findElement(By.xpath(locator)).isEnabled()  ) {
				Thread.sleep(1000);
			} else {
				wflag = true;
				break;
			}
		}
		return wflag;
	}
public boolean selectIndividualSubscriber(WebDriver driver, String locator, String SubscriberMdn) throws Exception {
	boolean cFalg = false;
	
	List<WebElement> listOfSubsriber = getWebElements(driver, locator);
	if (driver.findElements(By.xpath(locator)).size()==1){
		listOfSubsriber.get(0).click();
		//Thread.sleep(MEDIUM_SLEEP);
		cFalg = true;
	} 
	else {
		for(WebElement we:listOfSubsriber){
			if(we.getAttribute("mdn").equalsIgnoreCase(SubscriberMdn)){
				we.click();
				cFalg= true;
			}	
		}
	}
	
	return cFalg;
	}

	public void clear(WebDriver driver, String locator) throws Exception {
		driver.findElement(By.xpath(locator)).clear();
		
		// TODO Auto-generated method stub
		
	}
	public void changeDropDown(WebDriver driver, String locator,String filter) throws Exception {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath(filter))).perform();
	driver.findElement(By.xpath(locator)).click();
	}

public int getSize(WebDriver driver, String locator) throws Exception {
	return driver.findElements(By.xpath(locator)).size();
}
}
