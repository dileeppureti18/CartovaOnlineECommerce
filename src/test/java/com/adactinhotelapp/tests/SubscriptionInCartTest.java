package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.SubscriptionInCartPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SubscriptionInCartTest extends BaseTest {

	@Description("Testing Subscription use case in Cart Page")
	@Epic("TC11")
	@Test(dataProvider = "getTestData")
	public void subscriptionInCard(HashMap<String, String> dataMap) {

		SubscriptionInCartPage cartPage = new SubscriptionInCartPage(driver);
		Assert.assertEquals(cartPage.getTitle(), AppConstants.HOME_PAGE);
		cartPage.clickOnCartTab();
		cartPage.scrollToBottom();
		Assert.assertEquals(cartPage.getSubscriptionText(), AppConstants.SUBSCRIPTION_TEXT);
		cartPage.enterEmail(dataMap.get("Email"));
		cartPage.clickSubmitButton();
		Assert.assertEquals(cartPage.getSuccessMessageText(), AppConstants.SUBSCRIPTION_SUCCESS_MESSAGE);
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC106");
		data[0][0] = testData;
		return data;

	}

}
