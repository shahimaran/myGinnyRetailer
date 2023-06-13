package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RetailerHomePage extends PageBaseClass {

    @FindBy(xpath = "//*[contains(@id,'openSidebar')]")
    public WebElement menuBarLink;

    @FindBy(xpath = "//*[@id='sidebar_panel']/div/ul/li[6]/a/span")
    public WebElement purchaseLink;

    public RetailerHomePage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    public void clickMenuBar() {
        try {
            menuBarLink.click();
        } catch (Exception e) {
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }

    public PurchasePage clickPurchaseLink() {

        try {
            menuBarLink.click();
            waitLoad(2);
            logger.log(Status.INFO, "Clicking MenuBar ");
            purchaseLink.click();
            waitLoad(2);
            logger.log(Status.INFO, "Clicking on the Purchase Button From MenuBar");
        } catch (Exception e) {
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
        String currentPageTitle = driver.getTitle();
        if (currentPageTitle.equals("MyGinny Infotech - Purchase Orders")){
            logger.log(Status.PASS,"User Landing to the Purchase Page");
        }else reportFail("Retailer is Failing to Landing on Purchase Page");

        PurchasePage purchasePage = new PurchasePage(driver, logger);
        PageFactory.initElements(driver, purchasePage);
        return purchasePage;


    }
}