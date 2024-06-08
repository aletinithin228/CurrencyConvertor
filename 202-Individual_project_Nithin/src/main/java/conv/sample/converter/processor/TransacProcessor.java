package conv.sample.converter.processor;


import conv.sample.converter.CurrencyConversionException;


public abstract class TransacProcessor {

    public abstract void processTransactions(String inputFile, String outransactionProcessorutFile) throws CurrencyConversionException;

}