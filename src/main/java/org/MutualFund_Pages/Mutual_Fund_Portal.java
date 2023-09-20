package org.MutualFund_Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Mutual_Fund_Portal {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='Mutual Fund Portfolio']")
    private WebElement mutualFundPortfolioHeaderText;
    @FindBy(xpath = "//td[contains(@ondblclick,'Bluechip Fund')]")
    private WebElement click_Axis_BlueChip_fund;

    @FindBy(xpath = "//li[text()='Redeem Funds']")
    private WebElement redeemFundTab;

    @FindBy(xpath = "//button[contains(@onclick,'redeem')]")
    private WebElement confirmRedeemFund;

    @FindBy(xpath = "//button[text()='Credit to Bank']")
    private WebElement creditToBank;

    public Mutual_Fund_Portal(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public boolean isMutualFundHeaderDisplay(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(mutualFundPortfolioHeaderText));
        return mutualFundPortfolioHeaderText.isDisplayed();

    }

    public void click_Axis_BlueChip_Fund() {
        Actions actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(click_Axis_BlueChip_fund));
        actions.contextClick(click_Axis_BlueChip_fund).perform();
    }

    public void clickOnRedeemFundTab() {
        redeemFundTab.click();
    }

    public void clickOnConfirm() {
        confirmRedeemFund.click();
    }

    public void clickOnBankCredit() {
        creditToBank.click();
    }

    public String getAlertMessge(){
        Alert alert=driver.switchTo().alert();
        return alert.getText();

    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
