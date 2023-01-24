package com.test.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.test.setup.BrowserSetup;

public class LoginPage {
	
	WebDriver driver;
	
	
	//for reporting
	
	public static String Logstatus=null;
	
	//for reporting
	
	
	public Properties prop;
	
	BrowserSetup browserSetup= new BrowserSetup();
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver=driver;
		prop=browserSetup.readDataFromPropertiesFile();
		
		//for reporting
		BrowserSetup.logger=BrowserSetup.report.createTest(this.getClass().getSimpleName());
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userId;
	
	public void enterEmail() {
		String email=prop.getProperty("email");
		userId.sendKeys(email);
		//for reporting
		//BrowserSetup.logger.log(null, null);
	}

	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	public void enterPassword() {
		String pswd=prop.getProperty("password");
		password.sendKeys(pswd);
	}
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginButton;
	
	public void clickLogin() {
		loginButton.click();
	}
}
