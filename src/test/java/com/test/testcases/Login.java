package com.test.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.test.pages.GuruHomePage;
import com.test.pages.LoginPage;
import com.test.pages.NewCustomerPage;
import com.test.setup.BrowserSetup;

public class Login {
	
	
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report;

	
	@BeforeTest
	public void openBrowser() throws IOException {
		System.out.println("openBrowser: Start method");
		
		//Load the driver
		
		BrowserSetup browserSetup = new BrowserSetup();
		prop = browserSetup.readDataFromPropertiesFile();
		driver =browserSetup.loadChromeDriver();
		
		/*
		//Get url from config file
		String url = prop.getProperty("url");
				
		
		if (url != null) {
			//Start the browser
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);			
		} else {
			System.out.println("openBrowser: URL is null");
		}
*/       
		
		//for reporting
		report = new ExtentReports();
	}
	
	@Test(priority=2)
	public void enterCredentialsSubmit() {
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		login.enterEmail();
		login.enterPassword();
		login.clickLogin();
	
	}
	
	@Test(priority=5)
	public void verifyGuruHomePageIsOpen() {
		GuruHomePage hp=PageFactory.initElements(driver, GuruHomePage.class);
		hp.verifyHomePageMessage();
		
	}
	
	@Test(priority=8)
	public void clickNewCustomerAndCreateNewCustomer() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("clickAndVerifyNewCustomer: start method");
		GuruHomePage hp=PageFactory.initElements(driver, GuruHomePage.class);
		hp.clickNewCustomer();
		//System.out.println("clickAndVerifyNewCustomer: new customer clicked");
		NewCustomerPage ncp=PageFactory.initElements(driver, NewCustomerPage.class);
		ncp.verifyNewCustomerPageIsOpen();
		ncp.enterCustomerName();
		ncp.selectGender();
		ncp.enterDob();
		ncp.enterAddress();
		ncp.enterCity();
		ncp.enterState();
		ncp.enterPin();
		ncp.enterPhoneNumber();
		ncp.enterEmailId();
		ncp.enterPassword();
		//ncp.submit();
		//ncp.getCustomerId();
		ncp.reset();
	}
	
	//1237 customer id
	//66259
	

}
