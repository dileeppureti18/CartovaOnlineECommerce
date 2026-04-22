package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.UserRegistrationPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class UserRegistrationTest extends BaseTest {

	@Description("This is for signing up for a new user registratio")
	@Epic("TC01")
	@Test(dataProvider = "getData")
	public void loginOrSignUp(HashMap<String, String> dataMap) {

		UserRegistrationPage page = new UserRegistrationPage(driver);
		Assert.assertEquals(page.getTitle(), AppConstants.E_Commerce_Home_Page);

		page.signUpOrLogin();
		Assert.assertEquals(page.getTitle(), AppConstants.HOME_PAGE);

		Assert.assertEquals(page.isNewUserSingUpDisplayed(), "New User Signup!");

		page.enterUsername(dataMap.get("Name"));

		page.enterUserEmail(dataMap.get("Email Address"));

		page.clickSubmit();

		Assert.assertEquals(page.isAccountInformationVisible(), "ENTER ACCOUNT INFORMATION");

		Assert.assertEquals(page.getTitle(), AppConstants.SIGN_UP_PAGE);

		page.selectMageGender();

		Assert.assertEquals(page.defaultName(dataMap.get("Name")), dataMap.get("Name"));

		Assert.assertEquals(page.getDefaultEmail(dataMap.get("Email Address")), dataMap.get("Email Address"));

		page.enterPassword(dataMap.get("Password"));

		page.enterDateOfBirth(dataMap.get("Date"), dataMap.get("Month"), dataMap.get("Year"));

		page.clickingOnNewsLetterCheckBox();
		page.clickingOnReceiveSpecialOfferCheckBox();

		page.firstName(dataMap.get("First name"));
		page.lastName(dataMap.get("Last name"));
		page.enterCompany(dataMap.get("Company"));
		page.enterAddress1(dataMap.get("Address 1"));
		page.enterAddress2(dataMap.get("Address 2"));
		page.selectCountry(dataMap.get("Country"));
		page.enterState(dataMap.get("State"));
		page.enterCity(dataMap.get("City"));
		page.enterZipCode(dataMap.get("Zipcode"));
		page.enterMobileNumber(dataMap.get("Mobile Number"));
		page.clickSubmitButton();

		Assert.assertEquals(page.checkingAccountCreatedText(), dataMap.get("Account Created"));
		page.clickContinueButton();
		page.clickingAlertClosing();
		Assert.assertEquals(page.checkingLoggedInAsName().trim(), dataMap.get("Logged In As"));
		page.clickingOnTheDeleteButton();
		Assert.assertEquals(page.checkingAccountDeletedText(), dataMap.get("Account Deleted"));
		page.clickingOnContinueButton();
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][1];
		HashMap<String, String> testData = ExcelUtils.getTestDataFromExcel("TC104");
		data[0][0] = testData;
		return data;

	}

}
