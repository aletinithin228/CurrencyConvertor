package conv.sample.converter.utility;


import conv.sample.converter.CurrencyConversionException;


import java.util.HashMap;

import java.util.Map;


public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();


    static {

        exchangeRates.put("USD_EUR", 0.94);

        exchangeRates.put("EUR_GBP", 0.86);

        exchangeRates.put("GBP_INR", 103.98);

        exchangeRates.put("AUD_CAD", 0.89);

        exchangeRates.put("CAD_USD", 0.73);

        exchangeRates.put("CHF_AUD", 1.69);

        exchangeRates.put("USD_CHF", 0.91);

        exchangeRates.put("JPY_USD", 0.0065);

        exchangeRates.put("EUR_USD", 1.06);

        exchangeRates.put("GBP_EUR", 1.16);

        exchangeRates.put("INR_GBP", 0.009);

        exchangeRates.put("CAD_AUD", 1.123);

        exchangeRates.put("USD_CAD", 1.36);

        exchangeRates.put("AUD_CHF", 0.59);

        exchangeRates.put("CHF_USD", 1.098);

        exchangeRates.put("USD_JPY", 153.8);

    }


    public static double convert(double amount, String fromCurrency, String toCurrency) throws CurrencyConversionException {

        String key = fromCurrency + "_" + toCurrency;

        Double rate = exchangeRates.get(key);


        if (rate == null) {

            throw new CurrencyConversionException("Exchange rate not found for " + fromCurrency + " to " + toCurrency);

        }


        return amount * rate;

    }

}