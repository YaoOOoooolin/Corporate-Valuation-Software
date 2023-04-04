package com.front;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVaddData {

    public void Add(String a, String b, String c, String d, String e1, String f, String g, String h, String i, String j, String k, String l, String m, String n, String o, String p) throws Exception {

        // Path to the CSV file
        String csvFilePath = "GRPTeam14/back_end/demo/src/main/resources/TestData.csv";

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        try {
            // Read all the rows into a List
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new File(csvFilePath));

            List<Map<String, String>> rows = iterator.readAll();

            // New values to append to the last row
            String[] newValues = {a, b, c, d, e1, f, g, h, i, j, k, l, m, n, o, p};

            // Add the new row
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> newRow = objectMapper.convertValue(newValues, Map.class);
            rows.add(newRow);

            // Write the updated rows back to the CSV file
            CsvSchema csvSchema = csvMapper.schemaFor(Map.class).withHeader();
            SequenceWriter sequenceWriter = csvMapper.writer(csvSchema)
                    .writeValues(new File(csvFilePath));

            for (Map<String, String> row : rows) {
                sequenceWriter.write(row);
            }
            sequenceWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CSVaddData csvAddData = new CSVaddData();
        csvAddData.Add("Value1", "Value2", "Value3", "Value4", "Value5", "Value6", "Value7", "Value8", "Value9", "Value10", "Value11", "Value12", "Value13", "Value14", "Value15", "Value16");
    }
}
