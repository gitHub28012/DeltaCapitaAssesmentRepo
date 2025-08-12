package com.deltacapita.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.deltacapita.basket.BasketCostCalculator;

public class FinalCalulatorBasketTest {

	@Test
	public void testEmptyBasket() {
		int total = BasketCostCalculator.calculateTotalCost(List.of());
		Assert.assertEquals(total, 0, "Empty basket should cost 0");
	}

	@Test
	public void testSingleApple() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Apple"));
		Assert.assertEquals(total, 35);
	}

	@Test
	public void testMultipleDifferentItems() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Apple", "Banana"));
		Assert.assertEquals(total, 55);
	}

	@Test
	public void testMelonBuyOneGetOneFreeEvenCount() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Melon", "Melon"));
		Assert.assertEquals(total, 50, "Two melons should cost 50p with BOGO");
	}

	@Test
	public void testMelonBuyOneGetOneFreeOddCount() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Melon", "Melon", "Melon"));
		Assert.assertEquals(total, 100);
	}

	@Test
	public void testLimeThreeForTwo() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Lime", "Lime", "Lime"));
		Assert.assertEquals(total, 30, "3 limes should cost 30p with 3-for-2");
	}

	@Test
	public void testMixedBasketWithOffers() {
		int total = BasketCostCalculator.calculateTotalCost(List.of("Apple", "Melon", "Melon", "Lime", "Lime", "Lime"));
		Assert.assertEquals(total, 115);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testUnknownItem() {
		BasketCostCalculator.calculateTotalCost(List.of("Pineapple"));
	}

}
