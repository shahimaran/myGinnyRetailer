package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class PurchasePage extends PageBaseClass {

    public PurchasePage(WebDriver driver, ExtentTest logger){
        super(driver,logger);

    }

    @FindBy(xpath="/html/body/header/nav/div[1]/div/div[1]/button")
    public WebElement ordersLink;

    @FindBy(xpath="//a[contains(text(),'Purchase Orders')]")
    public WebElement purchaseOrdersLink;
    @FindBy(xpath="//a[contains(text(),'Inventory Update')]")
    public WebElement inventoryUpdateLink;

    @FindBy(xpath = "//*[contains(@class,'dropdown-item o_menu_brand')]")
    public WebElement purchaseDashboard;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button[3]")
    public WebElement click_CreatePurchase;

    @FindBy(xpath = "//div[@class='o_cp_bottom']//button[3]")
    public WebElement createInventoryButton;




    public PurchaseOrderPage createNewPurchase(){
        click_CreatePurchase.click();
        return PageFactory.initElements(driver,PurchaseOrderPage.class);
    }

    public void clickPurchaseDashboard(){
        purchaseDashboard.click();
        logger.log(Status.INFO," Clicking on the Purchase Dashboard");
    }
    public void clickOrdersLink(){
        ordersLink.click();
    }

    public void mouseHover() {
        Actions action = new Actions(driver);
        action.moveToElement(inventoryUpdateLink).perform();
    }
    public InventoryPage clickInventoryLink(){
        ordersLink.click();
        waitForPageLoad();
        logger.log(Status.INFO,"Clicking on the Orders link");
        inventoryUpdateLink.click();
        waitForPageLoad();

        logger.log(Status.INFO,"Selecting  Inventory Update from Orders  ");

        InventoryPage inventoryPage = new InventoryPage(driver, logger);
        PageFactory.initElements(driver, inventoryPage);
        return inventoryPage;
    }
//    public void clickCreateInventory() {
//        createInventoryButton.click();
//        logger.log(Status.INFO, "Clicking on 'Create' Button for New Inventory Update");
//
//    }




}
