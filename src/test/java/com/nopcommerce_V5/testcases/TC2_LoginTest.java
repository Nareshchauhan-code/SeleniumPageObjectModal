package com.nopcommerce_V5.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce_V5.baselibrary.BaseLibrary;
import com.nopcommerce_V5.testpages.LoginPage;

public class TC2_LoginTest extends BaseLibrary {

	@Test(dataProvider = "data")
	public void loginTest2(String email, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		driver.get(readConfig.getURL());
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.clickOnLogin();
		Thread.sleep(5000);
		if (driver.getTitle().equals(readConfig.getTitle())) {
			loginPage.clickOnLogout();
			Assert.assertTrue(true);
		} else {
			captureScreen("loginTest2");
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "data")
	public String[][] loginData() {
		int rowCount = xlsUtils.getRowCount();
		int columnCount = xlsUtils.getColumnCount();
		String loginData[][] = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				String data = xlsUtils.getCell(i, j);
				loginData[i - 1][j] = data;
			}
		}
		return loginData;
	}
}
