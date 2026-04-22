package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.ContactUsPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class ContactUsTest extends BaseTest {

	@Description("Testing the contact Us page with valid data")
	@Epic("TC06")
	@Test(dataProvider = "getTestData")
	public void contactUs(HashMap<String, String> dataMap) {
		ContactUsPage contactPage = new ContactUsPage(driver);
		Assert.assertEquals(contactPage.getTitle(), AppConstants.HOME_PAGE);
		contactPage.clickContactUs();
		Assert.assertEquals(contactPage.getGetInTouchText(), AppConstants.GET_IN_TOUCH);
		contactPage.enterName(dataMap.get("Name"), dataMap.get("Email"), dataMap.get("Subject"), dataMap.get("Message"),
				dataMap.get("FileName"));
		contactPage.clickSubmitAndAcceptAlert();
		Assert.assertEquals(contactPage.getSuccessText(), AppConstants.SUCCESS_TEXT);
		contactPage.clickHomeButton();
		contactPage.closeTheAlert();
//		contactPage.clickCloseButton();
		Assert.assertEquals(contactPage.getTitle(), AppConstants.CONTACT_US);

	}

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC107");
		data[0][0] = testData;
		return data;

	}

}
