package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	// call initialization method from Testbase class
		@BeforeMethod
		public void setUp() throws InterruptedException {
			
			initialization();
			// creating object of LoginPage class
			loginPage = new LoginPage(); // so that we can access all the functions in this class
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			testUtil = new TestUtil();
			contactsPage = new Contacts();
			testUtil.switchToframe();
			contactsPage = homePage.clickOnContacts();
		}
		
	
		@Test
		public void verifyContactsPageLabelTest(){
			Assert.assertTrue(contactsPage.verifyContactLable(), "contact label is missing");
		}
		
		@Test
		public void selectContactTest() {
			contactsPage.selectContacts("Saravana Kumar");
		}
		
		@Test
		public void selectMultipleContactsTest() {
			contactsPage.selectContacts("Saravana Kumar");
			contactsPage.selectContacts("Test Test");

		}
		
		@DataProvider
		public Object[][] getTestData() {
			Object data[][] = TestUtil.getTestData("contacts");
			return data;
		}
		
		
		
		
		@Test(dataProvider="getTestData")
		public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
			homePage.clickOnNewContact();
			//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
			contactsPage.createNewContact(title, firstName, lastName, company);
		}
		
		
		
		
		@AfterMethod
		public void tearDown() throws InterruptedException {
			driver.quit();
		}
	
}
