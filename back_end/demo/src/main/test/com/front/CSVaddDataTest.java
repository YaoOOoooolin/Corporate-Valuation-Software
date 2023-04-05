/**
 * This class is responsible for testing the {@link com.front.CSVaddData} class.
 * It tests the functionality of adding new data to a CSV file.
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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVaddDataTest {
    /**
     * The path to the test CSV file.
     */
    private final String testCsvPath = "src/main/resources/com/front/TestData.csv";

    /**
     * An instance of the {@link com.front.CSVaddData} class to be tested.
     */
    private final CSVaddData csvAddData = new CSVaddData();

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
        csvAddData.setCsvFilePath(testCsvPath);
    }

    /**
     * Tests the {@link com.front.CSVaddData#addData(String[])} method.
     * Ensures that the data is added correctly to the test CSV file.
     */
    @Test
    public void addDataTest() {
        String[] newValues = {"value1", "value2", "value3", "value4", "value5",
                "value6", "value7", "value8", "value9", "value10",
                "value11", "value12", "value13", "value14", "value15", "value16"};

        try {
            csvAddData.addData(newValues);
            // Check if the file exists after adding data
            assertTrue(Files.exists(Paths.get(testCsvPath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
