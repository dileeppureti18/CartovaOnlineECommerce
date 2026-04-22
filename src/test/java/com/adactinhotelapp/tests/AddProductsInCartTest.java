package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.AddProductsInCartPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class AddProductsInCartTest extends BaseTest {

	@Description("Adding the products into the cart and validating their prices")
	@Epic("TC12")
	@Test
	public void addProductsInCart() {
		AddProductsInCartPage cartPageValidation = new AddProductsInCartPage(driver);
		Assert.assertEquals(cartPageValidation.getTitle(), AppConstants.HOME_PAGE);
		
		cartPageValidation.clickOnProductsTab();
		cartPageValidation.alertHandling();
		cartPageValidation.clickOnTheFirstProduct();
		cartPageValidation.clickingOnTheSecondProduct();
		cartPageValidation.clickOnViewCart();
		cartPageValidation.validateCartPrices();
	}

}
