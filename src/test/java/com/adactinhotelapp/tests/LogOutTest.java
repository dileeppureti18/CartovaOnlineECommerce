package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LogoutPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class LogOutTest extends BaseTest {

	@Description("Testing the LogOut Functionality")
	@Epic("TC04")
	@Test(dataProvider = "getTestData")
	public void logOutTest(HashMap<String, String> dataMap) {
		LogoutPage logOut = new LogoutPage(driver);
		Assert.assertEquals(logOut.getTitle(), AppConstants.HOME_PAGE);
		logOut.clickSignupOrLogin();
		Assert.assertEquals(logOut.getLoginHeaderText(), AppConstants.LOGIN_TO_YOUR_ACCOUNT);
		logOut.login(dataMap.get("Email"), dataMap.get("Password"));
		logOut.logOut();
		Assert.assertEquals(logOut.getTitle(), AppConstants.LOG_IN_PAGE);

	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC105");
		data[0][0] = testData;
		return data;

	}

}
