/**

* This class reads data from a CSV file using Jackson's CsvMapper library. The path to the CSV file can be set using
* the setPath() method. The readData() method reads the data from the file and stores it in three ArrayLists - one for
* company names, one for country names, and one for industry names. It also stores the data for a specified company,
* country, or industry in a resultList ArrayList. The column to be searched for and its value are determined based on
* the input values for the company, country, and industry names. If the path is not set, it defaults to the TestData.csv
* file in the resources folder.
* The main() method demonstrates how to use the class by setting a company name and calling the readData() method to
* retrieve the data for that company. The result is printed to the console.
* @author [Yao LIN]
* @version [V1.1]
* @since [2023/3/31]
*/
package com.front;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

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


    public void setPath(String path) {
        this.path = path;
    }

    String path = " ";
    public void readData() {
        // Path to the CSV file
//        String csvFilePath = "/Users/allan/GRPTeam14/back_end/demo/src/main/java/com/front/TestData.csv";
        URL urlPath = CSVreadData.class.getResource("TestData.csv");

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

        if (!Objects.equals(path, " ")){
            try {
                MappingIterator<Map<String, String>> iterator = mapper.readerFor(Map.class)
                        .with(schema)
//                        .readValues(new BufferedReader(new InputStreamReader(urlPath.openStream())));
                    .readValues(new File(path));

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
    }


    public static void main(String[] args) {
        CSVreadData csVreadData = new CSVreadData();
        csVreadData.setCompanyName("AMD");
        csVreadData.readData();
        System.out.println(csVreadData.resultList);
    }
}
