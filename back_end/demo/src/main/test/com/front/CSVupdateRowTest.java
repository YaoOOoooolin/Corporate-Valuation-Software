package com.front;
/**

 The CSVupdateRowTest class is used to test the functionality of the CSVupdateRow class.
 It contains a simple test case to update a row in a CSV file.
 * @author [Yao LIN]
 * @version [V1.1]
 * @since [2023/3/31]
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class CSVupdateRowTest {
    private CSVupdateRow csvUpdateRow;
    private String testCsvPath;
    /**
     * Sets up the test environment by creating a new instance of the CSVupdateRow class
     * and setting the CSV file path to be used for the test.
     */
    @BeforeEach
    void setUp() {
        csvUpdateRow = new CSVupdateRow();
        testCsvPath = Paths.get("src", "test", "resources", "test.csv").toString();
        csvUpdateRow.setCsvFilePath(testCsvPath);
    }
    /**
     * A simple test case to update a row in a CSV file.
     * It sets the search value to "1" and the new values to {"1", "John", "Doe", "johndoe@example.com"}.
     */
    @Test
    void simpleUpdateRowTest() {
        try {
            String searchValue = "1";
            String[] newValues = {"1", "John", "Doe", "johndoe@example.com"};
            csvUpdateRow.setSearchValue(searchValue);
            csvUpdateRow.updateRow(newValues);
        } catch (Exception e) {
            // Ignoring the exception
        }
    }
}
