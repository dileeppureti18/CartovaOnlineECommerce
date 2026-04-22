package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.AllProductsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class AllProductsTestList extends BaseTest {

	@Description("Testing the list of Products and their details are displaying or not")
	@Epic("TC08")
	@Test
	public void allProducts() {

		AllProductsPage listOfProducts = new AllProductsPage(driver);

		Assert.assertEquals(listOfProducts.getTitle(), AppConstants.HOME_PAGE);
		listOfProducts.clickOnProducts();
		listOfProducts.closeTheAlert();
		Assert.assertEquals(listOfProducts.getAllProductsText(), AppConstants.ALL_Products);
		Assert.assertEquals(listOfProducts.getListOfAllProducts(), true);
		listOfProducts.clickingOnTheFirstDisplayedProduct();
		Assert.assertEquals(listOfProducts.getTitle(), AppConstants.PRODUCT_DETAILS_PAGE);
		Assert.assertEquals(listOfProducts.visibilityOfTheProductDetails(), true);
	}

}
