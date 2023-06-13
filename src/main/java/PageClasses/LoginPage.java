package PageClasses;

import baseClasses.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends PageBaseClass {


    public LoginPage(WebDriver driver, ExtentTest logger){
        super(driver, logger);
    }

    @FindBy(id="login")
    public WebElement username_TextBox;

    @FindBy(id="password")
    public WebElement password_TextBox;

    @FindBy(xpath="//*[@id='wrapwrap']//div[3]/button")
    public WebElement submitLogin_Button;

    public RetailerHomePage doLogin(String userName, String password){

        username_TextBox.sendKeys(userName);
        logger.log(Status.PASS, "Entered the UserName : " + userName);

        password_TextBox.sendKeys(password);
        logger.log(Status.PASS, "Entered the Password : " + password);

        submitLogin_Button.click();
        logger.log(Status.INFO, " Submit The Login Button ");
        waitForPageLoad();
        logger.log(Status.PASS, " User Logged into myGinny Successfully");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    String currentPageTitle = driver.getTitle();
		if (currentPageTitle.equals("Login | My Website MyGinny Infotech")){
        reportFail("Login is failed on Portfolio Login Page");
        Assert.fail("Login Failed");
    }

        RetailerHomePage retailerHomePage = new RetailerHomePage(driver, logger);
        PageFactory.initElements(driver, retailerHomePage);
        return retailerHomePage;
    }

    public void enterUserName(String userName){
        username_TextBox.sendKeys(userName);
        logger.log(Status.PASS, "Entered the UserName : " + userName);

    }

    public void enterPassword(String password){
        password_TextBox.sendKeys(password);
        logger.log(Status.PASS, "Entered the Password : " + password);


    }




    //WebElements on Login Page
    //Functions associated with Login Page




}
