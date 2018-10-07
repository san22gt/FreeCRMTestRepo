package com.crm.qa.testcases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contactsPage;

	public HomePageTest() {

		super();
	}

	// test cases should be seperated -- independent with each other
	// before each test case- launch the browser and login
	// @test - execute the test case
	// After each test case close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		// creating object of LoginPage class
		loginPage = new LoginPage(); // so that we can access all the functions in this class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new Contacts();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title is not matched");//message will be printed only when the test case is failed
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToframe();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
	
    	testUtil.switchToframe(); // commenting for contactpagetest.java
		contactsPage  = homePage.clickOnContacts();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
