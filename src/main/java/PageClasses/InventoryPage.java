package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends PageBaseClass {

    public InventoryPage(WebDriver driver, ExtentTest logger){
        super(driver,logger);

    }

    @FindBy(xpath = "//div[@class='o_cp_bottom']//button[3]")
    public WebElement createInventoryButton;

    public CreateInventoryPage clickCreateInventory(){
        createInventoryButton.click();
        logger.log(Status.INFO,"Clicking on 'Create' Button for New Inventory Update");

        CreateInventoryPage createInventoryPage = new CreateInventoryPage(driver,logger);
        PageFactory.initElements(driver,createInventoryPage);
        return createInventoryPage;
    }
}
