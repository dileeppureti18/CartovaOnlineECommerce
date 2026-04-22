package com.adactinhotelapp.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactinhotelapp.utils.ElementUtils;

public class ContactUsPage extends BasePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[text()=' Contact us']")
	private WebElement contactUs;

	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement getInTouchText;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement nameFiled;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subjectfield;

	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement messageField;

	@FindBy(xpath = "//input[@name='upload_file']")
	private WebElement chooseFile;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//h2[@class='title text-center']/following-sibling::div[text()='Success! Your details have been submitted successfully.']")
	private WebElement successText;

	@FindBy(xpath = "//a[@class='btn btn-success']/child::span[text()=' Home']")
	private WebElement homeButton;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeButton;

	public void clickContactUs() {
		contactUs.click();
	}

	public String getGetInTouchText() {
		return getInTouchText.getText();
	}

	public void enterName(String name, String email, String subject, String message, String fileName) {
		nameFiled.sendKeys(name);
		emailField.sendKeys(email);
		subjectfield.sendKeys(subject);
		messageField.sendKeys(message);
		chooseFile.sendKeys(fileName);
		submitButton.click();
	}

	public void clickSubmitAndAcceptAlert() {
		driver.switchTo().alert().accept();

	}

	public String getSuccessText() {
		return successText.getText();

	}

	public void clickHomeButton() {
		homeButton.click();
	}

	public void closeTheAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_2"));
		elementUtils.isElementDisplayed(closeTheAlert);
		closeTheAlert.click();

	}
	

	public void clickCloseButton() {
		try {
			WebElement popup = closeButton;
			if (popup.isDisplayed()) {
				popup.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Optional pop-up not present, skipping.");
		}
	}

}
