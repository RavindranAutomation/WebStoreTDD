package com.webstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.LoginPage;
import com.webstore.testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	HeadersPage headPage;
	LoginPage loginPage;
	


	@Test(groups = {"Sanity", "Master"})
	public void verify_Login() {
		logger.info("***** Starting TC002_LoginTest ****");
		try {
			headPage = new HeadersPage(driver);
			logger.info("Clicking on Login header link");
			headPage.clickOnLoginHeader();
			loginPage = new LoginPage(driver);
			logger.info("Entering email");
			loginPage.enterEmail(p.getProperty("email"));
			logger.info("Entering password");
			loginPage.enterPassword(p.getProperty("password"));
			logger.info("Clicking on Login button");
			loginPage.clickOnLoginBtn();
			Assert.assertEquals(true, headPage.isUserNameDispalyed());
			
			
		} catch (Exception e) {
			logger.error("Login test is failed : " + e.getMessage());
			Assert.fail("Login test is failed :" + e.getMessage());
		}

	}

	@AfterMethod
	public void verify_Logout() {
		logger.info("Clicking on Logout button");
		headPage.clickOnLogoutHeader();
		logger.info("***** TC002_LoginTest is ended ****");
	}

}
