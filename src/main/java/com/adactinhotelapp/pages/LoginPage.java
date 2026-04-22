package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class LoginPage extends BasePage {

	// elements or locators ==> WebElement(with PF) or By (w.o PF)

	// standard POM implementation :
	// By locators
	/*
	 * private final By usernameTextbox=By.xpath("//input[@name='username']");
	 * private final By passwordTextbox=By.xpath("//input[@name='password']");
	 * private final By loginButton=By.xpath("//input[@name='login']");
	 */

	// POM implementation using Page Factory: A more conveninent Implementation

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTExtbox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTExtbox;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// methods

	public void usernameTextbox(String text) {
		// elementUtils.getElement(usernameTextbox).sendKeys(text);
		usernameTExtbox.sendKeys(text);
		ChainTestListener.log("Entering text " + text + " into texbox usernameTextbox");

	}

	public void passwordTextbox(String text) {
		// elementUtils.getElement(passwordTextbox).sendKeys(text);
		passwordTExtbox.sendKeys(text);
		ChainTestListener.log("Entering text " + text + " into texbox passwordTExtbox");
	}

	public void loginButton() {
		// elementUtils.getElement(loginButton).click();
		loginButton.click();
		ChainTestListener.log("clicked login button ..");
	}

	public void doLogin() {
		// usernameTextbox(prop.getProperty("username"));
		// passwordTextbox(prop.getProperty("password"));
		usernameTextbox(configProp.getProperty("username"));
		passwordTextbox(configProp.getProperty("password"));
		loginButton();
	}

}
