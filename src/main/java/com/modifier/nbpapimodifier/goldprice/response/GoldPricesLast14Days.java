package com.modifier.nbpapimodifier.goldprice.response;

import com.modifier.nbpapimodifier.goldprice.request.GoldPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class GoldPricesLast14Days {

    private final BigDecimal avgPrice;
    private final GoldPrice[] goldPrices;

    public GoldPricesLast14Days(GoldPrice[] goldPrices) {
        this.goldPrices = goldPrices;
        BigDecimal sum = BigDecimal.ZERO;
        for(GoldPrice goldPrice : goldPrices) {
            sum = sum.add(goldPrice.getPrice());
        }
        this.avgPrice = sum.divide(new BigDecimal("14"), 2, RoundingMode.HALF_UP);
    }

    public GoldPrice[] getGoldPrices() {
        return goldPrices;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    @Override
    public String toString() {
        return "GoldPricesLast14Days{" +
                "goldPrices=" + Arrays.toString(goldPrices) +
                ", avgPrice=" + avgPrice +
                '}';
    }
}
