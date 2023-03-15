package com.front;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSVaddData {
    public static void main(String[] args) throws Exception {
        // Path to the CSV file
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";
        int rowIndex = getRow();
        // Line number to replace
        System.out.println(rowIndex);
        // New values to append to the last row
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
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, true))) {

            // Read all the rows into a List
            // Write the new values as a new row to the CSV file
            writer.writeNext(newValues);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original file name
        File tempFile = new File("back_end/demo/src/main/resources/temp.csv");
        File originalFile = new File(csvFilePath);
        if (originalFile.exists()) {
            //originalFile.delete();
        }
        tempFile.renameTo(originalFile);
    }
    private static int getRow() throws Exception {

        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {

            // Read all the rows into a List
            List<String[]> rows = reader.readAll();

            // Get the index of the last row
            int lastRowIndex = rows.size() - 1;

            // Print the last row index
            System.out.println("Last row index: " + lastRowIndex);
            // Read all the rows into a List
            System.out.println(lastRowIndex);
            return lastRowIndex;
        }
    }
}
