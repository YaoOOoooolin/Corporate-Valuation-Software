package com.front;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVreadData {

    public static void main(String[] args) {

        // Path to the CSV file
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";

        String column = "Country";
        String value = "United States";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {

            // Read the header row
            String[] header = reader.readNext();

            // Find the index of the "Country" column
            int countryColumnIndex = -1;
            for (int i = 0; i < header.length; i++) {
                if (header[i].equals(column)) {
                    countryColumnIndex = i;
                    break;
                }
            }

            // Throw an exception if the "Country" column isn't found
            if (countryColumnIndex == -1) {
                throw new RuntimeException("The 'Country' column was not found in the CSV file.");
            }

            // Loop through the rest of the rows
            String[] row;
            while ((row = reader.readNext()) != null) {

                // Check if the country is "China"
                if (row[countryColumnIndex].equals(value)) {

                    // Extract the company name
                    String companyName = row[0]; // Assumes that the company name is in the first column
                    String countryName = row[1];
                    String industryName = row[2];
                    // Print the company name
                    System.out.println(companyName);
                    System.out.println(countryName);
                    System.out.println(industryName);
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
