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

public class CSVupdateRow {

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public String getCsvBackupFilePath() {
        return csvBackupFilePath;
    }

    public void setCsvBackupFilePath(String csvBackupFilePath) {
        this.csvBackupFilePath = csvBackupFilePath;
    }

    String csvFilePath;
    String csvBackupFilePath;
    String[] newValues;

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    String searchValue;
    public void updateRow(String[] list) throws Exception {

        csvFilePath = Login.filepath;
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

        // Find the row to update
        int rowIndexToUpdate = -1;


        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);
            if (row.get(columnNames.get(0)).equals(searchValue)) {
                rowIndexToUpdate = i;
                break;
            }
        }

        if (rowIndexToUpdate == -1) {
            System.err.println("Row not found: " + searchValue);
            return;
        }

        // New values to update the row
        newValues = list;

        // Update the row
        Map<String, String> updatedRow = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            updatedRow.put(columnNames.get(i), newValues[i]);
        }
        rows.set(rowIndexToUpdate, updatedRow);

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

    public void Update(String text, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String text12, String text13, String more_value1, String more_value2) {
        newValues = new String[]{text, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, more_value1, more_value2};
        try {
            updateRow(newValues);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("update success");
    }
}

