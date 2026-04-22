package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.listeners.RetryAnalyzer;
import com.adactinhotelapp.pages.CategoryProductsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class CategoryProductsTest extends BaseTest {

	@Description("Verify that category products are displayed correctly when a category is selected")
	@Epic("TC18")

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testCategoryProducts() {
		CategoryProductsPage categoryPage = new CategoryProductsPage(driver);
		Assert.assertEquals(categoryPage.isCategoryProductsPanelDisplayed(), true);
		categoryPage.clickOnWomenCategory();
		categoryPage.clickOnDressCategory();
		Assert.assertEquals(categoryPage.getCategoryProductHeaderText(), AppConstants.WOMEN_DRESS_CATEGORY);
		categoryPage.clickOnMenCategoryLink();
		categoryPage.clickOnJeansCategoryLink();
		Assert.assertEquals(categoryPage.getJeansCategoryHeaderText(), AppConstants.MEN_JEANS_CATEGORY);

	}

}
