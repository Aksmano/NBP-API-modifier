# NBP-API-modifier
Simple service written with Spring Boot, which return modified NBP API requests about currency rates and gold prices.

This application uses *[NBP Web API](https://api.nbp.pl/)* for fetching data about average currency rates and gold prices.

## Exposed endpoints:

> **Note:** Tomcat Server starts on port 8080 with no context path

### GET /api/exchange-rates/{currencyCode} 

> #### Returns JSON object with currency exchange rate PLN to {currencyCode} for the last 5 business days.
> Response parameters
> - **name -** name of the currency (names are in polish).
> - **code -** three letter currency code (*[ISO 4217 Standard](https://en.wikipedia.org/wiki/ISO_4217)*), e.g. USD.
> - **avgRate -** average exchange rate for the last 5 business days.
> - **rates -** array of exchange rates with publication days for last 5 businnes days.
> - **date -** publication date of exchange rate in the YYYY-MM-DD format.
> - **plnRate -** average exchange rate of PLN to {currencyCode}.
> 
> Query parameters
> - **currencyCode -** three letter currency code, e.g. USD.
> 
> Query example
>> GET **http://localhost:8080/api/exchange-rates/usd**
>> 
>> Response: {"name":"dolar amerykański","code":"USD","avgRate":0.2338,"rates":[{"date":"2022-04-11","plnRate":0.2348}, ...]}
>
> **Note:** some currencies are updated only once, so in their cases there is only one object in rates array

### GET /api/gold-price/average
> #### Returns JSON object average gold price for the last 14 business days
> Response parameters
> - **avgPrice -** average gold price for last 14 business days
> - **goldPrices -** array of gold prices with publication dates for last 14 business days
> - **date -** gold price publication date
> - **price -** gold price 
> Query example
>> GET **http://localhost:8080/api/gold-price/average**
>>
>> Response: {"avgPrice":265.08,"goldPrices":[{"date":"2022-03-29","price":266.46}, ...]}
