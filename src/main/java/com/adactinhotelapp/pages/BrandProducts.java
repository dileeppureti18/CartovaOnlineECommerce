package com.adactinhotelapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class BrandProducts extends BasePage {

	private ElementUtils elementUtils;

	public BrandProducts(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement productsLink;

	@FindBy(xpath = "//iframe[@id='aswift_3']")
	private WebElement adFrame;

	@FindBy(xpath = "//div[@class='close-button']")
	private WebElement adCloseButton;

	@FindBy(xpath = "//div[@class='col-sm-3']")
	private WebElement brandProductsPanel;

	@FindBy(xpath = "//div[@class='brands-name']//ul/li")
	private List<WebElement> listOfBrands;

	@FindBy(xpath = "//a[text()='H&M']")
	private WebElement hmBrandLink;

	@FindBy(xpath = "//h2[normalize-space()='Brand - H&M Products']")
	private WebElement hmBrandProductsTitle;

	@FindBy(xpath = "//a[text()='Allen Solly Junior']")
	private WebElement allenSollyJuniorLink;

	@FindBy(xpath = "//h2[normalize-space()='Brand - Allen Solly Junior Products']")
	private WebElement allenSollyJuniorProductsTitle;

	public void clickOnProductsLink() {
		elementUtils.clickWhenReady(productsLink);
	}

	public void scrollToBrandProductsPanel() {
		elementUtils.scrollUsingActionsClass(brandProductsPanel);

	}

	public boolean verifyBrandsSection() {
		if (listOfBrands.size() > 0 || listOfBrands.contains(hmBrandLink)
				|| listOfBrands.contains(allenSollyJuniorLink)) {
			return true;
		}
		return false;
	}

	public void clickOnHMBrandLink() {
		elementUtils.clickWhenReady(hmBrandLink);
	}

	public void switchToAdFrame() {
		try {
			elementUtils.waitForElementVisible(adFrame);
			driver.switchTo().frame(adFrame);
			ChainTestListener.log("Switched to ad frame successfully.");
			elementUtils.clickWhenReady(adCloseButton);
			ChainTestListener.log("Ad close button clicked successfully.");
		} catch (Exception e) {
			ChainTestListener.log("Ad frame or close button not found, skipping ad handling.");
		} finally {

			driver.switchTo().defaultContent();
			ChainTestListener.log("Switched back to default content after handling ad frame.");
		}

	}

	public String getHMBrandproductsTitle() {
		return elementUtils.doGetElementText(hmBrandProductsTitle);
	}

	public void clickOnAllenSollyJuniorLink() {
		elementUtils.scrollUsingActionsClass(allenSollyJuniorLink);
		elementUtils.scrollAndClick(allenSollyJuniorLink);
	}

	public String getAllenSollyJuniorProductsTitle() {
		return elementUtils.doGetElementText(allenSollyJuniorProductsTitle);
	}

}
