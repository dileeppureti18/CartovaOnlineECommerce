package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.ExistingEmailRegisterValidationPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class ExistingEmailRegisterTest extends BaseTest {
	
	@Description("TestAnnotations User with existing email")
	@Epic("TC05")
	@Test(dataProvider = "getTestData")
	public void registrationTest(HashMap<String, String> dataMap) {
		ExistingEmailRegisterValidationPage regPage = new ExistingEmailRegisterValidationPage(driver);
		Assert.assertEquals(regPage.getTitle(), AppConstants.HOME_PAGE);
		regPage.signUpOrLogin();
		regPage.isNewUserSingUpDisplayed();
		regPage.enterUsername(dataMap.get("Name"), dataMap.get("Email"));
		Assert.assertEquals(regPage.getErrorMessage(), AppConstants.EMAIL_ALREADY_EXISTS);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC107");
		data[0][0] = testData;
		return data;

	}

}
