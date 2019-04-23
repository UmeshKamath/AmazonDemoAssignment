package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	// Scenario 1. Perform a simple login and logout flow on the site
	@Test(priority=1)
	public void SignIn() throws InterruptedException {
		loginPage.ClickOnSignIn();	
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	//AmazonLogo Verification
	@Test(priority=2)
	public void loginPageLogoTest() throws InterruptedException {
		boolean logo = loginPage.validateAmazonLogo();
		Assert.assertTrue(logo);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
