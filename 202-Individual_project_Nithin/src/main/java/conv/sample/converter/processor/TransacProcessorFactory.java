package conv.sample.converter.processor;


import conv.sample.converter.CurrencyConversionException;


public class TransacProcessorFactory {


    public static TransacProcessor getProcessor(String inputFile) throws CurrencyConversionException {

        if (inputFile.endsWith(".csv")) {

            return new CsvTransacProcessor();

        } else if (inputFile.endsWith(".json")) {

            return new JsonTransacProcessor();

        } else if (inputFile.endsWith(".xml")) {

            return new XmlTransacProcessor();

        } else {

            throw new CurrencyConversionException("Unsupported file format: " + inputFile);

        }

    }

}