package com.modifier.nbpapimodifier.exchangerates.request.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesTable {

    private String table;
    private String no;
    private LocalDate effectiveDate;
    private RateTables[] rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public RateTables[] getRates() {
        return rates;
    }

    public void setRates(RateTables[] rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesTable{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
