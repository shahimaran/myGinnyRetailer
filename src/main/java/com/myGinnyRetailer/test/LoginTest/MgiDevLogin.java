package com.myGinnyRetailer.test.LoginTest;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.myGinnyRetailer.base.BaseUI;
import com.myGinnyRetailer.utils.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Hashtable;

public class MgiDevLogin extends BaseUI {

    @Test(dataProvider = "getDatadoDevLoginTest")

    public void doDevLoginAndLogoutTest(Hashtable<String,String> dataTable){

        logger = report.createTest("Dev Login Test" + dataTable.get("Comment"));

        invokeBrowser("chrome");
        openURL("websiteURL_dev");
        elementClick("usernameTextBox_Xpath");
        enterText("usernameTextBox_Xpath", dataTable.get("Username"));
        enterText("passwordTextBox_Xpath" , dataTable.get("Password"));
        elementClick("clickLogin_Xpath");
        verifyPageTitle(dataTable.get("PageTitle"));
        elementClick("dev_myProfile_Xpath");
        elementClick("dev_logout_Xpath");

        closeBrowser();

        logger.pass(MarkupHelper.createLabel("Retailer able to Login & logout successfully", ExtentColor.GREEN));

    }  @Test(dataProvider = "getDatadoDevLoginTest")
    public void doDevLoginTest(Hashtable<String,String> dataTable){

        logger = report.createTest("Dev Login Test" + dataTable.get("Comment"));

        invokeBrowser("chrome");
        openURL("websiteURL_dev");
        elementClick("usernameTextBox_Xpath");
        enterText("usernameTextBox_Xpath", dataTable.get("Username"));
        enterText("passwordTextBox_Xpath" , dataTable.get("Password"));
        elementClick("clickLogin_Xpath");
        verifyPageTitle(dataTable.get("PageTitle"));
        closeBrowser();

        logger.pass(MarkupHelper.createLabel("Retailer able to Login & logout successfully", ExtentColor.GREEN));

    }
    @DataProvider
    public Object[][] getDatadoDevLoginTest(){
        return TestDataProvider.getTestData("MGI_Dev_Login.xlsx","DevLogin","MgiDevLoginTest");
    }


    @AfterMethod
    public void setReport() {
        report.flush();
    }

    @Test
    public void inventoryUpdateDev(){
        logger = report.createTest("Retailer's First Time Inventory Update : ");
        invokeBrowser("Chrome");
        openURL("websiteURL_dev");
        elementClick("usernameTextBox_Xpath");
        enterText("usernameTextBox_Xpath","9873");
        enterText("passwordTextBox_Xpath","Bond@003");
        elementClick("clickLogin_Xpath");
        verifyPageTitle("MyGinny Infotech");
        elementClick("Dev_menuBar_xpath");
        elementClick("Dev_Purchase_xpath");
        elementClick("Dev_Orders_Xpath");
        elementClick("Dev_Orders_Inventory_Update_Xpath");
        elementClick("Dev_Create_IU_Xpath");



    }

}
