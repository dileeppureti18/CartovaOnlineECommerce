package com.adactinhotelapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.adactinhotelapp.utils.ElementUtils;

public class SearchAndVerifyCartPage extends BasePage {

	private ElementUtils elementUtils;

	public SearchAndVerifyCartPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement productsLink;

	@FindBy(xpath = "//div[@id='aswift_4_host']/iframe")
	private WebElement frame;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeButton;

	@FindBy(id = "search_product")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@id='submit_search']")
	private WebElement searchButton;

	@FindBy(xpath = "//h2[text()='Searched Products']")
	private WebElement searchedProductstext;

	@FindBy(xpath = "//div[@class='col-sm-4']")
	private List<WebElement> searchedProductsList;

	@FindBy(xpath = "//div[@class='overlay-content']/a[@class='btn btn-default add-to-cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement continueShoppingButton;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	private WebElement cartLink;

	@FindBy(xpath = "//table/tbody")
	private WebElement cartTable;

	@FindBy(xpath = "//td[@class='cart_description']/h4")
	private List<WebElement> cartProductsNameList;

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement signUpLoginLink;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement loginEmailInput;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement loginPasswordInput;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginButton;

	public void clickOnProductsLink() {
		elementUtils.clickWhenReady(productsLink);
	}

//	public void closingAlert() {
//		elementUtils.waitForElementVisible(frame);
//		driver.switchTo().frame(frame);
//		elementUtils.waitForElementVisible(closeButton);
//		closeButton.click();
//		driver.switchTo().defaultContent();
//	}

	public void scrollAndEnterProductName() {
		elementUtils.scrollUsingActionsClass(searchBox);
		searchBox.clear();
		searchBox.sendKeys("jeans");
		searchButton.click();
	}

	public String getSearchedProductsText() {
		return searchedProductstext.getText();
	}

	public void searchedProducts() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < searchedProductsList.size(); i++) {

			WebElement product = searchedProductsList.get(i);

			if (product.getText().contains("Jeans")) {

				js.executeScript("arguments[0].scrollIntoView(true);", product);

				Actions actions = new Actions(driver);
				actions.moveToElement(product).perform();

				WebElement addToCartButton = product.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));

				addToCartButton.click();

				elementUtils.waitForElementVisible(continueShoppingButton);
				continueShoppingButton.click();
			}
		}
	}

	public void ClickOnCartLink() {
		elementUtils.waitForElementVisible(cartLink);
		elementUtils.scrollAndClick(cartLink);
	}

	public boolean isProductInCart() {
		elementUtils.scrollUsingActionsClass(cartTable);
		for (int i = 0; i < cartProductsNameList.size(); i++) {
			WebElement product = cartProductsNameList.get(i);

			if (product.getText().toLowerCase().contains("jeans")) {
				return true;
			}
		}
		return false;
	}

	public void clickOnSignUpLoginLink() {
		elementUtils.scrollUsingActionsClass(signUpLoginLink);
		elementUtils.waitForElementVisible(signUpLoginLink);
		signUpLoginLink.click();
	}

	public void login(String email, String password) {
		elementUtils.waitForElementVisible(loginEmailInput);
		elementUtils.doSendKeys(loginEmailInput, email);
		elementUtils.doSendKeys(loginPasswordInput, password);
		loginButton.click();
	}

	public void clickOnCartLink() {
		elementUtils.waitForElementVisible(cartLink);
		cartLink.click();
	}

	public boolean productsInCart() {
		for (WebElement productsList : cartProductsNameList) {
			if (productsList.getText().toLowerCase().contains("jeans")) {
				return true;
			}
		}
		return false;
	}

}
