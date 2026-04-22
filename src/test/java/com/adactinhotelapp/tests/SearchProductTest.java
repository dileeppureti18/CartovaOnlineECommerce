package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.SearchProductPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SearchProductTest extends BaseTest {

	@Description("Testing the Search Product page...")
	@Epic("TC09")
	@Test
	public void searchProduct() {

		SearchProductPage searchProductPage = new SearchProductPage(driver);
		Assert.assertEquals(searchProductPage.getTitle(), AppConstants.HOME_PAGE);
		searchProductPage.clickOnProducts();
		searchProductPage.closeTheAlert();
		Assert.assertEquals(searchProductPage.getAllProductsText(), AppConstants.ALL_Products);
		searchProductPage.sendSearchProductName("Tshirt");
		Assert.assertEquals(searchProductPage.getSearchedProductsText(), AppConstants.SEARCHED_PRODUCTS);
		Assert.assertEquals(searchProductPage.getListOfSearchedProducts(), true);
	}

}
