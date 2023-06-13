package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends PageBaseClass {
    public OrdersPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }
}
