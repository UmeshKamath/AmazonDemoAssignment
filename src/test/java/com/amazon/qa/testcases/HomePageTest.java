package com.amazon.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		loginPage.ClickOnSignIn();	
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * @Test(priority=1) public void verifyHomePageTitleTest() { boolean
	 * homePageTitle = homePage.verifyCorrectUserName();
	 * Assert.assertEquals(homePageTitle, "Hello, Umesh"); }
	 */
	@Test
	public void clickOnDeparatment() throws InterruptedException {
		homePage.clickOnDepartment();//Select Departments section > Electronics > Headphones > Select first available headphone and Add to cart. 
		homePage.clickOnHeadphone();
		homePage.clickOnSamsungHeadphone();
		homePage.clickOnCart();
		homePage.clickOnSearchPage();
		driver.findElement(By.xpath("//*[@id=\"pdagDesktopSparkleAsinsContainer\"]//*[contains(text(),'Apple MacBook Pro (13\" Retina, Touch Bar, 2.3GHz Q')] ")).click();	
		Thread.sleep(3000);
		homePage.selectDropDown();
		driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-label='Delete Samsung Galaxy Buds, Bluetooth True Wireless Earbuds (Wireless Charging Case Included), Black - US Version with Warranty']")).click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		select.deselectByValue("1");
		driver.findElement(By.xpath("//input[@name='proceedToCheckout']")).click();	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
