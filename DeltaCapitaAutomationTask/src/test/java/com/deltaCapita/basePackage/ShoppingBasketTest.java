package com.deltaCapita.basePackage;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.deltaCapita.genericPackage.BasketCostCalculatorHelperTest;

public class ShoppingBasketTest extends BaseBasketClass {

	@Test(dataProvider = "basketData", dataProviderClass = BasketDataProvider.class)
	public void testBasketTotal(String testCaseId, String description, List<String> basket, int expectedCost) {
		int actualCost = BasketCostCalculatorHelperTest.calculateTotalCost(basket);
		Assert.assertEquals(actualCost, expectedCost, "Failed for: " + testCaseId + " : " + description);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testUnknownItem() {
		BasketCostCalculatorHelperTest.calculateTotalCost(List.of("Apple", "Chocolate"));
	}
}
