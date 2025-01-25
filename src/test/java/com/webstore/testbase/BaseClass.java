package com.webstore.testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.webstore.pageobjects.HeadersPage;
import com.webstore.pageobjects.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger; // Log4j
	public static Properties p;
	static HeadersPage headPage;
	static LoginPage loginPage;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String browserName) throws IOException {
		logger = LogManager.getLogger(this.getClass()); // lOG4J2
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// browser
		switch (browserName.toLowerCase()) {
		case "chrome":
			logger.info("Launching chrome browser");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			logger.error("Invalid browser anme is entered");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("APP_URL")); // reading url from properties file.
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		logger.info("Quitting web browser");
		driver.quit();
	}

	public String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomeNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomeAlphaNumberic() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "@" + generatednumber);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

	public static void loginApplication() {
		logger.info("***** Starting Login reusable method ****");
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
	
	public static void logoutApplication() {
		logger.info("Clicking on Logout button");
		try {
			headPage.clickOnLogoutHeader();
		} catch (Exception e) {
			logger.error("Logout is failed : " + e.getMessage());
			Assert.fail("Logout is failed :" + e.getMessage());
		}
		
	}

}
