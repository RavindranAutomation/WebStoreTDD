package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	private WebElement registrationSuccessMsgElement;

	public String getRegisterSuccessMessage() {
		return getTextFromElement(registrationSuccessMsgElement, 3);

	}
}
