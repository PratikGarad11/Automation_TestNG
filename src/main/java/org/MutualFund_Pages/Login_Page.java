package org.MutualFund_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='login-button']")
    private WebElement login;

    @FindBy(xpath = "//h2[text()='Mutual Fund Portal Login']")
    private WebElement loginTitle;

    public Login_Page(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void Entre_Username(String Entreusername){
        username.sendKeys(Entreusername);
    }

    public void Entre_Password(String Entrepassword){
        password.sendKeys(Entrepassword);
    }

    public void click_Login(){
        login.click();
    }
    public boolean isLoginTitleDisplay(){
        return loginTitle.isDisplayed();
    }
}
