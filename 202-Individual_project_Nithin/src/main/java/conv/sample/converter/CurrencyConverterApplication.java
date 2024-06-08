package conv.sample.converter;


import conv.sample.converter.processor.TransacProcessor;

import conv.sample.converter.processor.TransacProcessorFactory;


public class CurrencyConverterApplication {


    public static void main(String[] args) {

        if (args.length != 2) {

            System.out.println("Usage: CurrencyConverterApplication <inputFile> <outransactionProcessorutFile>");

            return;

        }


        String inputFile = args[0];

        String outransactionProcessorutFile = args[1];


        try {

            TransacProcessor processor = TransacProcessorFactory.getProcessor(inputFile);

            processor.processTransactions(inputFile, outransactionProcessorutFile);

        } catch (CurrencyConversionException e) {

            System.err.println("Error processing transactions: " + e.getMessage());

        }

    }

}