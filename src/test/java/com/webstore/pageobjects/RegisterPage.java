package com.webstore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='gender-male']")
	private WebElement maleRadioBtn;

	@FindBy(xpath = "//input[@id='gender-female']")
	private WebElement femaleRadioBtn;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement EmailField;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@id='register-button']")
	private WebElement registerBtn;

	public void selectMaleGender() {
		jSClick(maleRadioBtn);

	}

	public void setFirstName(String fname) {
		firstNameField.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastNameField.sendKeys(lname);
	}

	public void setEmail(String email) {
		EmailField.sendKeys(email);
	}

	public void setPassword() {
		passwordField.sendKeys("Test@12345");
	}

	public void setConfirmPassword() {
		confirmPasswordField.sendKeys("Test@12345");

	}

	public void clickOnRegisterBtn() {
		jSClick(registerBtn);

	}
}
