package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.CheckoutLoginPage;
import com.adactinhotelapp.utils.DataGenerator;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class CheckoutLoginTest extends BaseTest {

	@Description("Test to verify that a user can log in, add products to the cart, and complete the checkout process successfully.")
	@Epic("TC16 - Checkout and Login Flow")
	@Test(dataProvider = "getData")
	public void testCheckoutLoginFlow(HashMap<String, String> dataMap) {

		CheckoutLoginPage checkoutLoginPage = new CheckoutLoginPage(driver);
		Assert.assertEquals(checkoutLoginPage.getTitle(), AppConstants.HOME_PAGE);
		checkoutLoginPage.clickSignupLoginLink();
		checkoutLoginPage.enterLoginDetails(dataMap.get("Email"), dataMap.get("Password"));
		
		Assert.assertEquals(checkoutLoginPage.getLoggedInAsUsername(), dataMap.get("Logged in As"));
		checkoutLoginPage.clickAddToCartForProduct(1);
		checkoutLoginPage.clickViewCartButton();
		Assert.assertEquals(checkoutLoginPage.getTitle(), AppConstants.VIEW_CART);
		checkoutLoginPage.clickProceedToCheckoutButton();
		Assert.assertTrue(checkoutLoginPage.getDeliveryAddress().contains("sdfkj"));
		checkoutLoginPage.enterOrderCommentsAndPlaceOrder(DataGenerator.getRandomComment());
		checkoutLoginPage.enterPaymentDetailsAndPay(
				DataGenerator.getRandomName(),
				DataGenerator.getRandomCardNumber(),
				DataGenerator.getRandomExpiryMonth(),
				DataGenerator.getRandomExpiryYear(),
				DataGenerator.getRandomCVV()
		);
		Assert.assertEquals(checkoutLoginPage.getSuccessMessage(), AppConstants.ORDER_PLACED);
		
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC106");
		data[0][0] = testData;
		return data;

	}

}

