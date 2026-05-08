package com.adactinhotelapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.SearchAndVerifyCartPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class SearchAndVerifyCartTest extends BaseTest {

	@Description("Here I'm testing the search box along with that I'm verifying the card and user")
	@Epic("TC20")
	@Test(dataProvider = "getData")
	public void testSearchAndVerifyCart(HashMap<String, String> dataMap) {

		SearchAndVerifyCartPage searchPage = new SearchAndVerifyCartPage(driver);
		searchPage.clickOnProductsLink();
		Assert.assertEquals(searchPage.getTitle(), AppConstants.ALL_PRODUCTS_PAGE);
		searchPage.scrollAndEnterProductName();
		Assert.assertEquals(searchPage.getSearchedProductsText(), AppConstants.SEARCHED_PRODUCTS);
		searchPage.searchedProducts();
		searchPage.ClickOnCartLink();
		Assert.assertTrue(searchPage.isProductInCart());
		searchPage.clickOnSignUpLoginLink();
		searchPage.login(dataMap.get("Email"), dataMap.get("Password"));
		searchPage.clickOnCartLink();
		Assert.assertTrue(searchPage.productsInCart());

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> test = ExcelUtils.getTestDataFromExcel("TC106");
		data[0][0] = test;
		return data;
	}

}
