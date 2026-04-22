package com.adactinhotelapp.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.adactinhotelapp.utils.ElementUtils;

public class SearchProductPage extends BasePage {

	private ElementUtils elementUtils;
	private static final Logger logger = LogManager.getLogger(SearchProductPage.class);

	public SearchProductPage(WebDriver driver) {
		super(driver);
		logger.info("Initializing SearchProductPage"); // Log initialization
		this.elementUtils = new ElementUtils(driver);
		logger.debug("SearchProductPage initialized successfully");
	}

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement productsTab;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "//h2[text() = 'All Products']")
	private WebElement allProductsText;

	@FindBy(xpath = "//input[@id='search_product']")
	private WebElement searchProduct;

	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement searchButton;

	@FindBy(xpath = "//h2[text()='Searched Products']")
	private WebElement searchedProductsText;

	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[@class='col-sm-4']")
	private List<WebElement> listOfSearchedProducts;

	public void clickOnProducts() {
		logger.info("Attempting to click on Products tab");
		elementUtils.clickWhenReady(productsTab);
		logger.info("Successfully clicked on Products tab");
	}

	public void closeTheAlert() {
		driver.switchTo().frame("aswift_3");
		driver.switchTo().frame("ad_iframe");
		elementUtils.isElementDisplayed(closeTheAlert);
		closeTheAlert.click();
//		driver.switchTo().parentFrame(); This has to be there after entering and later exists from the child frame

	}

	public String getAllProductsText() {
		elementUtils.waitForElementVisible(allProductsText);
		return allProductsText.getText();
	}

	public void sendSearchProductName(String productName) {
		searchProduct.sendKeys(productName);
		elementUtils.clickWhenReady(searchButton);
		searchButton.click();
	}

	public String getSearchedProductsText() {
		return searchedProductsText.getText();
	}

	public boolean getListOfSearchedProducts() {
		return !listOfSearchedProducts.isEmpty();
	}

}
