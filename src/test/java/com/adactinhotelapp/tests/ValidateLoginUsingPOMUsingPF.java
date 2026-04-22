package com.adactinhotelapp.tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class ValidateLoginUsingPOMUsingPF extends BaseTest {
	
	@Description("This is for validating Login using valid credentials")
	@Epic("ADA-1 Authentication")
	@Test(dataProvider = "getTestData")
	public void validateLoginTest(HashMap<String, String> dataMap)
	{
		LoginPage lp=new LoginPage(driver);
		// LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.usernameTextbox(dataMap.get("Username"));
		lp.passwordTextbox(dataMap.get("Password"));
		lp.loginButton();
		AssertJUnit.assertEquals(lp.getTitle(), AppConstants.SEARCH_HOTEL_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		HashMap<String, String> testDataMap=ExcelUtils.getTestDataFromExcel("TC101");
		data[0][0]=testDataMap;
		return data;
		
	}

}
