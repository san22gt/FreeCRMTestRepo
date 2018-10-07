package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	//creating constructor of current class (he ll tell why, check below)
	
	public LoginPageTest() {
	// First it will come here and call super class constructor, bcz we want initialize properties
	// before initialization method. So, have to call base class constructor	
		super(); 
	}
	
	// call initialization method from Testbase class
	@BeforeMethod
	public void setUp() {
		
		initialization();
		// creating object of LoginPage class
		loginPage = new LoginPage(); // so that we can access all the functions in this class
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		// non static method. so, obj.method
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		
		Boolean crmLogo = loginPage.validateCrmImage();
		Assert.assertTrue(crmLogo);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));// not understood
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

}
