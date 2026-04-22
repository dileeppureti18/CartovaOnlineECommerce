package com.adactinhotelapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactinhotelapp.utils.ElementUtils;

public class AllProductsPage extends BasePage {

	private ElementUtils elementUtils;

	public AllProductsPage(WebDriver driver) {
		super(driver);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement productsTab;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "//h2[text() = 'All Products']")
	private WebElement allProductsText;

	// Here not only WebElement we can also write List<WebElement>
	@FindBy(xpath = "//div[@id='cartModal']/following-sibling::div[@class='col-sm-4']")
	private List<WebElement> listOfallproducts;

	@FindBy(xpath = "(//a[text()='View Product'])[1]")
	private WebElement viewProduct;

	@FindBy(xpath = "//h2[text()='Blue Top']")
	private WebElement productName;

	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement categoryOfTheProduct;

	@FindBy(xpath = "//span[text()='Rs. 500']")
	private WebElement priceOfTheProduct;

	@FindBy(xpath = "//b[text()='Availability:']")
	private WebElement availabilityOfProduct;

	@FindBy(xpath = "//b[text()='Condition:']")
	private WebElement conditionOfTheProduct;

	@FindBy(xpath = "//b[text()='Brand:']")
	private WebElement brandOfTheProduct;

	public void clickOnProducts() {
		productsTab.click();
	}

	public void closeTheAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Ensure that the frame name or id is changing as per the page we redirect to

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_3"));
		elementUtils.isElementDisplayed(closeTheAlert);
		closeTheAlert.click();

	}

	public String getAllProductsText() {
		elementUtils.waitForElementVisible(allProductsText);
		return allProductsText.getText();
	}

	/*
	 * As we cannot directly see whether the list is displayed we use conditions to
	 * meet the requirement
	 */
	public boolean getListOfAllProducts() {
		return !listOfallproducts.isEmpty() && listOfallproducts.get(0).isDisplayed();
	}

	public void clickingOnTheFirstDisplayedProduct() {
		Actions action = new Actions(driver);
		action.scrollToElement(viewProduct);
		action.pause(Duration.ofSeconds(30));
		viewProduct.click();

	}

	public boolean visibilityOfTheProductDetails() {
		return productName.isDisplayed() && availabilityOfProduct.isDisplayed() && conditionOfTheProduct.isDisplayed()
				&& brandOfTheProduct.isDisplayed();
	}

}
