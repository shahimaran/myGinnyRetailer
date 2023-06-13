package com.myGinnyRetailer.utils;

/*
* This class is not used in framework its just to check and verify the read data from Excel sheet.
* */

public class ReadTestData {
    public static void main(String[] args) {
        ReadExcelDataFile readData = new ReadExcelDataFile(System.getProperty("user.dir") + "/src/main/java/testData/Feature_File.xlsx");
        String sheetName = "Sheet1";
        String testName = "Test One";

        //find start row number of the test case

        int startRowNum= 0;
        while (!readData.getCellData(sheetName,0,startRowNum).equalsIgnoreCase(testName)){
        startRowNum++;
        }
        System.out.println("Test Start from Row Number : " + startRowNum);

        int startTestColumn = startRowNum+1;
        int startTestRow = startRowNum+2;

        //Find Number of the Rows of TestCase
        int row = 0;
        while (!readData.getCellData(sheetName,0,startTestRow+row).equals("")){
            row++;
        }

        System.out.println("Total number of the row in the test : " +testName + " is = " +row);

        //find number of column in test
        int column=0;
        while (!readData.getCellData(sheetName,column,startTestColumn).equals("")){
            column++;
        }
        System.out.println("Total number of the column in the test : " +testName + " is = " +column);


        for (int rowNumber=startTestRow; rowNumber<=startTestColumn+row; rowNumber++){
            for (int columnNumber=0; columnNumber<column; columnNumber++){
                System.out.println(readData.getCellData(sheetName,columnNumber,rowNumber));
            }
        }
    }
}
