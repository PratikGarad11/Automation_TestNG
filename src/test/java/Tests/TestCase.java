package Tests;

import org.MutualFund_Pages.Homepage_Mutual_Fund;
import org.MutualFund_Pages.Login_Page;
import org.MutualFund_Pages.Mutual_Fund_Portal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://deepakrao64.github.io/SB/MutualFundClient/LoginPage.html");

        Login_Page loginPage=new Login_Page(driver);
        loginPage.Entre_Username("admin");
        loginPage.Entre_Password("password");
        loginPage.click_Login();

        Homepage_Mutual_Fund homepageMutualFund=new Homepage_Mutual_Fund(driver);
        homepageMutualFund.click_Portfolio_button();

        Mutual_Fund_Portal mutualFundPortal=new Mutual_Fund_Portal(driver);
        boolean mutualFundHeaderDisplay = mutualFundPortal.isMutualFundHeaderDisplay();
        System.out.println(mutualFundHeaderDisplay);

        mutualFundPortal.click_Axis_BlueChip_Fund();
        mutualFundPortal.clickOnRedeemFundTab();
        mutualFundPortal.clickOnConfirm();
        mutualFundPortal.clickOnBankCredit();
        String alertMessge = mutualFundPortal.getAlertMessge();
        System.out.println(alertMessge);

        mutualFundPortal.acceptAlert();

        String expectedMessege="Redemption successfully requested via Credit To Bank.";
        Assert.assertEquals(alertMessge,expectedMessege);
    }
}
