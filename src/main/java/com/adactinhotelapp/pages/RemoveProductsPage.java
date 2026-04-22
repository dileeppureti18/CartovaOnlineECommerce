package com.adactinhotelapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class RemoveProductsPage extends BasePage {

	private ElementUtils elementUtils;

	public RemoveProductsPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//div[@class='productinfo text-center']//a[text()='Add to cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
	private WebElement continueShoppingButton;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	private WebElement cartLink;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement removeProductIcon;

	@FindBy(xpath = "//a[normalize-space()='Blue Top']")
	private WebElement blueTopProductLink;

	public RemoveProductsPage addProductToCart(int index) {
		if (addToCartButtons == null || addToCartButtons.isEmpty()) {
			throw new IllegalStateException("No 'Add to cart' buttons found on this page");
		}
		if (index < 0 || index >= addToCartButtons.size()) {
			throw new IllegalArgumentException("Index " + index + " is out of bounds for 'Add to cart' buttons list");
		}

		WebElement target = addToCartButtons.get(index);
		elementUtils.scrollAndClick(target);
		return this;
	}
	
	public RemoveProductsPage clickContinueShopping() {
		elementUtils.waitForElementVisible(continueShoppingButton);
		elementUtils.clickWhenReady(continueShoppingButton);
		return this;
	}
	
	public void clickOnCartLink() {
		elementUtils.scrollUsingActionsClass(cartLink);
		elementUtils.clickWhenReady(cartLink);
	}
	
	public void clickRemoveProductIcon() {
		elementUtils.clickWhenReady(removeProductIcon);
	}
	
	public boolean isBlueTopProductLinkDisplayed() {
		return elementUtils.isElementDisplayed(blueTopProductLink);
	}

}
