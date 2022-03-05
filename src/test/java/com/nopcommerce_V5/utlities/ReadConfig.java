package com.nopcommerce_V5.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		try {
			File file = new File("./src/test/resources/configfiles/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Error while reading config File : " + e);
		}
	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getTitle() {
		return prop.getProperty("title");
	}

	public String getXlsPath() {
		return prop.getProperty("xlspath");
	}

	public String getXlsSheetName() {
		return prop.getProperty("sheetname");
	}
}
