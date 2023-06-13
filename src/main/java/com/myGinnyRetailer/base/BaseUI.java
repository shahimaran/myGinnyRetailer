package com.myGinnyRetailer.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.myGinnyRetailer.utils.DateUtils;
import com.myGinnyRetailer.utils.ExtentReportManager;
import com.opera.core.systems.OperaDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseUI {

    public WebDriver driver;
    public Properties properties;
    //create an object of Extent report
    public ExtentReports report = ExtentReportManager.getReportInstance();
    //Create test case in the report
    public ExtentTest logger;
    SoftAssert softAssert = new SoftAssert();



        /***************************   Invoke Browser  ************************************************************/

        public void invokeBrowser(String browserName){

            try {
                if (browserName.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/chromedriver.exe");
                    driver = new ChromeDriver();

                } else if (browserName.equalsIgnoreCase("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/geckodriver.exe");
                    driver = new FirefoxDriver();

                } else if (browserName.equalsIgnoreCase("Opera")) {
                    System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/operadriver.exe");
                    driver = new OperaDriver();


                } else if (browserName.equalsIgnoreCase("Internet Explorer")) {
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();

                } else if (browserName.equalsIgnoreCase("Edge")) {
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/java/resources/driver/msedgedriver.exe");
                    driver = new EdgeDriver();

                } else {
                    driver = new SafariDriver();
                }
            } catch (Exception e) {

                // logger.log(Status.FAIL, e.getMessage()); OR

                reportFail(e.getMessage());
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

            if (properties == null) {
                properties = new Properties();

                try {
                    FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/ObjectRepository/projectConfig.properties");
                    properties.load(file);
                } catch (Exception e) {
                    reportFail(e.getMessage());
                    e.printStackTrace();
                }
            }

        }

        /**************************** Open the URL ********************************************************/
        public void openURL (String websiteURLKey){
            try {
                driver.get(properties.getProperty(websiteURLKey));
                reportPass(websiteURLKey + " Identified successfully");
            } catch (Exception e) {
                reportFail(e.getMessage());
            }
        }

        //**************************** Tear down clear all the previous data ***********************/
        public void tearDown () {

        }


        /**************************** Close the browser ********************************************************/
        public void closeBrowser () {
            driver.close();

        }


        /**************************** Quit the browser ********************************************************/
        public void quitBrowser () {
            driver.quit();

        }


        /*****************************    Enter the text data *****************************************/

        public void enterText (String xpathKey, String data){

            // driver.findElement(By.xpath(properties.getProperty(xpathKey))).sendKeys(data);
            // WebElement define we used getElement method to the locate the xpath

            try {
                getElement(xpathKey).sendKeys(data);
                reportPass(data + " Entered the successfully in the Element : " + xpathKey);
            } catch (Exception e) {
                reportFail(e.getMessage());
            }

        }

        /***********************    Click Element operation*        ***************************************************/

        public void elementClick (String xpathKey){
            //driver.findElement(By.xpath(properties.getProperty(xpathKey))).click();
            try {
                getElement(xpathKey).click();
                reportPass(xpathKey + "Element clicked successfully");
            } catch (Exception e) {
                reportFail(e.getMessage());
            }

        }
        /******************************** Identify the Element *********************************/
        public WebElement getElement (String locatorKey){
            WebElement element = null;
            try {
                if (locatorKey.endsWith("_Id")) {
                    element = driver.findElement(By.id(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));
                } else if (locatorKey.endsWith("_CSS")) {
                    element = driver.findElement(By.cssSelector(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else if (locatorKey.endsWith("_LinkText")) {
                    element = driver.findElement(By.linkText(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else if (locatorKey.endsWith("_ClassName")) {
                    element = driver.findElement(By.className(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else if (locatorKey.endsWith("_Name")) {
                    element = driver.findElement(By.name(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else if (locatorKey.endsWith("_PartialLinkText")) {
                    element = driver.findElement(By.partialLinkText(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.RED));

                } else if (locatorKey.endsWith("_CSS")) {
                    element = driver.findElement(By.cssSelector(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else if (locatorKey.endsWith("_Xpath")) {
                    element = driver.findElement(By.xpath(properties.getProperty(locatorKey)));
                    logger.info(MarkupHelper.createLabel("Locators Identified : " + locatorKey, ExtentColor.BLUE));

                } else {
                    reportFail("Failing the TestCase : " + locatorKey);
                    Assert.fail("Failing the TestCase : " + locatorKey);

                }
            } catch (Exception e) {
                //Failing the test case and report the error message.
                reportFail(e.getMessage());
                e.printStackTrace();

                Assert.fail("Failing the TestCase : " + e.getMessage());

            }
            return element;
        }

    /**************************** Select List Dropdown Function *******************************************/

    public void SelectElementInList(String LocatorsXpath, String Value) {
        try {
             List<WebElement> listElement = driver.findElements(By.xpath(LocatorsXpath));
            for (WebElement listItem : listElement){
                String prefix = listItem.getText();
                if (prefix.contains(Value)){
                    listItem.click();
                }
            }
            logger.log(Status.INFO,"Selected the Defined Value : " + Value);

        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }
        /************************ Reporting Function ******************************/

        public void reportFail (String reportString){
            logger.log(Status.FAIL, reportString);
            takeScreenShotOnFail();
            Assert.fail(reportString);

        }

        public void reportPass (String reportString){
            logger.log(Status.PASS, reportString);
        }

        @AfterMethod
        public void afterTest () {
            softAssert.assertAll();
        }

        /****************************** Verify Element **********************************************/

        public boolean isElementPresent (String locatorKey){
            try {
                if (getElement(locatorKey).isDisplayed()) {
                    reportPass(locatorKey + " : Element is displayed");
                    return true;
                }
            } catch (Exception e) {
                reportFail(e.getMessage());
            }
            return false;
        }
        public boolean isElementSelected (String locatorKey){
            try {
                if (getElement(locatorKey).isSelected()) {
                    reportPass(locatorKey + " : Element is selected");
                    return true;
                }
            } catch (Exception e) {
                reportFail(e.getMessage());
            }
            return false;
        }
        public boolean isElementEnabled (String locatorKey){
            try {
                if (getElement(locatorKey).isEnabled()) {
                    reportPass(locatorKey + " : Element is Enabled");
                    return true;
                }
            } catch (Exception e) {
                reportFail(e.getMessage());
            }
            return false;
        }

    /**************************** Get page Title Function******************************************/

    public void verifyPageTitle(String pageTitle){

        try {
            String actaulTile = driver.getTitle();
            logger.log(Status.INFO, "Actual Title is : " + actaulTile);
            logger.log(Status.INFO, "Expected Title is : " + pageTitle);
            Assert.assertEquals(actaulTile,pageTitle);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /************************ Create Inventory Update *****************************************/

    public void createInventoryUpdate(){
        try {
            elementClick("Uat_menuBar_Xpath");
            logger.log(Status.INFO, "Clicking MenuBar");
            elementClick("UAT_Purchase_Xpath");
            logger.log(Status.INFO, "Clicking Purchase Button");
            elementClick("Uat_Orders_Xpath");
            logger.log(Status.INFO, "Clicking Orders");
            elementClick("Uat_Orders_Inventory_Update_Xpath");
            logger.log(Status.INFO, "Clicking Inventory Update");
            elementClick("Uat_Create_IU_Xpath");
            logger.log(Status.INFO, "Clicking on Create Button");

        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }



    /**************************** Assertion Function******************************************/

        public void assertTrue ( boolean flag){
            softAssert.assertTrue(flag);
        }
        public void assertFalse ( boolean flag){
            softAssert.assertFalse(flag);
        }
        public void assertEquals (String actual, String expected){
            softAssert.assertEquals(actual, expected);
        }

        /**************************** Capture screenshot ******************************************/

        public void takeScreenShotOnFail(){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(System.getProperty("user.dir") + "/src/test/ScreenShots/" + DateUtils.getTimeStamp() + ".png");

            try {
                FileUtils.copyFile(sourceFile, destFile);
                logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "/src/test/ScreenShots/" + DateUtils.getTimeStamp() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    /**************************** Login to myGinny Application ***********************************/

    public void doLoginMyGinny(){
        logger.log(Status.INFO,"Login to the Application");
        invokeBrowser("Chrome");
        openURL("websiteURL");
        enterText("usernameTextBox_Xpath","9873109775");
        enterText("passwordTextBox_Xpath","a");
        elementClick("clickLogin_Xpath");
        verifyPageTitle("MyGinny Infotech");

    }
}

