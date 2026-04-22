package com.adactinhotelapp.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.exceptions.FrameworkException;
import com.adactinhotelapp.utils.ElementUtils;

public class SubscriptionInCartPage extends BasePage {

	private ElementUtils elementUtils;

	public SubscriptionInCartPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	private WebElement cartTab;

	@FindBy(xpath = "//h2[text()='Subscription']")
	private WebElement subscriptionHeader;

	@FindBy(xpath = "//input[@id='susbscribe_email']")
	private WebElement emailField;

	@FindBy(xpath = "//button[@id='subscribe']")
	private WebElement subscribeButton;

	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement successMessageText;

	public void clickOnCartTab() {
		try {
			elementUtils.clickWhenReady(cartTab);
		} catch (NoSuchElementException e) {
			throw new FrameworkException("Element not found to click" + e);
		}

	}

	public void scrollToBottom() {
		elementUtils.scrollToTheBottom();
	}

	public String getSubscriptionText() {

		return elementUtils.doGetElementText(subscriptionHeader);

	}

	public void enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);

	}

	public void clickSubmitButton() {
		elementUtils.clickWhenReady(subscribeButton);
	}

	public String getSuccessMessageText() {
		elementUtils.doGetElementText(successMessageText);
		return successMessageText.getText();
	}

}
