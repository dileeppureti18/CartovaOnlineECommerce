package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.RemoveProductsPage;
import com.aventstack.chaintest.plugins.ChainTestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class RemoveProductsTest extends BaseTest {

	@Description("Test to verify that a user can remove products from the cart successfully")
	@Epic("TC17")
	@Test
	public void testRemoveProductsFromCart() {
		ChainTestListener.log("Test Start: testRemoveProductsFromCart");

		RemoveProductsPage removeProductsPage = new RemoveProductsPage(driver);
		ChainTestListener.log("Action: Initialized RemoveProductsPage");

		String homeTitle = removeProductsPage.getTitle();
		ChainTestListener.log("State: Home page title returned: " + homeTitle);
		Assert.assertEquals(homeTitle, AppConstants.HOME_PAGE);
		ChainTestListener.log("Assert: Home page title verified");

		removeProductsPage.addProductToCart(1) // Add first product to cart
				.clickContinueShopping() // Continue shopping to add more products
				.addProductToCart(2) // Add second product to cart
				.clickContinueShopping().clickOnCartLink(); // Go to cart page

		Assert.assertEquals(removeProductsPage.getTitle(), AppConstants.VIEW_CART);
		removeProductsPage.clickRemoveProductIcon();
		Assert.assertEquals(removeProductsPage.isBlueTopProductLinkDisplayed(), false);

	}

}