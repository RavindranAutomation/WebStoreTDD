package com.webstore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.SearchResultsPage;
import com.webstore.testbase.BaseClass;

public class TC004_SearchTest extends BaseClass {
	HeadersPage headPage;
	SearchResultsPage searchPage;

	@BeforeMethod(groups = { "Sanity", "Master" })
	public void loginApp() {

		BaseClass.loginApplication();
	}

	@Test(priority = 1, groups = { "Sanity", "Master" })
	public void verifySearchWithoutAddingAnyProduct() {
		logger.info("***** Starting TC004_SearchTest ****");
		try {
			headPage = new HeadersPage(driver);
			logger.info("Clicking on Search button");
			headPage.clickOnSearchButton();
			logger.info("Validating search alert text");
			Assert.assertEquals("Please enter some search keyword", headPage.handleWithoutProductSearchAlert());
		} catch (Exception e) {
			logger.error("Search test without any product  is failed : " + e.getMessage());
			Assert.fail("Search test without any product is failed :" + e.getMessage());
		}

	}

	@Test(priority = 2, groups = { "Sanity", "Master" })
	public void verifySearchWithValidProduct() {
		try {
			logger.info("Entering values into search field");
			headPage.enterValuesInsideTheSearchBox(p.getProperty("testproduct"));
			logger.info("Clicking on search button");
			headPage.clickOnSearchButton();
			searchPage = new SearchResultsPage(driver);
			logger.info("Validating search results product");
			Assert.assertEquals(p.getProperty("testproduct"), searchPage.getSearchProductDetail());
			Assert.assertEquals(true, searchPage.isSearchedProductDisplayed());
		} catch (Exception e) {
			logger.error("Search test with valid product  is failed : " + e.getMessage());
			Assert.fail("Search test with valid product is failed :" + e.getMessage());
		}
	}

	@Test(priority = 3, groups = { "Sanity", "Master" })
	public void verifySearchWithInvalidProduct() {
		try {
			logger.info("Entering invalid product name on the serach field");
			headPage.enterValuesInsideTheSearchBox("abcd");
			logger.info("Clicking on search button");
			headPage.clickOnSearchButton();
			logger.info("Validating invalid product searc results");
			Assert.assertEquals("No products were found that matched your criteria.",
					searchPage.getInvalidSearchResultsMessage());
		} catch (Exception e) {
			logger.error("Search test with invalid product  is failed : " + e.getMessage());
			Assert.fail("Search test with invalid product is failed :" + e.getMessage());
		}

	}

	@AfterMethod(groups = { "Sanity", "Master" })
	public void logoutApp() {
		BaseClass.logoutApplication();
	}

}
