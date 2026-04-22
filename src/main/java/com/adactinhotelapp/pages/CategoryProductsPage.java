package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class CategoryProductsPage extends BasePage {

	private ElementUtils elementUtils;

	public CategoryProductsPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//div[@id='accordian']")
	private WebElement categoryProductsPanel;

	@FindBy(xpath = "//a[normalize-space()='Women']")
	private WebElement womenCategoryLink;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement dismissAdButton;

	@FindBy(xpath = "//a[normalize-space()='Tops']/parent::li/preceding-sibling::li/child::a")
	private WebElement dressesCategoryLink;

	@FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
	private WebElement categoryProductHeader;

	@FindBy(xpath = "//a[normalize-space()='Men']")
	private WebElement menCategoryLink;

	@FindBy(xpath = "//a[normalize-space()='Jeans']")
	private WebElement jeansCategoryLink;

	@FindBy(xpath = "//h2[contains(text(),'Jeans Products')]")
	private WebElement jeansCategoryHeader;

	public boolean isCategoryProductsPanelDisplayed() {
		elementUtils.scrollUsingActionsClass(categoryProductsPanel);
		return elementUtils.isElementDisplayed(categoryProductsPanel);

	}

	public void clickOnWomenCategory() {
		elementUtils.scrollUsingActionsClass(womenCategoryLink);
		elementUtils.clickWhenReady(womenCategoryLink);
		driver.switchTo().frame("aswift_3");
		elementUtils.clickWhenReady(dismissAdButton);
		driver.switchTo().defaultContent();

	}

	public void clickOnDressCategory() {
		elementUtils.waitForElementVisible(dressesCategoryLink);
		elementUtils.scrollAndClick(dressesCategoryLink);

	}

	public String getCategoryProductHeaderText() {
		return elementUtils.doGetElementText(categoryProductHeader);

	}

	public void clickOnMenCategoryLink() {
		elementUtils.clickWhenReady(menCategoryLink);

	}

	public void clickOnJeansCategoryLink() {
		elementUtils.waitForElementVisible(jeansCategoryLink);
		jeansCategoryLink.click();

	}

	public String getJeansCategoryHeaderText() {
		return elementUtils.doGetElementText(jeansCategoryHeader);
	}

}
