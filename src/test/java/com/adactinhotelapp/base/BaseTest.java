package com.adactinhotelapp.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.adactinhotelapp.factory.DriverFactory;
import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class BaseTest {

	protected WebDriver driver;
	DriverFactory driverFactory;

	@BeforeTest
	public void setUp() {
		// diverFactory=new DriverFactory();
		// prop=diverFactory.initProp();
		new DriverFactory().initProp();

	}

	@BeforeMethod
	public void appLaunch() {
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(DriverFactory.configProp);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		if (!result.isSuccess()) {
			ChainTestListener.embed(driverFactory.getScreenshotFile(), "image/png");
		}
//		driver.quit();

		ChainTestListener.log("Browser closed ...");
	}

	@AfterTest
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// driver.quit();
	}

}
