package conv.sample.converter.processor;

import conv.sample.converter.CurrencyConversionException;
import conv.sample.converter.model.Transac;
import conv.sample.converter.model.TransactList;
import conv.sample.converter.model.TransacResult;
import conv.sample.converter.model.TransacResultList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XmlTransacProcessorTest {

    private XmlTransacProcessor processor;
    private final String inputFilePath = "src/test/resources/input.xml";
    private final String outputFilePath = "src/test/resources/output.xml";

    @BeforeEach
    void setUp() {
        processor = new XmlTransacProcessor();
    }

    @Test
    void testProcessTransactions() throws Exception {
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

        TransactList transactList = new TransactList();
        transactList.setTransactions(transactions);

        JAXBContext context = JAXBContext.newInstance(TransactList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(transactList, new File(inputFilePath));
        processor.processTransactions(inputFilePath, outputFilePath);

        JAXBContext resultContext = JAXBContext.newInstance(TransacResultList.class);
        Unmarshaller unmarshaller = resultContext.createUnmarshaller();
        TransacResultList resultList = (TransacResultList) unmarshaller.unmarshal(new File(outputFilePath));

        List<TransacResult> results = resultList.getResults();
        assertEquals(2, results.size());

        TransacResult result1 = results.get(0);
        assertEquals(1000, result1.getOriginalAmount());
        assertEquals("USD", result1.getOriginalCurrency());
        assertEquals("EUR", result1.getTargetCurrency());
        assertEquals("Success", result1.getErrorMessage());

        TransacResult result2 = results.get(1);
        assertEquals(500, result2.getOriginalAmount());
        assertEquals("EUR", result2.getOriginalCurrency());
        assertEquals("GBP", result2.getTargetCurrency());
        assertEquals("Success", result2.getErrorMessage());
    }
}
