package com.webstore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.LoginPage;
import com.webstore.pageobjects.PassRecoveryPage;
import com.webstore.testbase.BaseClass;

public class TC003_ForgetPasswordTest extends BaseClass {
	HeadersPage headPage;
	LoginPage loginPage;
	PassRecoveryPage recPage;

	@Test(groups = { "Sanity", "Master" })
	public void verify_ForgotPassword() {
		
		logger.info("***** Starting TC003_ForgetPasswordTest ****");
		try {
			headPage = new HeadersPage(driver);
			logger.info("Clicking on login header link");
			headPage.clickOnLoginHeader();
			loginPage = new LoginPage(driver);

			recPage = new PassRecoveryPage(driver);
			logger.info("Clicking on Forgot password link");
			loginPage.clickOnForgotPassword();
			logger.info("Verifing title is displayed or not");
			if (recPage.isPasswordRecoveryTitleisDisplayed() == true) {
				logger.info("Entering recovery email");
				recPage.enterEmailInRecoveryEmailField();
				logger.info("Clicking on Recovery button");
				recPage.clickOnRecoveryBtn();
			} else {
				logger.error("ForgetPasswordTest page is not redirected");
				Assert.fail();
			}
			logger.info("Validating recovery email sent message");
			Assert.assertEquals("Email with instructions has been sent to you.", recPage.getRecoveryInstructionMessage());
			logger.info("***** TC002_LoginTest is ended ****");
		
		} catch (Exception e) {
			logger.error("ForgotPassword test is failed : " + e.getMessage());
			Assert.fail("ForgotPassword test is failed :" + e.getMessage());
		}

	}

}
