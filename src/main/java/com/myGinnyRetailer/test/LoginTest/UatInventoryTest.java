package com.myGinnyRetailer.test.LoginTest;

import com.myGinnyRetailer.base.BaseUI;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UatInventoryTest extends BaseUI {

    @Test
    public void InventoryUpdatePurchaseModel(){
        logger = report.createTest("Retailer's First Time Inventory Update : ");
        invokeBrowser("Chrome");
        openURL("websiteURL");
        enterText("usernameTextBox_Xpath","9873109775");
        enterText("passwordTextBox_Xpath","a");
        elementClick("clickLogin_Xpath");
        verifyPageTitle("MyGinny Infotech");
        createInventoryUpdate();
        //enterText("Uat_Vendor_Name","Imran S");




        takeScreenShotOnFail();

    }
    @AfterMethod
    public void setReport() {
        report.flush();
    }

    @Test
    public void doLoginTest(){
        doLoginMyGinny();
    }


}
