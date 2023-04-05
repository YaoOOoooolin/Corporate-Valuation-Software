/**

* This class is responsible for adding new data to a CSV file.
* The CSV file path is set through the setCsvFilePath() method.
* The addData() method takes an array of Strings as input and appends a new row to the CSV file.
* The Add() method takes 16 Strings as input and calls the addData() method with the provided values.
* The class also provides a method for copying a file from a source to a destination.
* @author [Yao LIN]
* @version [V1.1]
* @since [2023/3/31]
*/
package com.front;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class CSVaddData {

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }



    public String csvFilePath;
    public String csvBackupFilePath;
    String[] newValues;
    
    /**
    * Adds a new row to the CSV file with the provided values.
    * 
    * @param list An array of Strings representing the values to add to the CSV file.
    * @throws Exception If an error occurs while adding the data to the CSV file.
    */
    public void addData(String[] list) throws Exception{
        csvFilePath = Login.filepath;

//        csvBackupFilePath = "/Users/allan/GRPTeam14/back_end/demo/src/main/resources/com/front/newCSV.csv";
        String csvBackupFilePath = csvFilePath.substring(0, csvFilePath.lastIndexOf('.')) + "_backup" + csvFilePath.substring(csvFilePath.lastIndexOf('.'));
        // Read column names as header from CSV file
        List<String> columnNames = new ArrayList<>();
        try {
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new File(csvFilePath));
            if (iterator.hasNext()) {
                Map<String, String> row = iterator.next();
                columnNames.addAll(row.keySet());
                System.out.println("Column names:");
                System.out.println(columnNames);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read all the rows into a List
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(new File(csvFilePath));
        List<Map<String, String>> rows = iterator.readAll();

        // New values to append to the last row
        newValues = list;
        System.out.println("New values:");
        for (String value : newValues) {
            System.out.println(value);
        }

        // Add the new row
        Map<String, String> newRow = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            newRow.put(columnNames.get(i), newValues[i]);
        }
        rows.add(newRow);

// Add column names to backup schema
        CsvSchema.Builder csvBackupSchemaBuilder = CsvSchema.builder().setUseHeader(true);
        for (String columnName : columnNames) {
            csvBackupSchemaBuilder.addColumn(columnName);
        }
        CsvSchema csvBackupSchema = csvBackupSchemaBuilder.build().withLineSeparator("\r\n");

        SequenceWriter backupSequenceWriter = csvMapper.writerFor(Map.class)
                .with(csvBackupSchema)
                .writeValues(new File(csvBackupFilePath));

        backupSequenceWriter.writeAll(rows);
        backupSequenceWriter.close();

        // Replace the original CSV file with the backup file
        copyFile(new File(csvBackupFilePath), new File(csvFilePath));
        // Delete the backup file
        File backupFile = new File(csvBackupFilePath);
        if (!backupFile.delete()) {
            System.err.println("Failed to delete backup file: " + backupFile.getAbsolutePath());
        }


    }
    /**

    * Copies a file from the source location to the destination location.
    * @param source the source file to copy from
    * @param destination the destination file to copy to
    * @throws IOException if there is an error during the file copy process
    */
    private static void copyFile(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
/**

* Adds data with the provided values to the dataset.
*/
public void Add(String text, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String text12, String text13, String more_value1, String more_value2) {
        newValues = new String[]{text, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, more_value1, more_value2};
    try {
        addData(newValues);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    System.out.println("add success");
    }
}
