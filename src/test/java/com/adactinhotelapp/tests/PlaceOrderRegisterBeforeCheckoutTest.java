package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.PlaceOrderRegisterBeforeCheckoutPage;
import com.adactinhotelapp.utils.DataGenerator;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class PlaceOrderRegisterBeforeCheckoutTest extends BaseTest {

	@Description("User registration check before checking out by placing the order")
	@Epic("TC15")
	@Test(dataProvider = "getTestData")
	public void placeOrderRegisterBeforeCheckout(HashMap<String, String> dataMap) {

		String name = DataGenerator.getRandomName();
		String address1 = DataGenerator.getRandomAddress();
		PlaceOrderRegisterBeforeCheckoutPage checkoutPage = new PlaceOrderRegisterBeforeCheckoutPage(driver);
		Assert.assertEquals(checkoutPage.getTitle(), AppConstants.HOME_PAGE);
		checkoutPage.clickingSignupButton();

		checkoutPage.enterUserDetails(name, DataGenerator.getRandomEmail());
		checkoutPage.selectGender();
		checkoutPage.enterDateOfBirth(dataMap.get("Date"), dataMap.get("Month"), dataMap.get("Year"));
		checkoutPage.clickingOnNewsLetterCheckBox();
		checkoutPage.clickingOnReceiveSpecialOfferCheckBox();
		checkoutPage.enterPassword(dataMap.get("Password"));
		checkoutPage.fillShippingAddress(DataGenerator.getRandomFirstName(), DataGenerator.getRandomLastName(),
				DataGenerator.getRandomCompanyName(), DataGenerator.getRandomAddress(),
				DataGenerator.getRandomAddress(), dataMap.get("Country"), DataGenerator.getRandomState(),
				DataGenerator.getRandomCity(), DataGenerator.getRandomZipCode(), DataGenerator.getRandomMobileNumber());
		checkoutPage.clickSubmitButton();

		Assert.assertEquals(checkoutPage.getAccountCreatedText(), AppConstants.ACCOUNT_CREATED);
		checkoutPage.clickContinueButton();
		Assert.assertEquals(checkoutPage.checkingLoggedInAsName().contains(name), true);
		checkoutPage.addingProductToCart();
		checkoutPage.clickingOnViewCart();
		Assert.assertEquals(checkoutPage.getTitle(), AppConstants.VIEW_CART);
		checkoutPage.clickingOnProceedToCheckout();
		Assert.assertEquals(checkoutPage.getDeliveryAddress().contains(address1), true);
		checkoutPage.enterTextInCommentBox(DataGenerator.getRandomComment());
		checkoutPage.enterCardDetails(DataGenerator.getRandomName(), DataGenerator.getRandomCardNumber(),
				DataGenerator.getRandomCVV(), DataGenerator.getRandomExpiryMonth(),
				DataGenerator.getRandomExpiryYear());
		checkoutPage.clickDeleteButton();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC104");
		data[0][0] = testData;
		return data;
	}

}
