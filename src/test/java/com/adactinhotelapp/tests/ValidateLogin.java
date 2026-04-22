package com.adactinhotelapp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void validateLoginTest1()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
		
	}
	
	@Test
	public void validateLoginTest2()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz456");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
	}
	
	@Test
	public void validateLoginTest3()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz1212");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
	}
	
	@Test
	public void validateLoginTest4()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz1212");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz456");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
		
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
