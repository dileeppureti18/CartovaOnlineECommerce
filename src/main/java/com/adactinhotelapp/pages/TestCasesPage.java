package com.adactinhotelapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactinhotelapp.utils.ElementUtils;

public class TestCasesPage extends BasePage {

	private ElementUtils elementUtils;

	public TestCasesPage(WebDriver driver) {
		super(driver);
		
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//a[contains(@href,'cases')]")
	private WebElement testCasesTile;
	
	@FindBy(xpath = "//div[@id='dismiss-button']")
	private WebElement closeTheAlert;

	public void closeTheAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_3"));
		elementUtils.isElementDisplayed(closeTheAlert);
		closeTheAlert.click();

	}

	public void clickingTestCasesTile() {
		testCasesTile.click();
	}

}
