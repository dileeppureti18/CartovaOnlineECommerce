package com.adactinhotelapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends BasePage {

	// elements or locators ==> WebElement(with PF) or By (w.o PF)

	// By locators

	// private By locationDropdown=By.xpath("//select[@name='location']");
	@FindBy(xpath = "//select[@name='location']")
	private WebElement locationDropdown;

	public SearchHotelPage(WebDriver driver) {
		super(driver);

	}

	public void locationDropdown(String option) {
		// elementUtils.getElement(locationDropdown).sendKeys(option);
		locationDropdown.sendKeys(option);
	}

}
