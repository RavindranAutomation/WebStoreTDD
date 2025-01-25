package com.webstore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadersPage extends BasePage {

	public HeadersPage(WebDriver driver) {
		super(driver);

	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(xpath = "//a[contains(text(),'Register') or a[@href='/register']]")
	private WebElement registerLink;

	@FindBy(xpath = "//a[contains(text(),'Log in') or a[@href='/login']]")
	private WebElement loginLink;

	@FindBy(xpath = "//a[contains(text(),'Shopping cart') or a[@href='/cart']]")
	private WebElement cartLink;

	@FindBy(xpath = "//a[@class='ico-wishlist']/span[1]")
	private WebElement wishListLink;

	@FindBy(xpath = "//div[@class='header-links']/ul/child::li//a[contains(text(),'RaviTest')]")
	private WebElement username;

	@FindBy(xpath = "//a[contains(text(),'Log out') or a[@href='/Log out']]")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@id='small-searchterms']")
	private WebElement searchBoxField;

	@FindBy(xpath = "//form[@action='/search']/child::input[@type='submit']")
	private WebElement searchBtn;

	public void clickOnRegisterHeader() {
		jSClick(registerLink);

	}

	public void clickOnLoginHeader() {
		jSClick(loginLink);

	}

	public void clickOnCartHeader() {
		jSClick(cartLink);

	}

	public void clickOnWishlistHeader() {
		jSClick(wishListLink);

	}

	public boolean isUserNameDispalyed() {
		return username.isDisplayed();

	}

	public void clickOnLogoutHeader() {
		jSClick(logoutLink);

	}

	public void enterValuesInsideTheSearchBox(String productname) {
		typeTextIntoElement(searchBoxField, productname, 3);

	}

	public void clickOnSearchButton() {
		javaScriptClick(searchBtn, 3);

	}

	public String handleWithoutProductSearchAlert() {
		Alert productAlert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = productAlert.getText();
		productAlert.accept();
		return alertText;
	}

}
