package com.myGinnyRetailer.test.LoginTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.myGinnyRetailer.base.BaseUI;
import com.myGinnyRetailer.utils.TestDataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Hashtable;




public class LoginTest extends BaseUI {

    // @Test(invocationCount = 5)
    @Test(priority = 2)
    public void loginChrome() {

        //Creates test case in the report
        logger = report.createTest("loginChrome").assignAuthor("Md Imaran Shah").assignCategory("Regression").assignCategory("Smoke").assignDevice("Chrome 113");

        logger.log(Status.INFO, "Initializing the Browser");
        invokeBrowser("chrome");

        logger.log(Status.INFO, "Opening the website successfully");
        //openURL("websiteURL");
        openURL("websiteURL_dev");

        // logger.log(Status.INFO,"Enter the username");
        logger.info(MarkupHelper.createLabel("Enter username", ExtentColor.BLUE));
        enterText("usernameTextBox_Xpath", "9873");

        // logger.log(Status.INFO,"Enter the password");
        logger.info(MarkupHelper.createLabel("Enter password", ExtentColor.BLUE));
        enterText("passwordTextBox_Xpath", "Bond@003");

        logger.log(Status.INFO, "Clicking the login button");
        elementClick("clickLogin_Xpath");
        logger.pass(MarkupHelper.createLabel("Login Successfully", ExtentColor.GREEN));


        tearDown();
        closeBrowser();

    }

    @AfterMethod
    public void setReport() {
        report.flush();
    }


    @Test(priority = 1)
    public void loginFirefox() {

        logger = report.createTest("loginFireFox").assignAuthor("Md Imaran Shah").assignCategory("Regression").assignCategory("Smoke").assignDevice("FireFox 112");
        ;

        logger.log(Status.INFO, "Initializing the Browser");
        invokeBrowser("firefox");

        logger.log(Status.INFO, "Opening the website successfully");
        openURL("websiteURL_dev");

        verifyPageTitle("Login | My Website MyGinny Infotech");

        logger.info(MarkupHelper.createLabel("Enter username", ExtentColor.BLUE));
        enterText("usernameTextBox_Xpath", "9873");

        logger.info(MarkupHelper.createLabel("Enter password", ExtentColor.BLUE));
        enterText("passwordTextBox_Xpath", "Bond@003");

        logger.log(Status.INFO, "Clicking the login button");
        elementClick("clickLogin_Xpath");
        logger.pass(MarkupHelper.createLabel("Login Successfully", ExtentColor.GREEN));

        takeScreenShotOnFail();
        tearDown();
        closeBrowser();

    }

    @Test(priority = 2)
// @Test(invocationCount = 5)
    public void loginEdge() {

        logger = report.createTest("Edge").assignAuthor("Md Imaran Shah").assignCategory("Regression").assignCategory("Smoke").assignDevice("FireFox 112");

        logger.log(Status.INFO, "Initializing the Browser");
        invokeBrowser("edge");

        logger.log(Status.INFO, "Opening the website successfully");
        openURL("websiteURL_dev");

        logger.info(MarkupHelper.createLabel("Enter username", ExtentColor.BLUE));
        enterText("usernameTextBox_Xpath", "9873");

        logger.info(MarkupHelper.createLabel("Enter password", ExtentColor.BLUE));
        enterText("passwordTextBox_Xpath", "Bond@003");

        logger.log(Status.INFO, "Clicking the login button");
        elementClick("clickLogin_Xpath");
        // logger.pass(MarkupHelper.createLabel("Login Successfully", ExtentColor.GREEN));
        logger.pass(MarkupHelper.createLabel("Login Successfully", ExtentColor.GREEN));

        takeScreenShotOnFail();


        tearDown();
        closeBrowser();

    }

    @Test
    public void testLog() {

        logger = report.createTest("Chrome").assignAuthor("Md Imaran Shah").assignCategory("Regression").assignCategory("Smoke").assignDevice("FireFox 112");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/anshulc55/JavaTraining/blob/master/DataDrivenFramework/src/main/java/com/datadrivern/framework/base/BaseUI.java");
        takeScreenShotOnFail();

        //  logger.log(Status.INFO,"Fail to open the chrome");
    }

    @Test(dataProvider = "getTestOneData")
    public void testOne(Hashtable<String,String> dataTable){
        logger = report.createTest("Enter UserName & Password in myGinny : " + dataTable.get("Credentials"));
        invokeBrowser("chrome");
        openURL("websiteURL_dev");
        elementClick("usernameTextBox_Xpath");
        enterText("usernameTextBox_Xpath", dataTable.get("Username"));
        enterText("passwordTextBox_Xpath" , dataTable.get("Password"));
        elementClick("clickLogin_Xpath");
        elementClick("dev_myProfile_Xpath");
        elementClick("dev_logout_Xpath");
        closeBrowser();
       // logger.log(Status.PASS,"Retailer able to Login & logout successfully");
        logger.pass(MarkupHelper.createLabel("Retailer able to Login & logout successfully", ExtentColor.GREEN));

    }
    @DataProvider
    public Object[][] getTestOneData(){
        return TestDataProvider.getTestData("Login_Id_dev.xlsx", "DevLogin", "Login Test");
    }

}
