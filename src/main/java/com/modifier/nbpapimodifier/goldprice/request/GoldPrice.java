package com.modifier.nbpapimodifier.goldprice.request;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldPrice {

    private LocalDate date;
    private BigDecimal price;

    @JsonGetter("date")
    public LocalDate getDate() {
        return date;
    }

    @JsonSetter("data")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonGetter("price")
    public BigDecimal getPrice() {
        return price;
    }

    @JsonSetter("cena")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoldPrice{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
