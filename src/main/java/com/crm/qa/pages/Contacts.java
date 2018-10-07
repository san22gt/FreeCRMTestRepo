package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class Contacts extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement first_Name;
	
	@FindBy(id = "surname")
	WebElement sur_Name;
	
	@FindBy(name="client_lookup")
	WebElement company_Name;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save' and @class='button']")
	WebElement save_Button;
	
	// 3. We have to initialize object repositories i.e.by creating constructor of
	// this class
	// Initializing the page objects
	public Contacts() {
		PageFactory.initElements(driver, this); // this pointing to current class object
	}

	public boolean verifyContactLable() {
		return contactsLabel.isDisplayed();
	}

	public void selectContacts(String contactName) {
		driver.findElement(By.xpath("//a[contains(text(),'" + contactName
				+ "')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
				.click();
	}
	
	public void createNewContact(String title, String f_Name, String l_Name,String comp_Name) {
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		first_Name.sendKeys(f_Name);
		sur_Name.sendKeys(l_Name);
		company_Name.sendKeys(comp_Name);
		save_Button.click();
	}

	
}
