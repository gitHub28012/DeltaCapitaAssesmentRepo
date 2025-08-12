package com.deltaCapita.genericPackage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Tanmay 12-08-2025
 *
 */
public class ExcelUtilityTest {

	private static Workbook wb;
	private static Sheet sheet;

	/**
	 * 
	 * used for read the prices associated for fruits from given sheet
	 * 
	 * @param fileName
	 * @param sheetName
	 * @return
	 */
	public static Map<String, Integer> readPrices(String fileName, String sheetName) {
		Map<String, Integer> priceMap = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);
			sheet = wb.getSheet(sheetName);

			for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				String fruit = currentRow.getCell(0).getStringCellValue().trim();
				int price = (int) currentRow.getCell(1).getNumericCellValue();
				priceMap.put(fruit, price);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceMap;
	}

	/**
	 * used for read the offers associated for fruits from given sheet
	 * 
	 * @param fileName
	 * @param sheetName
	 * @return
	 */
	public static Map<String, String> readOffers(String fileName, String sheetName) {
		Map<String, String> offerMap = new HashMap<>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);
			sheet = wb.getSheet(sheetName);

			for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				String fruit = currentRow.getCell(0).getStringCellValue().trim();
				String offer = currentRow.getCell(2).getStringCellValue();
				offerMap.put(fruit, offer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return offerMap;
	}

	public static Object[][] getTestData(String filePath, String sheetName) {
		List<Object[]> dataList = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);

				String testCaseId = row.getCell(0).getStringCellValue().trim();
				String description = row.getCell(1).getStringCellValue().trim();
				String basketItems = row.getCell(2) != null ? row.getCell(1).getStringCellValue().trim() : "";
				int expected = (int) row.getCell(3).getNumericCellValue();

				@SuppressWarnings("unchecked")
				List<String> basket = (List<String>) (basketItems.isEmpty() ? Collections.emptyList()
						: Arrays.asList(basketItems.split(",")));

				dataList.add(new Object[] { testCaseId, description, basket, expected });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList.toArray(new Object[0][]);
	}
}
