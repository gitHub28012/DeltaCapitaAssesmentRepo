package com.deltaCapita.genericPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketCostCalculatorHelperTest {
	
	private static Map<String, Integer> priceMap = new HashMap<>();
    private static Map<String, String> offerMap = new HashMap<>();

    
    /**
     * This method is used to load the excel sheet to map..
     * @param excelPath
     * @param sheetName
     */
    public static void loadDataFromExcel(String excelPath,String sheetName){
        priceMap = ExcelUtilityTest.readPrices(excelPath,sheetName);
        offerMap = ExcelUtilityTest.readOffers(excelPath, sheetName);
    }

    
    /**
     * This method is used get the Total cost of basket added Fruits
     * @param basket
     * @return
     */
    public static int calculateTotalCost(List<String> basket) {
        if (basket == null || basket.isEmpty()) {
            return 0;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (String item : basket) {
            if (!priceMap.containsKey(item)) {
                throw new IllegalArgumentException("Unknown item: " + item);
            }
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        int total = 0;

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String item = entry.getKey();
            int qty = entry.getValue();
            int price = priceMap.get(item);
            String offer = offerMap.getOrDefault(item, "NONE");

            switch (offer) {
                case "BOGOF":
                    total += (qty / 2 + qty % 2) * price;
                    break;
                case "THREE_FOR_TWO":
                    total += ((qty / 3) * 2 + qty % 3) * price;
                    break;
                default:
                    total += qty * price;
                    break;
            }
        }
        return total;
    }

}
