package com.modifier.nbpapimodifier;

import com.modifier.nbpapimodifier.exchangerates.request.series.ExchangeRatesSeries;
import com.modifier.nbpapimodifier.exchangerates.request.tables.ExchangeRatesTable;
import com.modifier.nbpapimodifier.exchangerates.request.tables.RateTables;
import com.modifier.nbpapimodifier.exchangerates.response.ExchangeRatesLastDays;
import com.modifier.nbpapimodifier.goldprice.request.GoldPrice;
import com.modifier.nbpapimodifier.goldprice.response.GoldPricesLastDays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class ApplicationController {
    private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);
    private static final String nbpUri = "https://api.nbp.pl/api";
    private final List<String> aTableCodes;

    public ApplicationController() {
        aTableCodes = new ArrayList<String>();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            String path = "/exchangerates/tables/a";
            ExchangeRatesTable[] arrayOfERT;
            RateTables[] rateTables;
            try {
                arrayOfERT = restTemplate.getForObject(nbpUri + path, ExchangeRatesTable[].class);
                assert arrayOfERT != null;
                rateTables = arrayOfERT[0].getRates();
                for (RateTables rateTable : rateTables) {
                    aTableCodes.add(rateTable.getCode());
                }
            } catch (RestClientException error) {
                log.error(error.toString());
            }
            log.info(aTableCodes.toString());
        };
    }

    @GetMapping("/api/exchange-rates/{currencyCode}")
    public ExchangeRatesLastDays getLastFiveBusinessDaysExchangeRates(@PathVariable("currencyCode") String currencyCode, RestTemplate restTemplate) {
        String tableName = (aTableCodes.contains(currencyCode.toUpperCase(Locale.ROOT)) ? "a" : "b");
        int numberOfLastDays = (tableName.equals("a") ? 5 : 1);     // currencies rate from table B are updated only once a week,
                                                                    // so then it should return only one rate record

        String reqUri = String.format("/exchangerates/rates/%s/%s/last/%d", tableName, currencyCode, numberOfLastDays);
        ExchangeRatesSeries exchangeRatesSeries = restTemplate.getForObject(nbpUri + reqUri, ExchangeRatesSeries.class);

        assert exchangeRatesSeries != null;

        return new ExchangeRatesLastDays(exchangeRatesSeries, numberOfLastDays);
    }

    @GetMapping("/api/gold-price/average")
    public GoldPricesLastDays getGoldPrice(RestTemplate restTemplate) {
        String reqUri = "/cenyzlota/last/";
        int numberOfLastDays = 14;
        GoldPrice[] goldPrice = restTemplate.getForObject(String.format("%s%s%d", nbpUri, reqUri, numberOfLastDays), GoldPrice[].class);

        assert goldPrice != null;
        return new GoldPricesLastDays(goldPrice, numberOfLastDays);
    }
}
