package com.test.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BrowserSetup {
	
	//for reporting
	
	public static ExtentReports report;
	public static ExtentTest logger;
	public static long date=new Date().getTime();
	
	
	//for properties
	public static Properties prop = null;
	
	
	
	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		BrowserSetup.prop = prop;
	}

	public WebDriver loadChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Manvi\\Testing\\Chrome_102\\chromedriver_win32\\chromedriver.exe");	
		
		 WebDriver driver=new ChromeDriver();
		 
		driver.manage().window().maximize();
		
		//read data from properties file
		String url=prop.getProperty("url");
		
		if(url!=null) {
		driver.get(url);
		}
		else {
			System.out.println("loadChromeDriver: url is null");
		}
		
		//for reporting
		//System.getProperty("user.dir")+"/extentReports/"+date+"Automation.Report.html"
		report = new ExtentReports();
	
	
		
		
		return driver;
		
	}
	
	public Properties readDataFromPropertiesFile() throws IOException {
		FileInputStream fis;
		File file=new File("C:\\Manvi\\Testing\\Workspaces\\Learning\\regressiontesting\\config.properties");
		fis= new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		//System.out.println(prop);
		return prop;
	}

}
