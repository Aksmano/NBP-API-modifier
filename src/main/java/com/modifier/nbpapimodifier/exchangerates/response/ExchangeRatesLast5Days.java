package com.modifier.nbpapimodifier.exchangerates.response;

import com.modifier.nbpapimodifier.exchangerates.request.series.ExchangeRatesSeries;
import com.modifier.nbpapimodifier.exchangerates.request.series.RateSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExchangeRatesLast5Days {
    private final String name;
    private final String code;
    private final RatePLNtoCurrency[] rates;

    public ExchangeRatesLast5Days(ExchangeRatesSeries exchangeRatesSeries) {
        this.name = exchangeRatesSeries.getCurrency();
        this.code = exchangeRatesSeries.getCode();
        this.rates = new RatePLNtoCurrency[5];
        RateSeries[] rateSeries = exchangeRatesSeries.getRates();
        for(int i = 0; i < 5; i++) {
            this.rates[i] = new RatePLNtoCurrency(rateSeries[i]);
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public RatePLNtoCurrency[] getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesPLNtoCurrency{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
