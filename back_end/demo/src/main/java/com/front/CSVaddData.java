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
    public void Add(String a,String b,String c,String d,String e1,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p) throws Exception {
        // Path to the CSV file
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";
        int rowIndex = getRow();
        // Line number to replace
        System.out.println(rowIndex);
        // New values to append to the last row
        String newValue1 = a;
        String newValue2 = b;
        String newValue3 = c;
        String newValue4 = d;
        String newValue5 = e1;
        String newValue6 = f;
        String newValue7 = g;
        String newValue8 = h;
        String newValue9 = i;
        String newValue10 = j;
        String newValue11 = k;
        String newValue12 = l;
        String newValue13 = m;
        String newValue14 = n;
        String newValue15 = o;
        String newValue16 = p;
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
