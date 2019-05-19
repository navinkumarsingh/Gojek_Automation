package com.qa.test.locators;

public class Locators {

	public static String logo = "//span[@class='nav-sprite nav-logo-base']";
	public static String helloSignIn = "//span[contains(text(),'Hello,')]";
	public static String signIn = "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner']";
	public static String email = "//input[@id='ap_email']";
	public static String pwd = "//input[@id='ap_password']";
	public static String signInSubmit = "//input[@id='signInSubmit']";
	public static String logout = "//span[contains(text(),'Sign Out')]";
	public static String cartList = "//div[@data-name='Active Items']/div";
	public static String cartDeleteCount = "//div[@data-name='Active Items']/div//input[@value='Delete']";
	public static String departments = "//span[contains(text(),'Departments')]/span[@class='nav-icon nav-arrow']";
	public static String electronics = "//span[contains(text(),'Electronics')]";
	public static String headphones = "//span[contains(text(),'HEADPHONES')]";
	public static String firstHeadPhone = "//div[@data-index='0']//div[@class='sg-col-inner']//img";
	public static String addToCartButton = "//input[@id='add-to-cart-button']";
	public static String cart = "//span[contains(text(),'Cart')]";
	public static String addToCartSuccessText = "//h1[contains(text(),'Added to Cart')]";
	public static String delete = "//div[@data-name='Active Items']/div//input[@value='Delete']"; 
	public static String cartCount ="//span[@id='nav-cart-count']";
	public static String searchInputBox = "//input[@id='twotabsearchtextbox']";
	public static String submit = "//input[@value='Go']";
	public static String checkboxMacBookPro = "//li[@id='p_89/Macbook Pro']//i[@class='a-icon a-icon-checkbox']";
	public static String secondMacBookPro = "//img[@data-image-index='1']";
	public static String quantityDropdown = "//select[@id='quantity']";
	public static String selectQuantityTwo = "//div/div/ul/li/a[@id='quantity_1']";
	public static String headPhoneDelete = "//div[@data-item-count='2']//input[@value='Delete']";
	public static String quantity = "//select[@name='quantity']";
	public static String checkout =  "//input[@value='Proceed to checkout']";

}
