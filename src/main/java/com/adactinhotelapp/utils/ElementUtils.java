package com.adactinhotelapp.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	private WebDriver driver;
	private final int DEFAULT_TIMEOUT = 30;
	private WebDriverWait wait;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	public WebElement getElement(By by) {

		WebElement element = null;

		element = driver.findElement(by);

		if (isElementDisplayed(element)) {
			return element;
		} else {
			return element;
		}

	}

	/**
	 * Handling frames and alerts here using By locator and findElements() both For
	 * optional elements: Use By Use findElements() Avoid exception-driven control
	 * flow
	 * 
	 * For mandatory elements: Use @FindBy Use explicit waits
	 */
	public void switchToFrameAndClickIfPresent(By frameLocator, By elementLocator) {

		List<WebElement> frames = driver.findElements(frameLocator);
		if (!frames.isEmpty()) {
			driver.switchTo().frame(frames.get(0));

			List<WebElement> elements = driver.findElements(elementLocator);
			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				elements.get(0).click();

			}

			driver.switchTo().defaultContent();

		}
	}

	/**
	 * Waits for an element to be visible and then clicks it.
	 */
	public void clickWhenReady(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	/**
	 * Generic sendKeys with visibility check.
	 */
	public void doSendKeys(WebElement element, String value) {
		waitForElementVisible(element);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Waits for an element to be visible before returning it.
	 */

	public WebElement waitsForElementVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * Wait for an element to be visible on the DOM.
	 */
	public WebElement waitForElementVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for an element to be invisible on the DOM.
	 */
	public Boolean waitForElementInVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Overloaded method to wait for an element using a By locator (useful for
	 * dynamic elements).
	 */
	public WebElement waitForElementVisible(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Capture text from an element after ensuring it is visible.
	 */
	public String doGetElementText(WebElement element) {
		return waitForElementVisible(element).getText();
	}

	/**
	 * Check if an element is displayed without throwing an immediate exception.
	 */
	public boolean isElementDisplayed(WebElement element) {
		try {
			return waitForElementVisible(element).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Waits for a frame to be visible and switch into it.
	 */
	public void clickingAlertClosing(WebElement frameName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));

	}

	/**
	 * Scrolling to the bottom of the page using JavaScriptExecutor.
	 */
	public void scrollToTheBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * Scrolling to the element using JavaScriptExecutor.
	 */
	public void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		js.executeScript("arguments[0].click();", element);
	}

	/*
	 * Scrolling to the element using Actions class (alternative to JavaScriptExecutor).
	 */
	public void scrollUsingActionsClass(WebElement element) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).build().perform();
	}
}
