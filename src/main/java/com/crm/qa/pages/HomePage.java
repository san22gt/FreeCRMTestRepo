package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;
import com.sun.org.apache.regexp.internal.recompile;

import bsh.This;

public class HomePage extends TestBase {
	// CacheLookup - it will be stored in cache - it speeds up the framework
	// If it is taking from cache i.e(100 times same elemrnt), the prob here is,
	// If element is changed or page is refreshed or DOM property changed, STALE ELEMENT EXCEPTION will be thrown
	// Interview Que - how do you speed up
	
	@FindBy(xpath="//td[contains(@class,'headertext') and contains(@align,'left') and contains(text(),'SANTHOSH T')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	// Initializing the page objects
	public HomePage() {
		
		PageFactory.initElements(driver, this); // this pointing to current class object 
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public Contacts clickOnContacts() {
		contactsLink.click();
		return new Contacts();
	}

	public Deals clickOnDeals() {
		dealsLink.click();
		return new Deals();
		
	}
	
	public Boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public TasksPage clickOnTasks() {
		tasksLink.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContact() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();//.build().perform() is compulsary fir actions class
		newContactLink.click();
		
	}
	
}
