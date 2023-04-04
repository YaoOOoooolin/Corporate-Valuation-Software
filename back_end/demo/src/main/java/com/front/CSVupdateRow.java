package com.front;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVupdateRow {

    public void Update(String a, String b, String c, String d, String e1, String f, String g, String h, String ii, String j, String k, String l, String m, String n, String o, String p) throws Exception {
        URL path = CSVreadData.class.getResource("TestData.csv");

        // Path to the CSV file
//        String csvFilePath = "src/main/java/com/front/TestData.csv";
        int rowIndex = getRow();
        System.out.println(rowIndex);

        String[] newValues = {a, b, c, d, e1, f, g, h, ii, j, k, l, m, n, o, p};

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        List<Map<String, String>> records;

        try {
            MappingIterator<Map<String, String>> iterator = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new BufferedReader(new InputStreamReader(path.openStream())));

            records = iterator.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading CSV file.");
        }

        if (rowIndex < 0 || rowIndex >= records.size()) {
            throw new RuntimeException("The specified line number is out of range.");
        }

        records.set(rowIndex, arrayToMap(newValues));

        try {
            mapper.writer(schema)
                    .writeValue(new File("src/main/resources/temp.csv"), records);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing CSV file.");
        }

        File tempFile = new File("src/main/resources/temp.csv");
        File originalFile = new File(path.toURI());
        if (originalFile.exists()) {
            originalFile.delete();
        }
        tempFile.renameTo(originalFile);
    }

    private static int getRow() throws Exception {
//        String csvFilePath = "src/main/resources/TestData.csv";
        URL path = CSVreadData.class.getResource("TestData.csv");
        String searchValue = "AMD";
        int rowIndex = -1;

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        try {
            MappingIterator<Map<String, String>> iterator = mapper.readerFor(Map.class)
                    .with(schema)
//                    .readValues(new File(csvFilePath));
                    .readValues(new BufferedReader(new InputStreamReader(path.openStream())));
            List<Map<String, String>> records = iterator.readAll();

            for (int i = 0; i < records.size(); i++) {
                Map<String, String> record = records.get(i);
                if (record.get("Name").equals(searchValue)) {
                    rowIndex = i;
                    System.out.println("Row index of \"" + searchValue + "\": " + rowIndex);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
        return rowIndex;
    }

    private Map<String, String> arrayToMap(String[] values) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Name", values[0]);
        map.put("Country", values[1]);
        map.put("Industry", values[2]);
        map.put("Year", values[3]);
        map.put("Revenue", values[4]);
        map.put("EBIT", values[5]);
        map.put("Operating Expenses", values[6]);
        map.put("Research and Development Expenses", values[7]);
        map.put("Cost and Expenses", values[8]);
        map.put("Operating Income", values[9]);
        map.put("Interest Expense", values[10]);
        map.put("EBIT Margin", values[11]);
        map.put("Book Value of Equity(Total shareholders equity)", values[12]);
        map.put("Book Value of debt(Total liabilities)", values[13]);
        map.put("Weighted Average Shares Outstanding (Diluted)", values[14]);
        map.put("Current stock price", values[15]);

        return map;
    }
}

