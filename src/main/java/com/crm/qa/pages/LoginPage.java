package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{

	// GENERAL - WE SHOULD CREATE INDEPENDENT TESTCASES AND CLASSES-THAT IS A GOOD PRACTICE IN PAGE OBJ MODEL & DATA DRIVEN FRAMEWORK
	// 1. After creating this class we are Extending base class
	// 2. We have to define the Object Repository/ PageFactory
	// Page Factory or Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	// 3. We have to initialize object repositories i.e.by creating constructor of this class
	// Initializing the page objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this); // this pointing to current class object 
		
	}
	
	// 4. define diff actions/functionalities
	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		// login page should return homepage class object(bcz navigating to homepage i.e next landing page obj)
		return new HomePage();
	}
	
}
