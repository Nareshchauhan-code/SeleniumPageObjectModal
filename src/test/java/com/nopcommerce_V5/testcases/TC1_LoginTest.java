package com.nopcommerce_V5.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce_V5.baselibrary.BaseLibrary;
import com.nopcommerce_V5.testpages.LoginPage;

public class TC1_LoginTest extends BaseLibrary {

	LoginPage loginPage;

	@Test
	public void loginTest1() {
		loginPage = new LoginPage(driver);
		driver.get(readConfig.getURL());
		logger.info("Test Started.");
		loginPage.setEmail(readConfig.getUsername());
		loginPage.setPassword(readConfig.getPassword());
		loginPage.clickOnLogin();
		if (driver.getTitle().equals(readConfig.getTitle())) {
			Assert.assertTrue(true);
			logger.info("Test Passed.");
		} else {
			captureScreen("loginTest");
			Assert.assertTrue(false);
			logger.info("Test Failed.");
		}
		loginPage.clickOnLogout();
		logger.info("Test Completed.");
	}
}
