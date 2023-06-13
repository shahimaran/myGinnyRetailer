package baseClasses;

import PageClasses.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myGinnyRetailer.utils.DateUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.util.List;

import java.io.File;
import java.io.IOException;


public class PageBaseClass extends BaseTestClass {
    public ExtentTest logger;
    public PageBaseClass(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;

    }



    /************************** Open MGI Application  ************************************************************/

    public LoginPage openMgiApplication(){
        logger.log(Status.INFO,"Opening the myGinny Application");
        driver.get("https://uat.myginny.com/");
        logger.log(Status.PASS,"myGinny Application Opens Successfully");

        LoginPage loginPage = new LoginPage(driver, logger);
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

    /************************** Get Page Title  ************************************************************/

    public void getTitle(String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
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

    /**************************** Capture screenshot ******************************************/

    public void takeScreenShotOnFail() {
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
    /****************** Accept Java Script Alert ***********************/
    public void acceptAlert(){
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            logger.log(Status.PASS, "Page Alert Accepted");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /****************** Cancel Java Script Alert ***********************/
    public void cancelAlert(){
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();;
            logger.log(Status.PASS, "Page Alert Rejected");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /****************** Select value From DropDown ***********************/
    public void selectDropDownValue(WebElement webElement, String value){
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(value);
            logger.log(Status.PASS, "Selected the Value : " + value);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }



    /****************** Verify Element is Present ***********************/
    public void verifyElementIsDisplayed(WebElement webElement){
        try {
            if(webElement.isDisplayed()){
                reportPass("Password Box is Displayed");
            }else {
                reportFail("Password Box is not appeared");
            }

        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /****************** Get All Elements of DropDown ***********************/
    public List getAllElementsOfDropDown(WebElement webElement){
        try {
            Select select = new Select(webElement);

            List<WebElement> allElements = select.getOptions();
            return allElements;
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        return null;
    }




}
