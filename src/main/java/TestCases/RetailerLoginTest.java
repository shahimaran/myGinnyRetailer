package TestCases;

import PageClasses.*;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RetailerLoginTest extends BaseTestClass {

    CreateInventoryPage createInventoryPage;
    PurchasePage purchasePage;
    LoginPage loginPage;
    RetailerHomePage retailerHomePage;
    InventoryPage inventoryPage;
    PurchaseOrderPage purchaseOrderPage;

    @Test
    public  void LoginTest(){

        logger = report.createTest("Login MGI Uat Applictaion ");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");

    }

    @Test
    public void inventoryPageTest() {
        logger = report.createTest("Open Create Inventory Update");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();

//        String cT = driver.getTitle();
//        System.out.println(cT);

    }
        @Test
        public void inventoryUpdateFillDetailsTest(){
            logger = report.createTest("Enter Vendor Name & Select Inventory Type");

            invokeBrowser("chrome");
            PageBaseClass pageBase = new PageBaseClass(driver, logger);
            PageFactory.initElements(driver, pageBase);
            loginPage = pageBase.openMgiApplication();
            retailerHomePage = loginPage.doLogin("9873109775", "a");
            purchasePage = retailerHomePage.clickPurchaseLink();
            inventoryPage = purchasePage.clickInventoryLink();
            createInventoryPage = inventoryPage.clickCreateInventory();
            createInventoryPage.enterVendorName("عمران");
            createInventoryPage.selectInventoryType();



    }

    @Test
    public void searchProductBarcode(){

        logger = report.createTest("Search Product by Barcode");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();
        createInventoryPage.enterVendorName("عمران");
        createInventoryPage.selectInventoryType();
        createInventoryPage.clickAddProduct();
        createInventoryPage.enterProductBarcode("200500101");

    }
    @Test
    public void enterProductDetails(){

        logger = report.createTest("Enter Products Quantity, Sales Price & Cost Price");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();
        createInventoryPage.enterVendorName("عمران");
        createInventoryPage.selectInventoryType();
        createInventoryPage.clickAddProduct();
        createInventoryPage.enterProductBarcode("200500102");
        createInventoryPage.enterProductQuantity("7");
        createInventoryPage.enterProductCostPrice("100");
        createInventoryPage.enterProductSalesPrice("190");

    }

    @Test
    public void doInventoryOfAmul(){
        logger = report.createTest("Enter Products Quantity, Sales Price & Cost Price of Amul Milk");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();
        createInventoryPage.enterVendorName("ASS");
        createInventoryPage.selectInventoryType();
        createInventoryPage.doInventoryUpdate("200500102",10,200,250);

    }

    @Test
    public void doLogInventoryN2S(){
        logger = report.createTest("Enter Products Quantity, Sales Price & Cost Price of Amul Milk & Save");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();
        createInventoryPage.doInventoryUpdateN2P("ASS","200500102",15,300,400);


    }
    @Test
    public void doLogInventoryForNonExistingProduct(){
        logger = report.createTest("Verifying that Product Is Not Existing In MGI");

        invokeBrowser("chrome");
        PageBaseClass pageBase = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBase);
        loginPage = pageBase.openMgiApplication();
        retailerHomePage = loginPage.doLogin("9873109775", "a");
        purchasePage = retailerHomePage.clickPurchaseLink();
        inventoryPage = purchasePage.clickInventoryLink();
        createInventoryPage = inventoryPage.clickCreateInventory();
        createInventoryPage.doInventoryUpdateN2P("ASS","20050010111",15,300,400);


    }
}
