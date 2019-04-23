package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;

public class ElectronicsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Headphones')]")
	WebElement HeadPhones;

	@FindBy(xpath = "//b[contains(text(),'Electronics')]")
	WebElement ElectonicsLable;

	@FindBy(xpath = "//input[@title='Add to Shopping Cart']")
	WebElement AddtoCart;
	
	@FindBy(xpath = "//a[@class='a-link-normal close-button']")
	WebElement CloseBtn;
	

	public boolean verifyCorrectUserName() {
		return ElectonicsLable.isDisplayed();
	}

}
