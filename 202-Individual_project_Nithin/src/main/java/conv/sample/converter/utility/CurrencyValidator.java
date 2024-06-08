package conv.sample.converter.utility;


import java.util.Arrays;

import java.util.HashSet;

import java.util.Set;


public class CurrencyValidator {

    private static final Set<String> validCurrencies = new HashSet<>(Arrays.asList("USD", "EUR", "GBP", "INR", "AUD", "CAD", "CHF", "JPY"));


    public static boolean isValidCurrency(String currencyCode) {

        return validCurrencies.contains(currencyCode);

    }

}