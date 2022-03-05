package com.nopcommerce_V5.baselibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce_V5.utlities.ReadConfig;
import com.nopcommerce_V5.utlities.XlsUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {

	public ReadConfig readConfig;
	public WebDriver driver;
	public Logger logger;
	public XlsUtils xlsUtils;

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		readConfig = new ReadConfig();
		xlsUtils = new XlsUtils(readConfig.getXlsPath(), readConfig.getXlsSheetName());
		logger = Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(String shotName) {
		try {
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/screenshots/" + shotName + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screen Captured");
		} catch (Exception e) {
			System.out.println("Screen capturing Failed : " + e);
		}
	}

}
