package utils;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomParser {

    public static int parsePercentFromStringToInteger(String discount) {
        return Integer.parseInt(discount.replace("-", "").replace("%", ""));
    }

    public static Map<String, String> getPricingInfoAsMap(String text) {
        String[] priceInfoText = text.trim().split("\n");
        Map<String, String> pricingMap = new HashMap<>();
        pricingMap.put("discount", priceInfoText[0]);
        pricingMap.put("originalPrice", priceInfoText[1]);
        pricingMap.put("discountedPrice", priceInfoText[2]);
        return pricingMap;
    }
}
