package com.front;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVupdateRow {

    public static void main(String[] args) throws Exception {

        // Path to the CSV file
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";


        int rowIndex = getRow();
        // Line number to replace
        System.out.println(rowIndex);
        // New values for the specified line
        String newValue1 = "1";
        String newValue2 = "2";
        String newValue3 = "3";
        String newValue4 = "3";
        String newValue5 = "3";
        String newValue6 = "3";
        String newValue7 = "3";
        String newValue8 = "3";
        String newValue9 = "3";
        String newValue10 = "3";
        String newValue11 = "3";
        String newValue12 = "3";
        String newValue13 = "3";
        String newValue14 = "3";
        String newValue15 = "3";
        String newValue16 = "3";
        String[] newValues = {newValue1, newValue2, newValue3,newValue4,newValue5,  newValue6,  newValue7,  newValue8,  newValue9,  newValue10,  newValue11,
                newValue12 ,
                newValue13 ,
                newValue14 ,
                newValue15 ,
                newValue16 };

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter("back_end/demo/src/main/resources/temp.csv"))) {

            // Read all the rows into a List
            List<String[]> rows = reader.readAll();

            // Throw an exception if the line number to replace is out of range
            if (rowIndex < 1 || rowIndex > rows.size()) {
                throw new RuntimeException("The specified line number is out of range.");
            }

            // Replace the values in the specified line
            rows.set(rowIndex - 1, newValues);

            // Write the updated rows to the temporary file
            writer.writeAll(rows);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original file name
        File tempFile = new File("back_end/demo/src/main/resources/temp.csv");
        File originalFile = new File(csvFilePath);
        if (originalFile.exists()) {
            originalFile.delete();
        }
        tempFile.renameTo(originalFile);
    }
    private static int getRow() throws Exception {
        
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";


        String searchValue = "AMD";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {

            String[] row;
            int rowIndex = -1;
            while ((row = reader.readNext()) != null) {
                rowIndex++;
                if (row.length > 0 && row[0].equals(searchValue)) {
                    System.out.println("Row index of \"" + searchValue + "\": " + rowIndex);
                    break;
                }
            }
            // Read all the rows into a List
            System.out.println(rowIndex);
           return rowIndex;
        }
    }
}

