package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.utils.ExcelUtils;

public class ValidateRegistrationUsingDataProviderExcel {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test(dataProvider="getTestData")
	public void validateRegistrationTest1(HashMap<String,String> dataMap)
	{
		driver.findElement(By.xpath("//a[text()='New User TestAnnotations Here']")).click();
		Assert.assertEquals(driver.getTitle(), dataMap.get("Expected Title "));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataMap.get("Username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(dataMap.get("Confirm Password"));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(dataMap.get("Full Name"));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(dataMap.get("Email Address"));
		driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(dataMap.get("Captcha Text"));
		
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		HashMap<String, String> testDataMap=ExcelUtils.getTestDataFromExcel("TC102");
		data[0][0]=testDataMap;
		return data;
		
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
