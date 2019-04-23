package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.Lists;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div//span[contains(text(),'Hello, Umesh')]")
	WebElement usernameLable;

	@FindBy(xpath = "//span[contains(text(),'Departments')]")
	WebElement Departments;
	
	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement Electronics;
	
	@FindBy(xpath = "//b[contains(text(),'Electronics')]")
	WebElement Electronicslabel;
			
	@FindBy(xpath ="//*[@id=\"leftNav\"]//li//a//span[contains(text(),'Headphones')]")
	WebElement Headphones;
	
	@FindBy(xpath ="//span[contains(text(),'Samsung Galaxy Buds, Bluetooth True Wireless Earbu')]")
	WebElement SamsungHeadphones;
	
	@FindBy(xpath ="//input[@id='add-to-cart-button']")
	WebElement AddtoCart;
	
	@FindBy(xpath ="//a[@id='attach-close_sideSheet-link']")
	WebElement CloseAddtoCart;
	
	@FindBy(xpath ="//input[@id='twotabsearchtextbox']")
	WebElement SearchBtn;
	
	

	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName() {
		return usernameLable.isDisplayed();
	}

	public void clickOnDepartment() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(Departments).build().perform();
		Electronics.click();
		Thread.sleep(2000);
	}
	public void clickOnHeadphone() throws InterruptedException {
		Headphones.click(); //Click on HeadPhone options
		Thread.sleep(2000);
	}
	public void clickOnSamsungHeadphone() {
		SamsungHeadphones.click(); // CLick on First Headphone options
	}
	public void clickOnCart() throws InterruptedException {
		AddtoCart.click();
		Thread.sleep(3000);  // As its demo project so I have used Thread.sleep but best practice is to use Dynamic wait/Explicit wait.
		CloseAddtoCart.click();
		Thread.sleep(3000); 
	}
	
	public void clickOnSearchPage() throws InterruptedException {
		SearchBtn.sendKeys("Macbook pro");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		Thread.sleep(3000);
	}
	
	public void selectDropDown() throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("quantity")));
		select.selectByValue("2");
		AddtoCart.click();
		Thread.sleep(3000);
	}
}
