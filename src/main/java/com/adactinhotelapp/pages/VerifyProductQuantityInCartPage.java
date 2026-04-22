package com.adactinhotelapp.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class VerifyProductQuantityInCartPage extends BasePage {

	private ElementUtils elementUtils;

	public VerifyProductQuantityInCartPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[@style='color: brown;' and text()='View Product']")
	private WebElement viewProduct;

	@FindBy(xpath = "//input[@id='quantity']")
	private WebElement quantityInput;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCart;

	@FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
	private List<WebElement> cartTableRows;

	public void clickOnViewProduct() {
		elementUtils.clickWhenReady(viewProduct);

	}

	public void setQuantity(int quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(quantity));
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public void clickOnViewCart() {
		elementUtils.clickWhenReady(viewCart);

	}

	public boolean verifyProductDetails(int expectedQuantity) {

		for (WebElement rows : cartTableRows) {
			WebElement productName = rows.findElement(By.xpath("//p[text()='Women > Tops']"));
			String actualQunatity = rows.findElement(By.xpath("//td[@class='cart_quantity']/button[@class='disabled']"))
					.getText().trim();
			if (productName.isDisplayed() && actualQunatity.equals(String.valueOf(expectedQuantity))) {
				return true;

			}
		}
		return false;

	}

}
