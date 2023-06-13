package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateInventoryPage extends PageBaseClass {
    public CreateInventoryPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }
    @FindBy(xpath = "//*[contains(@class,'o_input_dropdown')]/input[1]")
    public WebElement vendorTextBox;

    @FindBy(xpath= "//*[@class='o_input o_field_widget o_quick_editable o_required_modifier' and @name='inventory_type']")
    public WebElement inventoryTypeTextBox;

    @FindBy(xpath= "//*[@class='o_input o_field_widget o_quick_editable o_required_modifier' and @name='inventory_type']/option[2]")
    public WebElement selectInventory_DropDown;

    @FindBy ( xpath = "//*[@name='order_line']//a[text()='Add a product']")
    public WebElement addaProduct_Button;
    @FindBy ( xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[3]/div/div[1]/div/input")
    public WebElement product_TextBox;

    @FindBy (xpath = "//*[@name='order_line']/div[2]/div[1]/table/tbody/tr[1]/td[2]/span")
    public WebElement Barcode_TextBox;
    @FindBy ( xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[5]/input")
    public WebElement quantity_TextBox;
    @FindBy ( xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[7]/input")
    public WebElement costPrice_TextBox;
    @FindBy ( xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[8]/input")
    public WebElement salePrice_TextBox;
    @FindBy ( xpath = "/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[1]")
    public WebElement saveInventory_Button;

    @FindBy (xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/button/span")
    public WebElement confirmInventory_Button;
    @FindBy (xpath = "//*[@class='o_m2o_no_result ui-menu-item']/a[1]")
    public WebElement noRecords;
    @FindBy (xpath = "//*[@class='o_not_full oe_button_box']/button/i")
    public WebElement create_ProductRequest;


    public void clickSaveButton(){
        try {
            saveInventory_Button.click();
            logger.pass(MarkupHelper.createLabel("Inventory of the Products are Saved Successfully", ExtentColor.GREEN));
        } catch (Exception e) {
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }
    public void enterProductQuantity(String quantity){

        try {
            quantity_TextBox.click();
            waitLoad(2);
            quantity_TextBox.sendKeys(quantity);
            logger.log(Status.INFO, "Enter Product Quantity : " + quantity);
        }catch (Exception e) {
            //Failing the test case and report the error message.
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }
    public void enterProductCostPrice(String costPrice){

        try {
            costPrice_TextBox.click();
            waitLoad(2);
            costPrice_TextBox.sendKeys(costPrice);
            logger.log(Status.INFO, "Enter Cost Price : " + costPrice);
        }catch (Exception e) {
            //Failing the test case and report the error message.
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }

    }
    public void enterProductSalesPrice(String salesPrice){

        try {
            salePrice_TextBox.click();
            waitLoad(2);
            salePrice_TextBox.sendKeys(salesPrice);
            logger.log(Status.INFO, "Enter Sales : " + salesPrice);
        }catch (Exception e) {
            //Failing the test case and report the error message.
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }






    public void enterVendorName(String vendorName){
        vendorTextBox.sendKeys(vendorName + Keys.ENTER);
        waitForPageLoad();
        logger.log(Status.INFO,"Enter Vendor Name" + vendorName);

       // acceptAlert();
    }
    public void barcode_getText(String barcode){
        String barcodeGet = Barcode_TextBox.getText();

        try {
            if (barcodeGet.equals(barcode)){
              //  logger.log(Status.PASS,"Product is Present in MGI Catalogue");
                logger.pass(MarkupHelper.createLabel("Product is Present in MGI Catalogue", ExtentColor.GREEN));
            } else if (barcodeGet.isEmpty()){
                create_ProductRequest.click();
                logger.pass(MarkupHelper.createLabel("Barcode is not Exist in MGI Catalogue", ExtentColor.RED));
            } else {logger.pass(MarkupHelper.createLabel("Barcode is not Exist in MGI Catalogue", ExtentColor.RED));}
        } catch (Exception e) {
                //Failing the test case and report the error message.
                reportFail(e.getMessage());
                e.printStackTrace();
                Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }


    public void selectInventoryType(){
//        inventoryTypeTextBox.click();
//        logger.log(Status.INFO,"Clicking on Inventory Type" );
//        waitForPageLoad();
//        selectInventory_DropDown.click();

        logger.log(Status.INFO,"Clicking on Inventory Type" );
        selectDropDownValue(inventoryTypeTextBox,"Inventory Update");
        logger.pass(MarkupHelper.createLabel("Inventory Type : Inventory Update Selected Successfully", ExtentColor.GREEN));

    }

    public void clickAddProduct(){
        try {
            addaProduct_Button.click();
            logger.log(Status.INFO, "Clicking on Add a Product Button");
        }catch (Exception e) {
            //Failing the test case and report the error message.
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
    }


    public void noRecord(String barcode){
       String NR = noRecords.getAttribute("No records");
       Assert.assertEquals(NR,barcode);
        System.out.println(NR);
    }
    public void enterProductBarcode(String barcode){

        if (barcode.isEmpty()){
            reportFail("Product TextBox Is Empty, Please Enter Product Barcode");
        }
        try {
            product_TextBox.sendKeys(barcode);
            logger.log(Status.INFO, "Enter The Product Barcode : " + barcode);
            waitLoad(1);
            product_TextBox.sendKeys(Keys.ENTER);
            waitLoad(1);
        } catch (Exception e) {
            //Failing the test case and report the error message.
            reportFail(e.getMessage());
            e.printStackTrace();
            Assert.fail("Failing the TestCase : " + e.getMessage());
        }
        barcode_getText(barcode);

    }
//    public void addProduct() {
//        addaProduct_Button.click();
//        logger.log(Status.INFO, "Clicking on Add a Product Button");
//        waitForPageLoad();
//        product_TextBox.sendKeys("200500101");
//        logger.log(Status.INFO, "Enter Product Barcode");
//        waitForPageLoad();
//        costPrice_TextBox.sendKeys("10");
//        logger.log(Status.INFO, "Enter Cost Price of the Product");
//        waitForPageLoad();
//        salePrice_TextBox.sendKeys("15" + Keys.ENTER);
//        logger.log(Status.INFO, "Enter Sales Price of the Product");
//        waitForPageLoad();
//        saveInventory_Button.click();
//        logger.log(Status.INFO, "Clicking on Save Button");
//        waitForPageLoad();
//        confirmInventory_Button.click();
//        logger.log(Status.PASS, "Clicking on the Confirm Button");
//
//    }

    public void doInventoryUpdate(String barcode, int quantity, int costPrice, int salesPrice){
        clickAddProduct();
        enterProductBarcode(barcode);
        enterProductQuantity(String.valueOf(quantity));
        enterProductCostPrice(String.valueOf(costPrice));
        enterProductSalesPrice(String.valueOf(salesPrice));

    }
    public void doInventoryUpdateN2P(String vendorName,String barcode, int quantity, int costPrice, int salesPrice){

        enterVendorName(vendorName);
        selectInventoryType();
        clickAddProduct();
        enterProductBarcode(barcode);
        enterProductQuantity(String.valueOf(quantity));
        enterProductCostPrice(String.valueOf(costPrice));
        enterProductSalesPrice(String.valueOf(salesPrice));
        clickSaveButton();

    }

}
