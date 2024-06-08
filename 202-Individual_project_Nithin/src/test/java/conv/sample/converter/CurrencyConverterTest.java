package conv.sample.converter.utility;

import conv.sample.converter.CurrencyConversionException;
import org.junit.jupiter.api.Test;

class CurrencyConverterTest {

    @Test
    void testConvertUSDToEUR() {
        double amount = 1000;
        double expected = 1000 * 0.94;
        try {
            double actual = CurrencyConverter.convert(amount, "USD", "EUR");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertUSDToEUR passed.");
            } else {
                System.out.println("testConvertUSDToEUR failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertUSDToEUR failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertEURToGBP() {
        double amount = 500;
        double expected = 500 * 0.86;
        try {
            double actual = CurrencyConverter.convert(amount, "EUR", "GBP");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertEURToGBP passed.");
            } else {
                System.out.println("testConvertEURToGBP failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertEURToGBP failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertGBPToINR() {
        double amount = 100;
        double expected = 100 * 103.98;
        try {
            double actual = CurrencyConverter.convert(amount, "GBP", "INR");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertGBPToINR passed.");
            } else {
                System.out.println("testConvertGBPToINR failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertGBPToINR failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertExchangeRateNotFound() {
        try {
            CurrencyConverter.convert(100, "ABC", "XYZ");
            System.out.println("testConvertExchangeRateNotFound failed: exception was not thrown.");
        } catch (CurrencyConversionException e) {
            if (e.getMessage().contains("Exchange rate not found")) {
                System.out.println("testConvertExchangeRateNotFound passed.");
            } else {
                System.out.println("testConvertExchangeRateNotFound failed with unexpected message: " + e.getMessage());
            }
        }
    }

    @Test
    void testConvertUSDToJPY() {
        double amount = 100;
        double expected = 100 * 153.8;
        try {
            double actual = CurrencyConverter.convert(amount, "USD", "JPY");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertUSDToJPY passed.");
            } else {
                System.out.println("testConvertUSDToJPY failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertUSDToJPY failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertJPYToUSD() {
        double amount = 1000;
        double expected = 1000 * 0.0065;
        try {
            double actual = CurrencyConverter.convert(amount, "JPY", "USD");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertJPYToUSD passed.");
            } else {
                System.out.println("testConvertJPYToUSD failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertJPYToUSD failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertAUDToCAD() {
        double amount = 100;
        double expected = 100 * 0.89;
        try {
            double actual = CurrencyConverter.convert(amount, "AUD", "CAD");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertAUDToCAD passed.");
            } else {
                System.out.println("testConvertAUDToCAD failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertAUDToCAD failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertCHFToAUD() {
        double amount = 200;
        double expected = 200 * 1.69;
        try {
            double actual = CurrencyConverter.convert(amount, "CHF", "AUD");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertCHFToAUD passed.");
            } else {
                System.out.println("testConvertCHFToAUD failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertCHFToAUD failed with exception: " + e.getMessage());
        }
    }

    @Test
    void testConvertCADToUSD() {
        double amount = 300;
        double expected = 300 * 0.73;
        try {
            double actual = CurrencyConverter.convert(amount, "CAD", "USD");
            if (Math.abs(expected - actual) < 0.0001) {
                System.out.println("testConvertCADToUSD passed.");
            } else {
                System.out.println("testConvertCADToUSD failed: expected " + expected + " but got " + actual);
            }
        } catch (CurrencyConversionException e) {
            System.out.println("testConvertCADToUSD failed with exception: " + e.getMessage());
        }
    }
}
