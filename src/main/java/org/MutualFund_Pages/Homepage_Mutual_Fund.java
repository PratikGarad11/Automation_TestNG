package org.MutualFund_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_Mutual_Fund {
    WebDriver driver;
    @FindBy(xpath = "//a[@data-tab='portfolio']")
    WebElement mutual_Fund_Portfolio;

    public  Homepage_Mutual_Fund(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void click_Portfolio_button(){
        mutual_Fund_Portfolio.click();

    }

    public String getTitle(){
        String title = driver.getTitle();
        //  System.out.println("Switch To " + title +" Page");
        return title;
    }
}
