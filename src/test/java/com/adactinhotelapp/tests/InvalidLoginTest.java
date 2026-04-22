package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.InvalidLoginPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class InvalidLoginTest extends BaseTest {

	@Description("Testing with the invalid credentials to login")
	@Epic("TC03")
	@Test(dataProvider = "getTestData")
	public void invalidLogin(HashMap<String, String> dataMap) {
		InvalidLoginPage invalidLogin = new InvalidLoginPage(driver);
		Assert.assertEquals(invalidLogin.getTitle(), AppConstants.HOME_PAGE);
		invalidLogin.clickSignupOrLogin();
		invalidLogin.login(dataMap.get("Email"), dataMap.get("Password"));
		Assert.assertEquals(invalidLogin.errorValidaitonMessage(), AppConstants.INVALIDCREDENTIALS);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC106");
		data[0][0] = testData;
		return data;
	}

}
