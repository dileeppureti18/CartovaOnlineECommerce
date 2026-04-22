package com.adactinhotelapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class UserRegistrationPage extends BasePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signUpOrLogin;

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement newUserSignUp;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement enterName;

	@FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
	private WebElement enterEmail;

	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement submit;

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement accountInformation;

	@FindBy(xpath = "//label[@for='id_gender1']")
	private WebElement gender1;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement defaultName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement defaultEmail;

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

	@FindBy(xpath = "//a[b[normalize-space()='John Doe']]")
	private WebElement loggedInAsName;

	@FindBy(xpath = "//a[@href='/delete_account']")
	private WebElement clickDeleteAccount;

	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement accountDeletedText;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement clickContinue;

	public void signUpOrLogin() {
		signUpOrLogin.click();
		ChainTestListener.log("Clicking on the signUp or Login button");
	}

	public String isNewUserSingUpDisplayed() {
		return newUserSignUp.getText();

	}

	public void enterUsername(String userName) {
		enterName.sendKeys(userName);
		ChainTestListener.log("Entering the New User Name");
	}

	public void enterUserEmail(String email) {
		enterEmail.sendKeys(email);
		ChainTestListener.log("Entering the New User Email");
	}

	public void clickSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		ChainTestListener.log("Clicking on Submit");
	}

	public String isAccountInformationVisible() {
		return accountInformation.getText();

	}

	public void selectMageGender() {
		gender1.click();
		ChainTestListener.log("Selecting the Gender 1 as Male...");
	}

	public String defaultName(String getDefaultName) {

		ChainTestListener.log("Printing the text that is already existing");
		return defaultName.getAttribute("value").trim();
	}

	public String getDefaultEmail(String getEmail) {

		return defaultEmail.getAttribute("value").trim();

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(checkOptin));
		checkOptin.click();
	}

	public void firstName(String firstName) {
		userFirstName.sendKeys(firstName);
	}

	public void lastName(String lastName) {
		userLastName.sendKeys(lastName);
	}

	public void enterCompany(String company) {
		companyName.sendKeys(company);
	}

	public void enterAddress1(String address1) {
		userAddress1.sendKeys(address1);
	}

	public void enterAddress2(String address2) {
		userAddress2.sendKeys(address2);
	}

	public void selectCountry(String country) {
		new Select(userCountry).selectByValue(country);
	}

	public void enterState(String state) {
		userState.sendKeys(state);
	}

	public void enterCity(String city) {
		userCity.sendKeys(city);
	}

	public void enterZipCode(String zipCode) {
		userZipcode.sendKeys(zipCode);
	}

	public void enterMobileNumber(String mobileNumber) {
		userMobileNumber.sendKeys(mobileNumber);
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

	public void clickingAlertClosing() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_2"));
//		driver.switchTo().frame("aswift_2");
		elementUtils.isElementDisplayed(closeTheAlert);
		closeTheAlert.click();
	}

	public String checkingLoggedInAsName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(loggedInAsName));
		return loggedInAsName.getText();
	}

	public void clickingOnTheDeleteButton() {
		clickDeleteAccount.click();
	}

	public String checkingAccountDeletedText() {
		return accountDeletedText.getText();
	}

	public void clickingOnContinueButton() {
		clickContinue.click();
	}
}
