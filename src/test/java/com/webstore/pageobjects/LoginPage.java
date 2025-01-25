package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@class='inputs']/child::input[@id='Email']")
	private WebElement emailField;

	@FindBy(xpath = "//div[@class='inputs']/child::input[@id='Password']")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='buttons']/child::input[@class='button-1 login-button']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='inputs reversed']/child::span/a")
	private WebElement forgotPasswordLink;

	public void enterEmail(String email) {
		typeTextIntoElement(emailField, email, 3);

	}

	public void enterPassword(String pass) {
		typeTextIntoElement(passwordField, pass, 3);

	}

	public void clickOnLoginBtn() {
		jSClick(loginBtn);

	}
	
	public void clickOnForgotPassword() {
		javaScriptClick(forgotPasswordLink, 3);

	}

}
