package com.adactinhotelapp.pages;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.exceptions.FrameworkException;
import com.adactinhotelapp.utils.ElementUtils;

public class AddProductsInCartPage extends BasePage {

	private ElementUtils elementUtils;

	public AddProductsInCartPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	private By adFrameBy = By.id("ad_iframe");
	private By dismissButtonBy = By.id("dismiss-button");

	@FindBy(id = "ad_iframe")
	private WebElement adFrame;

	@FindBy(id = "dismiss-button")
	private WebElement dismissButton;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "(//a[contains(@href,'products')])[1]")
	private WebElement productsTab;

	@FindBy(xpath = "//a[@class='btn btn-default add-to-cart' and text()='Add to cart']")
	private WebElement firstProductAddToCart;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement continueShopping;

	@FindBy(xpath = "//a[@data-product-id='2' and text()='Add to cart']")
	private WebElement secondProductAddToCart;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCart;

	@FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
	private List<WebElement> cartRows;

	public void alertHandling() {
		elementUtils.switchToFrameAndClickIfPresent(adFrameBy, dismissButtonBy);
	}

	public void clickOnProductsTab() {
		elementUtils.clickWhenReady(productsTab);
	}

	public void clickOnTheFirstProduct() {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(2000, 0);
		elementUtils.clickWhenReady(firstProductAddToCart);
		elementUtils.clickWhenReady(continueShopping);
		elementUtils.waitForElementInVisible(continueShopping);
	}

	public void clickingOnTheSecondProduct() {
		Actions actions = new Actions(driver);
		actions.scrollByAmount(2000, 0);
		actions.moveToElement(secondProductAddToCart);
		elementUtils.clickWhenReady(secondProductAddToCart);

	}

	public void clickOnViewCart() {

		elementUtils.clickWhenReady(viewCart);

	}

	public void validateCartPrices() {

		BigDecimal grandTotalCalculated = BigDecimal.ZERO;

		for (WebElement allRowsInCart : cartRows) {
			String priceText = allRowsInCart.findElement(By.xpath(".//td[@class='cart_price']/p")).getText()
					.replace("Rs. ", "").trim();
			String quantityText = allRowsInCart.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText()
					.trim();
			String totalPriceText = allRowsInCart.findElement(By.xpath(".//td[@class='cart_total']/p")).getText()
					.replace("Rs. ", "").trim();

			BigDecimal price = new BigDecimal(priceText);
			BigDecimal quantity = new BigDecimal(quantityText);
			BigDecimal displayedTotal = new BigDecimal(totalPriceText);

			BigDecimal calculatedTotal = price.multiply(quantity);

			if (calculatedTotal.compareTo(displayedTotal) != 0) {
				throw new FrameworkException(
						"Price mismatch! Expected: " + calculatedTotal + " but Found: " + displayedTotal);

			}

			grandTotalCalculated = grandTotalCalculated.add(calculatedTotal);
		}

	}

}
