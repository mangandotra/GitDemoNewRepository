package com.test.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.w3c.dom.Text;

import com.test.setup.BrowserSetup;

public class GuruHomePage {
	
	WebDriver driver;
	public Properties prop;
	BrowserSetup browserSetup= new BrowserSetup();
	
	public GuruHomePage(WebDriver driver) throws IOException {
		this.driver=driver;
		prop=browserSetup.readDataFromPropertiesFile();
		
	}
	
	@FindBy(tagName="marquee")
	@CacheLookup
	WebElement guruhmpgMessage;
	
	public void verifyHomePageMessage() {
		String expected=prop.getProperty("guruhomepagemessage");
		String actual=guruhmpgMessage.getText();
		
		if(actual.equalsIgnoreCase(expected)) {
		System.out.println("Guru Home Page is open. Guru Home Page message is "+ actual);
		
		}
		else {
			System.out.println("Guru Home Page message not verified");
		}
		
	}
	
	//@FindBy(Text="New Customer")
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement newCustomer;
	
	
	
	public void clickNewCustomer() {
		newCustomer.click();
	}
	
	@FindBy(linkText ="Edit Customer")
	@CacheLookup
	WebElement editCustomer;
	
	public void clickEditCustomer() {
		editCustomer.click();
	}
	

}
