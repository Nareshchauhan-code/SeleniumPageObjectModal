package com.nopcommerce_V5.utlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsUtils {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;
	public String sheetName;

	public XlsUtils(String path, String sheetName) {
		this.path = path;
		this.sheetName = sheetName;
	}

	public int getRowCount() {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			fis.close();
			workbook.close();
			return rowCount;
		} catch (Exception e) {
			return 0;
		}
	}

	public int getColumnCount() {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			int columnCount = row.getLastCellNum();
			fis.close();
			workbook.close();
			return columnCount;
		} catch (Exception e) {
			return 0;
		}
	}

	public String getCell(int rowNo, int columnNo) {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNo);
			cell = row.getCell(columnNo);
			fis.close();
			workbook.close();
			return cell.getStringCellValue();
		} catch (Exception e) {
			return null;
		}
	}
}
