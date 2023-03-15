package com.front;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVreadData {
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
        Controller controller = new Controller();
        // Path to the CSV file
        String csvFilePath = "back_end/demo/src/main/resources/TestData.csv";
        String country = getCountryName();
        String industry = getIndustryName();
        String company = getCompanyName();
//        System.out.println(country);
//        System.out.println(industry);
//        System.out.println(company);
        String column = "";
        String value = "";
        if (industry.equals("") & company.equals("")){
            column = "Country";
            value = country;
        } else if (country.equals("")&industry.equals("")) {
            column = "Name";
            value = company;
        }else{
            column = "Industry";
            value = industry;
        }

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
//                    System.out.println(companyName);
//                    System.out.println(countryName);
//                    System.out.println(industryName);
                    companyList.add(companyName);
                    countryList.add(countryName);
                    industryList.add(industryName);
                    if (!companyName.equals("")){
                        resultList.addAll(Arrays.asList(row).subList(0, 15));
                    }
                }else if (industryName.equals("box")){
                    String industryName = row[2];
                    industryList.add(industryName);
                } else if (countryName.equals("cty")) {
                    String countryName = row[1];
                    countryList.add(countryName);
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CSVreadData csVreadData = new CSVreadData();
        csVreadData.setCountryName("United States");
        csVreadData.readData();
        System.out.println(csVreadData.getCompanyList());
        System.out.println(csVreadData.getCountryList());
        System.out.println(csVreadData.getIndustryList());
    }
}
