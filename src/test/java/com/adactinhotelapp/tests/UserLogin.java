package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.ValidLoginPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class UserLogin extends BaseTest {

	@Description("Validating User login")
	@Epic("TC02")
	@Test(dataProvider = "getTestData")
	public void userLoginTest(HashMap<String, String> dataMap) {
		ValidLoginPage loginPage = new ValidLoginPage(driver);
		Assert.assertEquals(loginPage.getTitle(), AppConstants.HOME_PAGE);
		loginPage.login(dataMap.get("Email"), dataMap.get("Password"));
		Assert.assertEquals(loginPage.getLoginHeaderText(), AppConstants.LOGIN_TO_YOUR_ACCOUNT);
//		test.closeTheAlert();
		loginPage.isUserLoggedIn();
		loginPage.deletingAccount();
		Assert.assertEquals(loginPage.checkingAccountDeletedText(), AppConstants.ACCOUNT_DELETED);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC105");
		data[0][0] = testData;
		return data;

	}

}
