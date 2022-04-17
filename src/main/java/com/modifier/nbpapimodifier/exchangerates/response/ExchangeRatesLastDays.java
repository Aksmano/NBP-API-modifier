package com.modifier.nbpapimodifier.exchangerates.response;

import com.modifier.nbpapimodifier.exchangerates.request.series.ExchangeRatesSeries;
import com.modifier.nbpapimodifier.exchangerates.request.series.RateSeries;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExchangeRatesLastDays {
    private final String name;
    private final String code;
    private final BigDecimal avgRate;
    private final RatePLNtoCurrency[] rates;

    public ExchangeRatesLastDays(ExchangeRatesSeries exchangeRatesSeries, int ratesAmount) {
        this.name = exchangeRatesSeries.getCurrency();
        this.code = exchangeRatesSeries.getCode();
        this.rates = new RatePLNtoCurrency[ratesAmount];
        BigDecimal avgRateSum = BigDecimal.ZERO;
        RateSeries[] rateSeries = exchangeRatesSeries.getRates();
        for(int i = 0; i < ratesAmount; i++) {
            this.rates[i] = new RatePLNtoCurrency(rateSeries[i]);
            avgRateSum = avgRateSum.add(this.rates[i].getPlnRate());
        }
        this.avgRate = avgRateSum.divide(new BigDecimal(this.rates.length), 4, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getAvgRate() {
        return avgRate;
    }

    public RatePLNtoCurrency[] getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesLastDays{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", avgRate=" + avgRate +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
