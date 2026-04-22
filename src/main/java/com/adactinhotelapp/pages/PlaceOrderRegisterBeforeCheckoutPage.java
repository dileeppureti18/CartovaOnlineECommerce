package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class PlaceOrderRegisterBeforeCheckoutPage extends BasePage {

	private ElementUtils elementUtils;

	public PlaceOrderRegisterBeforeCheckoutPage(WebDriver driver) {
		super(driver);
		this.elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
	private WebElement signUpOrLoginButton;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='name']/following-sibling::input[@name='email']")
	private WebElement userEmail;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement signUpSubmitButton;

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

	@FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::b")
	private WebElement loggedInAsName;

	@FindBy(xpath = "//a[@class='btn btn-default add-to-cart' and text()='Add to cart']")
	private WebElement blueTopProduct;

	@FindBy(xpath = "//u[text()='View Cart']")
	private WebElement viewCart;

	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	private WebElement proceedToCheckout;

	@FindBy(xpath = "//ul[@id='address_delivery']")
	private WebElement deliveryAddress;

	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement commentBox;

	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement userNameOnCard;

	@FindBy(xpath = "//input[@name='card_number']")
	private WebElement cardNumber;

	@FindBy(xpath = "//input[@name='cvc']")
	private WebElement cvvNumber;

	@FindBy(xpath = "//input[@name='expiry_month']")
	private WebElement expiryMonth;

	@FindBy(xpath = "//input[@name='expiry_year']")
	private WebElement expiryYear;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement payAndConfirmOrder;

	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	private WebElement deleteButton;

	public void clickingSignupButton() {
		elementUtils.clickWhenReady(signUpOrLoginButton);
	}

	public void enterUserDetails(String name, String email) {
		elementUtils.doSendKeys(userName, name);
		elementUtils.doSendKeys(userEmail, email);
		signUpSubmitButton.click();
	}

	public void selectGender() {
		titleOfGender.click();
		ChainTestListener.log("Selecting the Gender 1 as Male...");
	}

	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}

	public void fillShippingAddress(String firstName, String lastName, String company, String address1, String address2,
			String country, String state, String city, String zipcode, String cellNumber) {
		userFirstName.sendKeys(firstName);
		userLastName.sendKeys(lastName);
		companyName.sendKeys(company);
		userAddress1.sendKeys(address1);
		userAddress2.sendKeys(address2);
		new Select(userCountry).selectByValue(country);
		userState.sendKeys(state);
		userCity.sendKeys(city);
		userZipcode.sendKeys(zipcode);
		userMobileNumber.sendKeys(cellNumber);
		ChainTestListener.log("Shipping address details filled successfully.");
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

	public String getAccountCreatedText() {
		return accountCreatedText.getText();
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public String checkingLoggedInAsName() {
		elementUtils.waitForElementVisible(loggedInAsName);
		return loggedInAsName.getText();
	}

	public void addingProductToCart() {
		elementUtils.scrollAndClick(blueTopProduct);

	}

	public void clickingOnViewCart() {
		elementUtils.clickWhenReady(viewCart);
	}

	public void clickingOnProceedToCheckout() {
		elementUtils.clickWhenReady(proceedToCheckout);
	}

	public String getDeliveryAddress() {
		return elementUtils.doGetElementText(deliveryAddress);
	}

	public void enterTextInCommentBox(String message) {
		elementUtils.scrollUsingActionsClass(commentBox);
		commentBox.clear();
		commentBox.sendKeys(message);
		placeOrderButton.click();
	}

	public void enterCardDetails(String nameOnCard, String number, String cvv, String expMonth, String expYear) {
		elementUtils.doSendKeys(userNameOnCard, nameOnCard);
		cardNumber.sendKeys(number);
		cvvNumber.sendKeys(cvv);
		expiryMonth.sendKeys(expMonth);
		expiryYear.sendKeys(expYear);
		payAndConfirmOrder.click();
	}

	public void clickDeleteButton() {
		elementUtils.clickWhenReady(deleteButton);
	}

}
