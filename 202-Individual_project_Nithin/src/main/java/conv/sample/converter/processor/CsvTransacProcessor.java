package conv.sample.converter.processor;


import conv.sample.converter.CurrencyConversionException;

import conv.sample.converter.model.Transac;

import conv.sample.converter.model.TransacResult;

import conv.sample.converter.utility.CurrencyConverter;

import conv.sample.converter.utility.CurrencyValidator;

import org.apache.commons.csv.CSVFormat;

import org.apache.commons.csv.CSVParser;

import org.apache.commons.csv.CSVPrinter;

import org.apache.commons.csv.CSVRecord;


import java.io.*;

import java.util.ArrayList;

import java.util.List;


public class CsvTransacProcessor extends TransacProcessor {


    @Override
    public void processTransactions(String inputFile, String outransactionProcessorutFile) throws CurrencyConversionException {

        List<TransacResult> results = new ArrayList<>();

        try (Reader reader = new FileReader(inputFile);

             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

             Writer writer = new FileWriter(outransactionProcessorutFile);

             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {


            for (CSVRecord record : csvParser) {

//                for (int i=0;i<csvParser.getRecords().size();i++) {

//                    CSVRecord record = csvParser.getRecords().get(i);

//                }

                if (record.get(0).equals("Amount")) continue;

                Transac transac = new Transac();

                transac.setOriginalCurrency(record.get(1));

                transac.setTargetCurrency(record.get(2));

                transac.setAmount(Double.parseDouble(record.get(0)));


                TransacResult result = processTransaction(transac);

                results.add(result);

            }

            csvPrinter.printRecord("Amount","OriginalCurrency","TargetCurrency","ConvertedAmount","Status");

            for (TransacResult result : results) {

                csvPrinter.printRecord(result.getOriginalAmount(), result.getOriginalCurrency(), result.getTargetCurrency(),

                         result.getConvertedAmount(), result.getErrorMessage());

            }


        } catch (IOException e) {

            throw new CurrencyConversionException("Error processing CSV file: " + e.getMessage());

        }

    }


    private TransacResult processTransaction(Transac transac) {

        TransacResult result = new TransacResult();

        result.setOriginalCurrency(transac.getOriginalCurrency());

        result.setTargetCurrency(transac.getTargetCurrency());

        result.setOriginalAmount(transac.getAmount());

        result.setErrorMessage("Success");


        if (!CurrencyValidator.isValidCurrency(transac.getOriginalCurrency()) ||
                !CurrencyValidator.isValidCurrency(transac.getTargetCurrency())) {

            result.setErrorMessage("Invalid currency code");

            return result;

        }


        try {

            double convertedAmount = CurrencyConverter.convert(transac.getAmount(),

                    transac.getOriginalCurrency(), transac.getTargetCurrency());

            result.setConvertedAmount(convertedAmount);

        } catch (CurrencyConversionException e) {

            result.setErrorMessage(e.getMessage());

        }


        return result;

    }

}