package com.adactinhotelapp.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class PlaceOrderRegisterWhileCheckoutPage extends BasePage {

//	private static final String COMMENT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 .,!?-";
//	private static final SecureRandom random = new SecureRandom();

	private ElementUtils elementUtils;

	public PlaceOrderRegisterWhileCheckoutPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[@class='btn btn-default add-to-cart' and text()='Add to cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	private WebElement continueShopping;

	@FindBy(xpath = "//p[text()='Men Tshirt']/following-sibling::a[text()='Add to cart']")
	private WebElement secondProductAddToCart;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	private WebElement cartButton;

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	private WebElement proceedToCheckout;

	@FindBy(xpath = "//u[text()='Register / Login']")
	private WebElement registerOrLogin;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement nameTextField;

	@FindBy(xpath = "//input[@name='name']/following-sibling::input[@name='email']")
	private WebElement emailAddressField;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement submit;

	@FindBy(xpath = "//label[@for='id_gender1']")
	private WebElement titleOfGender;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterPassword;

	@FindBy(xpath = "//select[@id='days']")
	private WebElement selectDate;

	@FindBy(xpath = "//select[@id='months']")
	private WebElement selectMonth;

	@FindBy(xpath = "//select[@id='years']")
	private WebElement selectYear;

	@FindBy(xpath = "//input[@id='newsletter']")
	private WebElement checkNewsLetter;

	@FindBy(xpath = "//input[@id='optin']")
	private WebElement checkOptin;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement userFirstName;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement userLastName;

	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyName;

	@FindBy(xpath = "//input[@name='address1']")
	private WebElement userAddress1;

	@FindBy(xpath = "//input[@name='address2']")
	private WebElement userAddress2;

	@FindBy(xpath = "//select[@name='country']")
	private WebElement userCountry;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement userState;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement userCity;

	@FindBy(xpath = "//input[@name='zipcode']")
	private WebElement userZipcode;

	@FindBy(xpath = "//input[@name='mobile_number']")
	private WebElement userMobileNumber;

	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement submitButton;

	@FindBy(xpath = "//b[text()='Account Created!']")
	private WebElement accountCreatedText;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
	private WebElement loggedInAsName;

	@FindBy(xpath = "//ul[@id='address_delivery']")
	private WebElement yourDeliverAddress;

	@FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr")
	private List<WebElement> cartRows;

	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement commentTextArea;

	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeOrder;

	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement nameOnCard;

	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement cardNumber;

	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvvNumber;

	@FindBy(xpath = "//input[@name='expiry_month']")
	private WebElement expiryMonth;

	@FindBy(xpath = "//input[@name='expiry_year']")
	private WebElement expiryYear;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement placeAndConfirmOrder;

	@FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
	private WebElement orderPlacedMessage;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	private WebElement deleteAccount;

	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement accountDeletedText;

	public void clickAddToCart() {
		elementUtils.scrollAndClick(addToCart);
		elementUtils.clickWhenReady(continueShopping);
	}

	public void clickAddToCartSecondProduct() {
		elementUtils.clickWhenReady(secondProductAddToCart);
		elementUtils.clickWhenReady(continueShopping);
	}

	public void clickCartButton() {
		elementUtils.scrollUsingActionsClass(cartButton);
		cartButton.click();

	}

	public void clickProceedToCheckout() {
		proceedToCheckout.click();
	}

	public void clickRegisterOrLogin() {
		elementUtils.clickWhenReady(registerOrLogin);
	}

	public void enterUserDetails(String name, String email) {
		elementUtils.doSendKeys(nameTextField, name);
		elementUtils.doSendKeys(emailAddressField, email);

	}

	public void clickOnSignUpButton() {
		submit.click();
	}

	public void selectGender() {
		titleOfGender.click();
		ChainTestListener.log("Selecting the Gender 1 as Male...");
	}

	public void fillShippingAddress(HashMap<String, String> data) {
		userFirstName.sendKeys(data.get("First name"));
		userLastName.sendKeys(data.get("Last name"));
		companyName.sendKeys(data.get("Company"));
		userAddress1.sendKeys(data.get("Address 1"));
		userAddress2.sendKeys(data.get("Address 2"));
		new Select(userCountry).selectByValue(data.get("Country"));
		userState.sendKeys(data.get("State"));
		userCity.sendKeys(data.get("City"));
		userZipcode.sendKeys(data.get("Zipcode"));
		userMobileNumber.sendKeys(data.get("Mobile Number"));
		ChainTestListener.log("Shipping address details filled successfully.");
	}

	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}

	public void enterDateOfBirth(String date, String month, String year) {
		// We can also write in this way or the below
		Select selectingDate = new Select(selectDate);
		selectingDate.selectByValue(date);

		// Or can write like this as well
		new Select(selectMonth).selectByValue(month);
		new Select(selectYear).selectByValue(year);

	}

	public void clickingOnNewsLetterCheckBox() {
		checkNewsLetter.click();
	}

	public void clickingOnReceiveSpecialOfferCheckBox() {
		checkOptin.click();
	}

	public void clickSubmitButton() {
		// Here it is in the form so we can also user submit() method
		submitButton.click();
	}

	public String checkingAccountCreatedText() {
		return accountCreatedText.getText();
	}

	public void clickContinueButton() {
		elementUtils.isElementDisplayed(continueButton);
		continueButton.click();
	}

	public String checkingLoggedInAsName() {
		elementUtils.waitForElementVisible(loggedInAsName);
		return loggedInAsName.getText();
	}

	// Try to work on this as well as the adress is not checked correctly
	public String getDeliveryAddress() {
		return yourDeliverAddress.getText();

	}

	// Try to work on this more as the products cart is not validated correctly.
	public boolean validateCartDetails(String productName1, String productName2) {

		for (WebElement allRowsInCart : cartRows) {
			if (allRowsInCart.getText().contains(productName1) && allRowsInCart.getText().contains(productName2)) {
				return true;
			}

		}
		return false;

	}

	// Also work on this as we're entering the random comment in the comments
	// section.
//	public String generateRandomComment(int length) {
//		StringBuilder stringBuilder = new StringBuilder(length);
//
//		for (int i = 0; i < length; i++) {
//			stringBuilder.append(COMMENT_CHARS.charAt(random.nextInt(COMMENT_CHARS.length())));
//		}
//
//		return stringBuilder.toString().trim();
//
//	}

	public void enterOrderComment(String comment) {
		commentTextArea.clear();
		commentTextArea.sendKeys(comment);
	}

	public void clickOnPlaceOrder() {
		elementUtils.clickWhenReady(placeOrder);

	}

	public void enterCardDetials(String name, String number, String month, String year, String cvv) {

		nameOnCard.clear();
		nameOnCard.sendKeys(name);

		cardNumber.clear();
		cardNumber.sendKeys(number);

		expiryMonth.clear();
		expiryMonth.sendKeys(month);

		expiryYear.clear();
		expiryYear.sendKeys(year);

		cvvNumber.clear();
		cvvNumber.sendKeys(cvv);

		ChainTestListener.log("Payment details entered successfully.");
	}

	public void clickOnplaceAndConfirmOrder() {
		elementUtils.clickWhenReady(placeAndConfirmOrder);
	}

	public String getTextOfOrderPlaced() {
		elementUtils.waitForElementVisible(orderPlacedMessage);
		return orderPlacedMessage.getText();
	}

	public void clickDeleteAccount() {
		deleteAccount.click();
	}

	public String getAccountDeletedText() {
		elementUtils.waitForElementVisible(accountDeletedText);
		return accountDeletedText.getText();
	}

}
