package com.test.testcases;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf.List;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Manvi\\Testing\\Chrome_102\\chromedriver_win32\\chromedriver.exe");	
		
		 WebDriver driver=new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		int n=driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(n);
		WebElement w=driver.findElement(By.xpath("//*[@id=\"post-body-299858861183690484\"]/div/form/div[1]/text()[1]"));
		String s=w.getText();
		System.out.println(s);

	}

}
