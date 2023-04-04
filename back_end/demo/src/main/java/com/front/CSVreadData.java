package com.front;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CSVreadData {
    // ... (Getter and Setter methods, and instance variables)
    public ArrayList<String> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(ArrayList<String> companyList) {
        this.companyList = companyList;
    }

    public ArrayList<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(ArrayList<String> countryList) {
        this.countryList = countryList;
    }

    public ArrayList<String> getIndustryList() {
        return industryList;
    }

    public void setIndustryList(ArrayList<String> industryList) {
        this.industryList = industryList;
    }
    ArrayList<String> companyList = new ArrayList<>();
    ArrayList<String> countryList = new ArrayList<>();
    ArrayList<String> industryList = new ArrayList<>();
    public ArrayList<String> getResultList() {
        return resultList;
    }
    public void setResultList(ArrayList<String> resultList) {
        this.resultList = resultList;
    }
    ArrayList<String> resultList = new ArrayList<>();
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getIndustryName() {
        return industryName;
    }
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    String countryName = "";
    String industryName = "";
    String companyName = "";
    public void readData() {
        // Path to the CSV file
//        String csvFilePath = "/Users/allan/GRPTeam14/back_end/demo/src/main/java/com/front/TestData.csv";
        URL path = CSVreadData.class.getResource("TestData.csv");
//        if (csvFilePath.isEmpty()) {
//            csvFilePath = "src/main/resources/TestData.csv";
//            if (csvFilePath.isEmpty()){
//                csvFilePath = "TestData.csv";
//            }
//        }
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        String country = getCountryName();
        String industry = getIndustryName();
        String company = getCompanyName();
        String column = "";
        String value = "";
        if (industry.equals("") & company.equals("")) {
            column = "Country";
            value = country;
        } else if (country.equals("") & industry.equals("")) {
            column = "Name";
            value = company;
        } else {
            column = "Industry";
            value = industry;
        }

        try {
            MappingIterator<Map<String, String>> iterator = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new BufferedReader(new InputStreamReader(path.openStream())));
//                    .readValues(new File(csvFilePath));

            while (iterator.hasNext()) {
                Map<String, String> row = iterator.next();

                // Check if the value matches the specified column
                if (row.get(column).equals(value)) {
                    String companyName = row.get("Name");
                    String countryName = row.get("Country");
                    String industryName = row.get("Industry");

                    companyList.add(companyName);
                    countryList.add(countryName);
                    industryList.add(industryName);

                    if (!companyName.equals("")) {
                        resultList.addAll(Arrays.asList(row.values().toArray(new String[0])).subList(0, 16));
                    }
                } else if (industryName.equals("box")) {
                    String industryName = row.get("Industry");
                    industryList.add(industryName);
                } else if (countryName.equals("cty")) {
                    String countryName = row.get("Country");
                    countryList.add(countryName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        CSVreadData csVreadData = new CSVreadData();
        csVreadData.setCompanyName("AMD");
        csVreadData.readData();
        System.out.println(csVreadData.resultList);
    }
}
