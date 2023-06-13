package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseOrderPage extends PageBaseClass {

    public PurchaseOrderPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    @FindBy(xpath = "//a[contains(text(),'Purchase Orders')]")
    public WebElement purchaseOrderLink;


    public void createPurchaseOrder(){

    }
}
