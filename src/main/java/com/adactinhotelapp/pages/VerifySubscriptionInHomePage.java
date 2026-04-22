package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class VerifySubscriptionInHomePage extends BasePage {

	private ElementUtils elementUtils;
	public VerifySubscriptionInHomePage(WebDriver driver) {
		super(driver);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement SubscribeText;

	@FindBy(xpath = "//input[@id='susbscribe_email']")
	private WebElement emailFiled;

	@FindBy(xpath = "//button[@id='subscribe']")
	private WebElement subscribeButton;

	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement successMessageText;

	public void scrollToSubscribeText() {

		Actions scrollTo = new Actions(driver);
		scrollTo.scrollToElement(SubscribeText);
	}

	public String getSubscriptionText() {
		return SubscribeText.getText();

	}

	public void enterEmailInEmailFiled(String email) {
		emailFiled.sendKeys(email);

	}

	public void clickSubmitButton() {
		subscribeButton.click();
	}

	public String getSuccessMessageText() {
		elementUtils.doGetElementText(successMessageText);
		return successMessageText.getText();
	}

}
