package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.VerifyProductQuantityInCartPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class VerifyProductQuantityInCartTest extends BaseTest {

	@Description("Verifying the product quantity that is added into the cart is same or not")
	@Epic("TC13")
	@Test
	public void verifyProductQuantity() {

		int quantity = 4;
		VerifyProductQuantityInCartPage cartPageValidation = new VerifyProductQuantityInCartPage(driver);
		Assert.assertEquals(cartPageValidation.getTitle(), AppConstants.HOME_PAGE);
		cartPageValidation.clickOnViewProduct();
		Assert.assertEquals(cartPageValidation.getTitle(), AppConstants.PRODUCT_DETAILS_PAGE);
		cartPageValidation.setQuantity(quantity);
		cartPageValidation.clickOnAddToCartButton();
		cartPageValidation.clickOnViewCart();
		Assert.assertEquals(cartPageValidation.verifyProductDetails(quantity), true);
	}

}
