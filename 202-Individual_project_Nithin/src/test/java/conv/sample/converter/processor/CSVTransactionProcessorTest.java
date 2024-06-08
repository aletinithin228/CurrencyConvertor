package conv.sample.converter.processor;

import conv.sample.converter.CurrencyConversionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class CsvTransacProcessorTest {

    private CsvTransacProcessor processor;
    private final String inputFilePath = "src/test/resources/input.csv";
    private final String outputFilePath = "src/test/resources/output.csv";
    private final String expectedOutputFilePath = "src/test/resources/expected_output.csv";

    @BeforeEach
    void setUp() {
        processor = new CsvTransacProcessor();
    }

    @Test
    void testProcessTransactions() {
        try {
            processor.processTransactions(inputFilePath, outputFilePath);

            File outputFile = new File(outputFilePath);
            if (outputFile.exists()) {
                String expectedOutput = new String(Files.readAllBytes(Paths.get(expectedOutputFilePath)));
                String actualOutput = new String(Files.readAllBytes(Paths.get(outputFilePath)));
                if (expectedOutput.equals(actualOutput)) {
                    System.out.println("testProcessTransactions passed.");
                } else {
                    System.out.println("testProcessTransactions failed: output does not match expected output.");
                    System.out.println("Expected Output:");
                    System.out.println(expectedOutput);
                    System.out.println("Actual Output:");
                    System.out.println(actualOutput);

                    List<String> expectedLines = Files.readAllLines(Paths.get(expectedOutputFilePath));
                    List<String> actualLines = Files.readAllLines(Paths.get(outputFilePath));
                    for (int i = 0; i < Math.min(expectedLines.size(), actualLines.size()); i++) {
                        if (!expectedLines.get(i).equals(actualLines.get(i))) {
                            System.out.println("Difference at line " + (i + 1) + ":");
                            System.out.println("Expected: " + expectedLines.get(i));
                            System.out.println("Actual  : " + actualLines.get(i));
                        }
                    }
                }
            } else {
                System.out.println("testProcessTransactions failed: output file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("testProcessTransactions failed: " + e.getMessage());
        }
    }

    @Test
    void testProcessEmptyFile() {
        String emptyInputFilePath = "src/test/resources/empty_input.csv";
        String emptyOutputFilePath = "src/test/resources/empty_output.csv";

        // Create an empty input file
        try {
            Files.write(Paths.get(emptyInputFilePath), new byte[0]);
        } catch (IOException e) {
            System.out.println("Failed to create empty input file: " + e.getMessage());
            return;
        }

        try {
            processor.processTransactions(emptyInputFilePath, emptyOutputFilePath);

            File outputFile = new File(emptyOutputFilePath);
            if (outputFile.exists()) {
                String actualOutput = new String(Files.readAllBytes(Paths.get(emptyOutputFilePath)));
                if (actualOutput.trim().isEmpty()) {
                    System.out.println("testProcessEmptyFile passed.");
                } else {
                    System.out.println("testProcessEmptyFile failed: output file is not empty.");
                }
            } else {
                System.out.println("testProcessEmptyFile failed: output file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("testProcessEmptyFile failed: " + e.getMessage());
        }
    }

    @Test
    void testProcessInvalidFileFormat() {
        String invalidInputFilePath = "src/test/resources/invalid_input.csv";

        // Create an invalid input file
        String invalidContent = "Invalid,CSV,Content";
        try {
            Files.write(Paths.get(invalidInputFilePath), invalidContent.getBytes());
        } catch (IOException e) {
            System.out.println("Failed to create invalid input file: " + e.getMessage());
            return;
        }

        try {
            processor.processTransactions(invalidInputFilePath, outputFilePath);
            System.out.println("testProcessInvalidFileFormat failed: exception was not thrown.");
        } catch (CurrencyConversionException e) {
            if (e.getMessage().contains("Error processing CSV file")) {
                System.out.println("testProcessInvalidFileFormat passed.");
            } else {
                System.out.println("testProcessInvalidFileFormat failed: unexpected exception message: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("testProcessInvalidFileFormat failed: " + e.getMessage());
        }
    }
}
