package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class ExistingEmailRegisterValidationPage extends BasePage {


	public ExistingEmailRegisterValidationPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signUpOrLogin;

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement newUserSignUp;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement enterName;

	@FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
	private WebElement enterEmail;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement submit;

	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	private WebElement emailAdressErrorMessage;

	public void signUpOrLogin() {
		signUpOrLogin.click();
		ChainTestListener.log("Clicking on the signUp or Login button");
	}

	public String isNewUserSingUpDisplayed() {
		return newUserSignUp.getText();

	}

	public void enterUsername(String userName, String email) {
		enterName.sendKeys(userName);
		enterEmail.sendKeys(email);
		submit.click();
		ChainTestListener.log("Entering the New User Name");
	}

	public String getErrorMessage() {
		return emailAdressErrorMessage.getText();

	}

}
