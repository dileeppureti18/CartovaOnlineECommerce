package com.adactinhotelapp.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.factory.DriverFactory;

public class BasePage extends DriverFactory  {
	protected WebDriver driver;
	protected Properties prop;
	protected DriverFactory df;
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		df=new DriverFactory();
		prop=df.initProp();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
	

}
