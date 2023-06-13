package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MgiLandingPage extends PageBaseClass {
    public MgiLandingPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    // All WebElement of landing Page and Associated Operations



    public LoginPage clickSingIn(){

        //Perform Click on Sign in button
        // return new LoginPage();
        //Create the object of Login Page Class & pass the driver instance of constructor of login Page Class

        return PageFactory.initElements(driver, LoginPage.class);
    }

}

