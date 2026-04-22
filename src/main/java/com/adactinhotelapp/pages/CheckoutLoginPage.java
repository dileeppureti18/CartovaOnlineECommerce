package com.adactinhotelapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adactinhotelapp.utils.ElementUtils;

/**
 * Page object representing the checkout/login page flows. Provides actions for
 * signing in, adding products to cart, and completing checkout.
 */
public class CheckoutLoginPage extends BasePage {

	private static final Logger LOG = LoggerFactory.getLogger(CheckoutLoginPage.class);

	private ElementUtils elementUtils;

	public CheckoutLoginPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement signupLoginLink;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailInput;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginSubmitButton;

	@FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
	private WebElement loggedInAsUsername;

	// Changed single addToCartButton to a list so tests can target specific
	// products by index
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[text()='Add to cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCartLink;

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//ul[@id='address_delivery']//child::li[contains(@class,'address_address1')]")
	private WebElement deliveryAddressItem;

	@FindBy(xpath = "//textarea[@class='form-control']")
	private WebElement orderCommentsTextArea;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	private WebElement placeOrderLink;

	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement nameOnCardInput;

	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement cardNumberInput;

	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvcInput;

	@FindBy(xpath = "//input[@name='expiry_month']")
	private WebElement expiryMonthInput;

	@FindBy(xpath = "//input[@name='expiry_year']")
	private WebElement expiryYearInput;

	// Scoped the submit button locator to avoid ambiguity with other submit buttons
	// on the page
	@FindBy(xpath = "//button[@data-qa='pay-button']")
	private WebElement paySubmitButton;

	@FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
	private WebElement successMessage;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	private WebElement deleteAccountButton;

	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	private WebElement accountDeletedMessage;

	/**
	 * Clicks the signup/login link.
	 * 
	 * @return this page object
	 */
	public CheckoutLoginPage clickSignupLoginLink() {
		LOG.info("Clicking Signup/Login link");
		elementUtils.clickWhenReady(signupLoginLink);
		return this;
	}

	/**
	 * Enter login details and submit.
	 * 
	 * @param email    user email
	 * @param password user password
	 * @return this page object (if login does not redirect) or a new page object
	 *         when needed
	 */
	public CheckoutLoginPage enterLoginDetails(String email, String password) {
		LOG.info("Entering login for {}", email);
		elementUtils.doSendKeys(emailInput, email);
		elementUtils.doSendKeys(passwordInput, password);
		loginSubmitButton.click();
		return this;
	}

	public String getLoggedInAsUsername() {
		return elementUtils.doGetElementText(loggedInAsUsername);
	}

	// Updated to accept an index and actually click the corresponding add-to-cart
	// button
	public CheckoutLoginPage clickAddToCartForProduct(int index) {
		LOG.info("Clicking Add to Cart for product index {}", index);
		if (addToCartButtons == null || addToCartButtons.isEmpty()) {
			throw new IllegalStateException("No Add to cart buttons were found on the page");
		}
		if (index < 0 || index >= addToCartButtons.size()) {
			throw new IndexOutOfBoundsException("Invalid product index: " + index);
		}
		WebElement target = addToCartButtons.get(index);
		elementUtils.scrollUsingActionsClass(target);
		elementUtils.clickWhenReady(target);
		return this;
	}

	public CheckoutLoginPage clickViewCartButton() {
		elementUtils.clickWhenReady(viewCartLink);
		return this;
	}

	public CheckoutLoginPage clickProceedToCheckoutButton() {
		elementUtils.clickWhenReady(proceedToCheckoutButton);
		return this;
	}

	public String getDeliveryAddress() {
		return elementUtils.doGetElementText(deliveryAddressItem);
	}

	public CheckoutLoginPage enterOrderCommentsAndPlaceOrder(String comments) {
		elementUtils.scrollUsingActionsClass(orderCommentsTextArea);
		elementUtils.doSendKeys(orderCommentsTextArea, comments);
		elementUtils.clickWhenReady(placeOrderLink);
		return this;
	}

	public CheckoutLoginPage enterPaymentDetailsAndPay(String nameOnCard, String cardNumber, String cvc,
			String expiryMonth, String expiryYear) {
		elementUtils.doSendKeys(nameOnCardInput, nameOnCard);
		elementUtils.doSendKeys(cardNumberInput, cardNumber);
		elementUtils.doSendKeys(cvcInput, cvc);
		elementUtils.doSendKeys(expiryMonthInput, expiryMonth);
		elementUtils.doSendKeys(expiryYearInput, expiryYear);
		elementUtils.clickWhenReady(paySubmitButton);
		return this;
	}

	public String getSuccessMessage() {
		return elementUtils.doGetElementText(successMessage);
	}

	public CheckoutLoginPage clickDeleteAccountButton() {
		elementUtils.clickWhenReady(deleteAccountButton);
		return this;
	}

	public String getAccountDeletedMessage() {
		return elementUtils.doGetElementText(accountDeletedMessage);
	}

	/**
	 * Verifies that the page is loaded by checking presence of the Signup/Login
	 * link.
	 */
	public boolean isAt() {
		return elementUtils.isElementDisplayed(signupLoginLink);
	}

}