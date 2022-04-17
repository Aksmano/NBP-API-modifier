package com.modifier.nbpapimodifier.exchangerates.request.series;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesSeries {

    private String table;
    private String currency;
    private String code;
    private RateSeries[] rates;

    public ExchangeRatesSeries(){}

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RateSeries[] getRates() {
        return rates;
    }

    public void setRates(RateSeries[] rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesSeries{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}

