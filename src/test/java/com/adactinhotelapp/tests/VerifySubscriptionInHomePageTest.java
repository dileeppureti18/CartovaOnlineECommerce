package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.VerifySubscriptionInHomePage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class VerifySubscriptionInHomePageTest extends BaseTest {

	@Description("Testing the subscription page...")
	@Epic("TC10")
	@Test(dataProvider = "getTestData")
	public void verifySucbscriptionInHomepage(HashMap<String, String> dataMap) {
		VerifySubscriptionInHomePage subscriptionPage = new VerifySubscriptionInHomePage(driver);
		Assert.assertEquals(subscriptionPage.getTitle(), AppConstants.HOME_PAGE);
		subscriptionPage.scrollToSubscribeText();
		Assert.assertEquals(subscriptionPage.getSubscriptionText(), AppConstants.SUBSCRIPTION_TEXT);
		subscriptionPage.enterEmailInEmailFiled(dataMap.get("Email"));
		subscriptionPage.clickSubmitButton();
		Assert.assertEquals(subscriptionPage.getSuccessMessageText(), AppConstants.SUBSCRIPTION_SUCCESS_MESSAGE);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC106");
		data[0][0] = testData;
		return data;
	}

}
