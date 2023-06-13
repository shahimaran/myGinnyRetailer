package com.myGinnyRetailer.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Hashtable;

public class TestDataProvider {

//     @Test(dataProvider = "getTestData")
//    public void sampleTestOne(Hashtable<String, String> table){
//         System.out.println(table.get("Col2"));
//
//     }

     /****************************** Get Data for Testcase ******************************/

    // @DataProvider

     // Run the test case for the run time
    public static Object[][] getTestData(String DataFileName, String SheetName, String TestName){

             ReadExcelDataFile readData = new ReadExcelDataFile(System.getProperty("user.dir") + "/src/test/TestData/" + DataFileName);
//             String sheetName = "Sheet1";
//             String testName = "Test Three";

             String sheetName = SheetName;
             String testName = TestName;


             //find start row number of the test case

             int startRowNum= 0;
             while (!readData.getCellData(sheetName,0,startRowNum).equalsIgnoreCase(testName)){
                 startRowNum++;
             }
          //   System.out.println("Test Start from Row Number : " + startRowNum);

             int startTestColumn = startRowNum+1;
             int startTestRow = startRowNum+2;

             //Find Number of the Rows of TestCase
             int row = 0;
             while (!readData.getCellData(sheetName,0,startTestRow+row).equals("")){
                 row++;
             }

           //  System.out.println("Total number of the row in the test : " +testName + " is = " +row);

             //find number of column in test
             int column=0;
             while (!readData.getCellData(sheetName,column,startTestColumn).equals("")){
                 column++;
             }
           //  System.out.println("Total number of the column in the test : " +testName + " is = " +column);


             //define 2D object array
             Object [][] dataSet = new Object[row][1];
             Hashtable<String,String> dataTable = null;

             int dataRowNumber=0;

             for (int rowNumber=startTestRow; rowNumber<=startTestColumn+row; rowNumber++){
                 dataTable = new Hashtable<String, String>();
                 for (int columnNumber=0; columnNumber<column; columnNumber++){

                     String key = readData.getCellData(sheetName,columnNumber,startTestColumn);
                     String value = readData.getCellData(sheetName,columnNumber,rowNumber);
                     dataTable.put(key, value);


                     //dataset[dataRowNumber][columnNumber] = readData.getCellData(sheetName,columnNumber,rowNumber);

                    // System.out.println(readData.getCellData(sheetName,columnNumber,rowNumber));
                 }
                 dataSet[dataRowNumber][0] = dataTable;
                 dataRowNumber++;
             }
         return dataSet;
     }


}
