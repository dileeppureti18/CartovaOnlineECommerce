package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class InvalidLoginPage extends BasePage {

	
	private ElementUtils elementUtils;

	public InvalidLoginPage(WebDriver driver) {
		super(driver);
		
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signOnOrLogin;

	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement accountText;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordFiled;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement errorValidation;

	public String getHomeTitle() {
		return getTitle();
	}

	public void clickSignupOrLogin() {
		signOnOrLogin.click();
	}

	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordFiled.sendKeys(password);
		elementUtils.clickWhenReady(loginButton);
	}

	public String errorValidaitonMessage() {
		return errorValidation.getText();
	}

}
