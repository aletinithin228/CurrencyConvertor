package conv.sample.converter.processor;


import conv.sample.converter.CurrencyConversionException;

import conv.sample.converter.model.Transac;

import conv.sample.converter.model.TransacResult;

import conv.sample.converter.model.TransacResultList;

import conv.sample.converter.utility.CurrencyConverter;

import conv.sample.converter.utility.CurrencyValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.type.CollectionType;


import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


public class JsonTransacProcessor extends TransacProcessor {


    @Override
    public void processTransactions(String inputFile, String outransactionProcessorutFile) throws CurrencyConversionException {

        ObjectMapper mapper = new ObjectMapper();

        TransacResultList transacResultList = new TransacResultList();

        List<TransacResult> results = new ArrayList<>();

        try {

            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Transac.class);

            List<Transac> transacs = mapper.readValue(new File(inputFile), listType);


            for (Transac transac : transacs) {

                TransacResult result = processTransaction(transac);

                results.add(result);

            }

            transacResultList.setResults(results);

            mapper.writeValue(new File(outransactionProcessorutFile), transacResultList);


        } catch (IOException e) {

            throw new CurrencyConversionException("Error processing JSON file: " + e.getMessage());

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