package com.modifier.nbpapimodifier.exchangerates.response;

import com.modifier.nbpapimodifier.exchangerates.request.series.RateSeries;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class RatePLNtoCurrency {

    private final LocalDate date;
    private final BigDecimal plnRate;

    public RatePLNtoCurrency(RateSeries rateSeries) {
        this.date = rateSeries.getEffectiveDate();
        this.plnRate = BigDecimal.ONE.divide(rateSeries.getMid(), 4, RoundingMode.HALF_UP);
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getPlnRate() {
        return plnRate;
    }

    @Override
    public String toString() {
        return "RatePLNtoCurrency{" +
                "date=" + date +
                ", plnRate=" + plnRate +
                '}';
    }
}
