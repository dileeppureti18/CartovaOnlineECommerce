package com.adactinhotelapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.TestCasesPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class TestCasesTest extends BaseTest {

	@Description("Testing Test cases page functionality")
	@Epic("TC08")
	@Test()
	public void testCases() {
		TestCasesPage testCasesPage = new TestCasesPage(driver);
		Assert.assertEquals(testCasesPage.getTitle(), AppConstants.HOME_PAGE);
		testCasesPage.clickingTestCasesTile();
		testCasesPage.closeTheAlert();
		Assert.assertEquals(testCasesPage.getTitle(), AppConstants.TEST_CASES_PAGE);
	}

}
