package com.deltacapita.basket;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BasketCostCalculator {

	// Defining prices in pence to avoid floating-point issues
	private static final Map<String, Integer> PRICES = Map.of("Apple", 35, "Banana", 20, "Melon", 50, "Lime", 15);

	 /**
     * Calculates the total cost of a shopping basket with special offers.
     *
     * @param basket A list of strings representing the items in the basket.
     * @return The total cost in pence.
     */
	public static int calculateTotalCost(List<String> basket) {
		  Map<String, Integer> itemCounts = new HashMap<>();
	        for (String item : basket) {
	            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
	        } 

	        int totalCost = 0;

	        // Calculate cost for Apples and Bananas (no offers)
	        totalCost += itemCounts.getOrDefault("Apple", 0) * PRICES.get("Apple");
	        totalCost += itemCounts.getOrDefault("Banana", 0) * PRICES.get("Banana");

	        // Calculate cost for Melons (Buy one get one free)
	        int melonCount = itemCounts.getOrDefault("Melon", 0);
	        int paidMelons = melonCount - (melonCount / 2);
	        totalCost += paidMelons * PRICES.get("Melon");

	        // Calculate cost for Limes (Three for the price of two)
	        int limeCount = itemCounts.getOrDefault("Lime", 0);
	        int freeLimes = limeCount / 3;
	        int paidLimes = limeCount - freeLimes;
	        totalCost += paidLimes * PRICES.get("Lime");

	        return totalCost;
	}
}
