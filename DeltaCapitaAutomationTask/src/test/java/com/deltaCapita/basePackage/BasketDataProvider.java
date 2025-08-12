package com.deltaCapita.basePackage;

import org.testng.annotations.DataProvider;

import com.deltaCapita.genericPackage.ExcelUtilityTest;

public class BasketDataProvider {

	String EXCEL_TC_PATH="./src/test/java/testData/BasketTestCases.xlsx";
	@DataProvider(name = "basketData")
	public Object[][] getBasketData( ) {
		return ExcelUtilityTest.getTestData(EXCEL_TC_PATH,"TestCases");
	}

}
