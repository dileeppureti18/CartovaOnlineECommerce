package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.listeners.RetryAnalyzer;
import com.adactinhotelapp.pages.BrandProducts;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class BrandProductsTest extends BaseTest {

	@Description("This is to verify that user can navigate to brand products page")
	@Epic("TC19 - Verify navigation to brand products page")

	@Test
	public void testBrandProducts() {
		BrandProducts brandProductsPage = new BrandProducts(driver);
		Assert.assertEquals(brandProductsPage.getTitle(), AppConstants.HOME_PAGE);
		brandProductsPage.clickOnProductsLink();
		brandProductsPage.switchToAdFrame();
		brandProductsPage.scrollToBrandProductsPanel();
		Assert.assertEquals(brandProductsPage.verifyBrandsSection(), true);
		brandProductsPage.clickOnHMBrandLink();
		Assert.assertEquals(brandProductsPage.getHMBrandproductsTitle(), AppConstants.HM_BRAND_PRODUCTS_TITLE);
		brandProductsPage.clickOnAllenSollyJuniorLink();
		Assert.assertEquals(brandProductsPage.getAllenSollyJuniorProductsTitle(), AppConstants.ALLEN_SOLLY_BRAND_PRODUCT_TITLE);

	}

}
