package com.webstore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.HomePage;
import com.webstore.pageobjects.RegisterPage;
import com.webstore.testbase.BaseClass;

public class TC001_Account_Registration_Test extends BaseClass {
	HeadersPage headerPage;
	RegisterPage regpage;
	HomePage homePage;

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		try {
			logger.info("***** Starting TC001_AccountRegistrationTest  ****");
			headerPage = new HeadersPage(driver);
			logger.info("Clicking on registration header link");
			headerPage.clickOnRegisterHeader();
			regpage = new RegisterPage(driver);
			logger.info("Selecting gender as male");
			regpage.selectMaleGender();
			logger.info("Entering firstname");
			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("Entering lastname");
			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Entering email");
			regpage.setEmail(randomeString() + "@yopmail.com");
			logger.info("Entering password");
			regpage.setPassword();
			logger.info("Entering confirm password");
			regpage.setConfirmPassword();
			logger.info("Clicking on Register buton");
			regpage.clickOnRegisterBtn();

			homePage = new HomePage(driver);
			logger.info("Validating registration success");
			Assert.assertEquals(homePage.getRegisterSuccessMessage(), "Your registration completed");
			logger.info("***** TC001_AccountRegistrationTest is ended ****");
		} catch (Exception e) {
			logger.error("Registration test is failed : " + e.getMessage());
			Assert.fail("Registration test is failed :" + e.getMessage());
		}
	}
}
