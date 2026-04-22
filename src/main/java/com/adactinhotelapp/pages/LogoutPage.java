package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signOnOrLogin;

	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement accountText;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	private WebElement loggedInText;

	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement logOut;

	public void clickSignupOrLogin() {
		signOnOrLogin.click();
	}

	public String getLoginHeaderText() {
		return accountText.getText();
	}

	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void logOut() {
		logOut.click();

	}

}
