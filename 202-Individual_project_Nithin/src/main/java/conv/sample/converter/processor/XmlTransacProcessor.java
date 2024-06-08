package conv.sample.converter.processor;


import conv.sample.converter.CurrencyConversionException;

import conv.sample.converter.model.Transac;

import conv.sample.converter.model.TransactList;

import conv.sample.converter.model.TransacResult;

import conv.sample.converter.model.TransacResultList;

import conv.sample.converter.utility.CurrencyConverter;

import conv.sample.converter.utility.CurrencyValidator;


import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;

import javax.xml.bind.Marshaller;

import javax.xml.bind.Unmarshaller;

import java.io.File;

import java.util.ArrayList;

import java.util.List;


public class XmlTransacProcessor extends TransacProcessor {


    @Override
    public void processTransactions(String inputFile, String outransactionProcessorutFile) throws CurrencyConversionException {

        try {

            JAXBContext context = JAXBContext.newInstance(TransactList.class, TransacResultList.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            TransactList transactList = (TransactList) unmarshaller.unmarshal(new File(inputFile));


            List<TransacResult> results = new ArrayList<>();

            for (Transac transac : transactList.getTransactions()) {

                TransacResult result = processTransaction(transac);

                results.add(result);

            }


            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            TransacResultList resultList = new TransacResultList();

            resultList.setResults(results);

            marshaller.marshal(resultList, new File(outransactionProcessorutFile));


        } catch (JAXBException e) {

            throw new CurrencyConversionException("Error processing XML file: " + e.getMessage());

        }

    }


    private TransacResult processTransaction(Transac transac) {

        TransacResult result = new TransacResult();

        result.setOriginalAmount(transac.getAmount());

        result.setOriginalCurrency(transac.getOriginalCurrency());

        result.setTargetCurrency(transac.getTargetCurrency());

        result.setErrorMessage("Success");

        if (!CurrencyValidator.isValidCurrency(transac.getOriginalCurrency()) ||
                !CurrencyValidator.isValidCurrency(transac.getTargetCurrency())) {

            result.setErrorMessage("Invalid currency code");

            return result;

        } else {

            result.setErrorMessage("Success");

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