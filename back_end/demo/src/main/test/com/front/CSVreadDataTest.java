/**
 * This class is responsible for testing the {@link com.front.CSVreadData} class.
 * It tests the functionality of reading data from a CSV file.
 * @author [Yao LIN]
 * @version [V1.1]
 * @since [2023/3/31]
 */
package com.front;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVreadDataTest {
    private final String testCsvPath = "src/main/resources/com/front/TestData.csv";
    private final CSVreadData csvReadData = new CSVreadData();

    /**
     * Sets up the test environment before each test.
     * Copies the original CSV file to a test CSV file.
     *
     * @throws IOException if there's an issue with file operations.
     */
    @BeforeEach
    public void setUp() throws IOException {
        // Copy the original CSV file to TestData.csv
        Files.copy(Paths.get("src/main/resources/com/front/OriginalData.csv"),
                Paths.get(testCsvPath),
                StandardCopyOption.REPLACE_EXISTING);
        csvReadData.setPath(testCsvPath);
    }

    /**
     * Tests the {@link com.front.CSVreadData#readData()} method.
     * Ensures that the data is read correctly from the test CSV file.
     */
    @Test
    public void readDataTest() {
        csvReadData.setCompanyName("AMD");
        csvReadData.readData();

        // Check if the resultList is not empty
        assertTrue(!csvReadData.getResultList().isEmpty());

        // Check if the resultList contains the expected data
        String[] expectedData = {"AMD", "United States", "Semiconductors", "2022", "23,601,000", "1,272,000", "88,000", "54,750,000", "12,830,000", "yes", "5,855,000", "52,561,000", "0", "1,571,000", "82.11","" };
        assertEquals(Arrays.asList(expectedData), csvReadData.getResultList());
    }
}
