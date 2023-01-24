package com.test.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test.setup.BrowserSetup;

public class NewCustomerPage {
	
	WebDriver driver;
	public Properties prop;
	BrowserSetup browserSetup= new BrowserSetup();
	
	public NewCustomerPage(WebDriver driver) throws IOException {
		this.driver=driver;
		prop=browserSetup.readDataFromPropertiesFile();
	}
	
	@FindBy(xpath="//p[contains(text(),'Add New Customer')]")
	@CacheLookup
	WebElement newCustomerPageMessage;
	
	public void verifyNewCustomerPageIsOpen() {
		System.out.println("verifyNewCustomerPageIsOpen: Start method");
		String expected=prop.getProperty("newcustomerpagemessage");
		//System.out.println(expected);
		String actual=newCustomerPageMessage.getText();
		
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println("New Customer page is open: "+actual);
		}
		else {
			System.out.println("New Customer page message not verified");
		}
	}
	
	@FindBy(name="name")
	@CacheLookup
	WebElement customerName;
	
	public void enterCustomerName() {
		customerName.sendKeys(prop.getProperty("customername"));
	}
	
	@FindBy(xpath="//input[@value='m']")
	@CacheLookup
	WebElement genderMale;
	
	@FindBy(xpath="//input[@value='f']")
	@CacheLookup
	WebElement genderFemale;
	
	public void selectGender() {
		String gender=prop.getProperty("customergender");
		
		if(gender!=null) {
		
		if(gender.equalsIgnoreCase("male")) {
			genderMale.click();
		}
		else if(gender.equalsIgnoreCase("female")) {
			genderFemale.click();
		}
		}
		else {
			System.out.println("Gender is null");
		}
	}
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement dob;
	
	public void enterDob() {
		String dateOfBirth=prop.getProperty("dob");
		//dob.click();
		dob.sendKeys(dateOfBirth);
	}
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	public void enterAddress() {
		String addr=prop.getProperty("address");
		address.sendKeys(addr);
	}
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	public void enterCity() {
		city.sendKeys(prop.getProperty("city"));
	}

	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	public void enterState() {
		state.sendKeys(prop.getProperty("state"));
	}
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pin;
	
	public void enterPin() {
		pin.sendKeys(prop.getProperty("pin"));
	}
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement phoneNumber;
	
	public void enterPhoneNumber() {
		phoneNumber.sendKeys(prop.getProperty("phonenumber"));
	}
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailId;
	
	public void enterEmailId() {
		emailId.clear();
		emailId.sendKeys(prop.getProperty("emailId"));
	}
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	public void enterPassword() {
		password.sendKeys(prop.getProperty("password"));
	}
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement submit;
	
	public void submit() {
		submit.click();
	}
	
	@FindBy(name="res")
	@CacheLookup
	WebElement reset;
	
	public void reset() {
		reset.click();
	}
	
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement customerId;
	
	public void getCustomerId() {
		String customerID= customerId.getText();
		System.out.println("Customer is created. Customer id is "+customerID);
	}

}
