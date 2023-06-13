package com.myGinnyRetailer.utils;

public class Tempreaddata {
    public static void main(String[] args) {
        ReadExcelDataFile readData = new ReadExcelDataFile(System.getProperty("user.dir") + "/src/main/java/testData/Login_Id_dev.xlsx");

       int totalRows = readData.getRowCount("DevLogin");
        System.out.println("Total Number of Rows : " + totalRows);
        System.out.println(readData.getCellData("DevLogin",2,2));

    }
}
