package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class ValidLoginPage extends BasePage {

	public ValidLoginPage(WebDriver driver) {
		super(driver);

		elementUtils = new ElementUtils(driver);
	}

	private ElementUtils elementUtils;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signUpOrLogin;

	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement loginHeader;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	private WebElement loggedInText;

	@FindBy(xpath = "//a[text()=' Delete Account']")
	private WebElement deleteAccount;

	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement accountDeletedText;

	public void clickSignupOrLogin() {
		signUpOrLogin.click();
	}

	public String getLoginHeaderText() {
		return loginHeader.getText();
	}

	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void closeTheAlert() {

		elementUtils.waitsForElementVisible(closeTheAlert);
		closeTheAlert.click();

	}

	public boolean isUserLoggedIn() {
		return loggedInText.isDisplayed();
	}

	public void deletingAccount() {
		deleteAccount.click();
	}

	public String checkingAccountDeletedText() {
		return accountDeletedText.getText();
	}

}
