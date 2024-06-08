package conv.sample.converter.utility;

import org.junit.jupiter.api.Test;

class CurrencyValidatorTest {

    @Test
    void testValidCurrencyUSD() {
        if (CurrencyValidator.isValidCurrency("USD")) {
            System.out.println("testValidCurrencyUSD passed.");
        } else {
            System.out.println("testValidCurrencyUSD failed.");
        }
    }

    @Test
    void testInvalidCurrencyEmpty() {
        if (!CurrencyValidator.isValidCurrency("")) {
            System.out.println("testInvalidCurrencyEmpty passed.");
        } else {
            System.out.println("testInvalidCurrencyEmpty failed.");
        }
    }

    @Test
    void testInvalidCurrencyNull() {
        if (!CurrencyValidator.isValidCurrency(null)) {
            System.out.println("testInvalidCurrencyNull passed.");
        } else {
            System.out.println("testInvalidCurrencyNull failed.");
        }
    }

    @Test
    void testValidCurrencyGBP() {
        if (CurrencyValidator.isValidCurrency("GBP")) {
            System.out.println("testValidCurrencyGBP passed.");
        } else {
            System.out.println("testValidCurrencyGBP failed.");
        }
    }

    @Test
    void testValidCurrencyINR() {
        if (CurrencyValidator.isValidCurrency("INR")) {
            System.out.println("testValidCurrencyINR passed.");
        } else {
            System.out.println("testValidCurrencyINR failed.");
        }
    }

    @Test
    void testValidCurrencyAUD() {
        if (CurrencyValidator.isValidCurrency("AUD")) {
            System.out.println("testValidCurrencyAUD passed.");
        } else {
            System.out.println("testValidCurrencyAUD failed.");
        }
    }

    @Test
    void testValidCurrencyCAD() {
        if (CurrencyValidator.isValidCurrency("CAD")) {
            System.out.println("testValidCurrencyCAD passed.");
        } else {
            System.out.println("testValidCurrencyCAD failed.");
        }
    }

    @Test
    void testValidCurrencyCHF() {
        if (CurrencyValidator.isValidCurrency("CHF")) {
            System.out.println("testValidCurrencyCHF passed.");
        } else {
            System.out.println("testValidCurrencyCHF failed.");
        }
    }

    @Test
    void testValidCurrencyJPY() {
        if (CurrencyValidator.isValidCurrency("JPY")) {
            System.out.println("testValidCurrencyJPY passed.");
        } else {
            System.out.println("testValidCurrencyJPY failed.");
        }
    }
}
