package Tests;

import org.MutualFund_Pages.Homepage_Mutual_Fund;
import org.MutualFund_Pages.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase2 {
    WebDriver driver;

    @BeforeMethod
    public void runBeforeMethod(){
        driver=new ChromeDriver();
        driver.get("https://deepakrao64.github.io/SB/MutualFundClient/LoginPage.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void loginPage(){
        Login_Page loginPage=new Login_Page(driver);
        loginPage.Entre_Username("admin");
        loginPage.Entre_Password("password");
        loginPage.click_Login();

        Homepage_Mutual_Fund homepageMutualFund=new Homepage_Mutual_Fund(driver);
        String title = homepageMutualFund.getTitle();

        String expectedTitle="Mutual Fund Portal";

        Assert.assertEquals(title,expectedTitle);
        driver.close();

    }
    @Test
    public void loginTitleDisplay(){
        String actualTitle = driver.getTitle();
        String expectedTitle="Mutual Fund Portal - Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.close();
    }

}
