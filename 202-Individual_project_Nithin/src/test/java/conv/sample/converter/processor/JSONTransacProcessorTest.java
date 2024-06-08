package conv.sample.converter.processor;

import conv.sample.converter.CurrencyConversionException;
import conv.sample.converter.model.Transac;
import conv.sample.converter.model.TransacResult;
import conv.sample.converter.model.TransacResultList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonTransacProcessorTest {

    private JsonTransacProcessor processor;
    private final String inputFilePath = "src/test/resources/input.json";
    private final String outputFilePath = "src/test/resources/transactions_result.json";

    @BeforeEach
    void setUp() {
        processor = new JsonTransacProcessor();
    }

    @Test
    void testProcessTransactions() {
        try {
            List<Transac> transactions = new ArrayList<>();
            Transac transac1 = new Transac();
            transac1.setOriginalCurrency("USD");
            transac1.setTargetCurrency("EUR");
            transac1.setAmount(1000);
            transactions.add(transac1);

            Transac transac2 = new Transac();
            transac2.setOriginalCurrency("EUR");
            transac2.setTargetCurrency("GBP");
            transac2.setAmount(500);
            transactions.add(transac2);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(inputFilePath), transactions);

            processor.processTransactions(inputFilePath, outputFilePath);

            File outputFile = new File(outputFilePath);
            if (outputFile.exists()) {
                System.out.println("Output file exists.");
                TransacResultList resultList = mapper.readValue(outputFile, TransacResultList.class);
                List<TransacResult> results = resultList.getResults();

                if (results.size() == 2) {
                    System.out.println("Correct number of results.");
                } else {
                    System.out.println("Incorrect number of results.");
                }

                TransacResult result1 = results.get(0);
                if (result1.getOriginalAmount() == 1000 &&
                        "USD".equals(result1.getOriginalCurrency()) &&
                        "EUR".equals(result1.getTargetCurrency()) &&
                        result1.getErrorMessage() == null) {
                    System.out.println("First transaction processed correctly.");
                } else {
                    System.out.println("First transaction processed incorrectly.");
                }

                TransacResult result2 = results.get(1);
                if (result2.getOriginalAmount() == 500 &&
                        "EUR".equals(result2.getOriginalCurrency()) &&
                        "GBP".equals(result2.getTargetCurrency()) &&
                        result2.getErrorMessage() == null) {
                    System.out.println("Second transaction processed correctly.");
                } else {
                    System.out.println("Second transaction processed incorrectly.");
                }
            } else {
                System.out.println("Output file does not exist.");
            }
        } catch (IOException | CurrencyConversionException e) {
            System.out.println("testProcessTransactions failed: " + e.getMessage());
        }
    }
}
