package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.PlaceOrderRegisterWhileCheckoutPage;
import com.adactinhotelapp.utils.DataGenerator;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class PlaceOrderRegisterWithCheckoutTest extends BaseTest {

	@Description("Testing the place order and Register with checkout page")
	@Epic("TC14")
	@Test(dataProvider = "getData")
	public void placeOrderRegisterWithCheckout(HashMap<String, String> dataMap) {

		PlaceOrderRegisterWhileCheckoutPage checkoutPage = new PlaceOrderRegisterWhileCheckoutPage(driver);

		// Entering a Random Comments using StringBuilder class
//		String comment = checkoutPage.generateRandomComment(20);

		Assert.assertEquals(checkoutPage.getTitle(), AppConstants.HOME_PAGE);
		checkoutPage.clickAddToCart();
		checkoutPage.clickAddToCartSecondProduct();
		checkoutPage.clickCartButton();
		Assert.assertEquals(checkoutPage.getTitle(), AppConstants.VIEW_CART);
		checkoutPage.clickProceedToCheckout();
		checkoutPage.clickRegisterOrLogin();
		String randomName = DataGenerator.getRandomName();
		checkoutPage.enterUserDetails(randomName, DataGenerator.getRandomEmail());

		checkoutPage.clickOnSignUpButton();

		checkoutPage.selectGender();

		checkoutPage.enterPassword(dataMap.get("Password"));

		checkoutPage.enterDateOfBirth(dataMap.get("Date"), dataMap.get("Month"), dataMap.get("Year"));

		checkoutPage.clickingOnNewsLetterCheckBox();
		checkoutPage.clickingOnReceiveSpecialOfferCheckBox();

		checkoutPage.fillShippingAddress(dataMap);

		checkoutPage.clickSubmitButton();
		Assert.assertEquals(checkoutPage.checkingAccountCreatedText(), dataMap.get("Account Created"));
		checkoutPage.clickContinueButton();
		Assert.assertEquals(checkoutPage.checkingLoggedInAsName().contains(randomName), true);
		checkoutPage.clickCartButton();
		checkoutPage.clickProceedToCheckout();
		Assert.assertEquals(checkoutPage.getDeliveryAddress().contains(dataMap.get("Name")), true);
		Assert.assertEquals(checkoutPage.getDeliveryAddress().contains(dataMap.get("State")), true);
		Assert.assertEquals(checkoutPage.getDeliveryAddress().contains(dataMap.get("Mobile Number")), true);
//		Assert.assertEquals(checkoutPage.validateCartDetails(productName1, productName2), true);

		// Using Faker Class for random comment generation.
		checkoutPage.enterOrderComment(DataGenerator.getRandomComment());
		checkoutPage.clickOnPlaceOrder();
		checkoutPage.enterCardDetials(DataGenerator.getRandomName(), DataGenerator.getRandomCardNumber(),
				DataGenerator.getRandomExpiryMonth(), DataGenerator.getRandomExpiryYear(),
				DataGenerator.getRandomCVV());

		checkoutPage.clickOnplaceAndConfirmOrder();
		Assert.assertEquals(checkoutPage.getTextOfOrderPlaced(), AppConstants.ORDER_PLACED);
		checkoutPage.clickDeleteAccount();
		Assert.assertEquals(checkoutPage.getAccountDeletedText(), AppConstants.ACCOUNT_DELETED);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC104");
		data[0][0] = testData;
		return data;

	}

}
