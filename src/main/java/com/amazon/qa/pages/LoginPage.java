package com.amazon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"nav-signin-tooltip\"]//a//span[contains(text(),'Sign in')]")
	WebElement SignInBtn;
	
	@FindBy(name="email")
	WebElement EmailAdd;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement Password;
		
	@FindBy (xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement AmzLogo;
	
	@FindBy (xpath ="//input[@id='signInSubmit']")
	WebElement SignIn;
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	
		//Actions:
			public boolean validateAmazonLogo() throws InterruptedException{
			Thread.sleep(3000); // As its demo project so I have used Thread.sleep but in best practice is to use Dynamic wait/Explicit wait.
			return AmzLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) {
			EmailAdd.sendKeys(un);
			Password.sendKeys(pwd);
			//loginBtn.click();
			SignIn.click();
			return new HomePage();
		}
		public void ClickOnSignIn() throws InterruptedException {
			Thread.sleep(2000);
			SignInBtn.click();
		
		}
		
}
