package com.adactinhotelapp.factory;

import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.adactinhotelapp.exceptions.FrameworkException;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class DriverFactory {
	
	public WebDriver driver;
	public static Properties configProp;
	
	public WebDriver initDriver(Properties configProp)
	{
		String browserName=configProp.getProperty("browser");
		ChainTestListener.log("Starting browser  "+browserName);
		
		switch (browserName.toLowerCase()) {
		case "chrome" :
			ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("autofill.profile_enabled", false);
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);

		    options.setExperimentalOption("prefs", prefs);

		    driver = new ChromeDriver(options);

		    ChainTestListener.log("Chrome browser has been started");
		    break;

		case "firefox" :
			driver=new FirefoxDriver();
			
			break;
			
		case "edge" :
			driver=new EdgeDriver();
			
			break;
			
		default:
			
			FrameworkException fe=new FrameworkException("please pass the right browser ..choose chrome/firefox/edge");
			throw new FrameworkException("Invalid Browser Exception");
		}
		
		driver.get(configProp.getProperty("url"));
		ChainTestListener.log("App has been launched using url "+configProp.getProperty("url"));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public Properties initProp()
	{
		FileInputStream fis=null;
		try {
			  fis=new FileInputStream("src\\test\\resources\\config\\qa.config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configProp=new Properties();
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ChainTestListener.log("Properties file has been initialized");
		return configProp;
		
	}
	
	public  File getScreenshotFile() {
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return srcFile;
		}
	

}
