package com.app.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GmailEmailFromGoogleScreen extends GeneralScreen{

    WebDriver driver;
    WebDriverWait driverWait;
    Google googleScreen;

    @FindBy(xpath=".//a[@class='h-c-button h-c-header__cta-li-link h-c-header__cta-li-link--primary']")
    public WebElement Create_an_account;

    public GmailEmailFromGoogleScreen(WebDriver driver){
        super(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        googleScreen = new Google(driver);
        PageFactory.initElements(driver,this);
    }

    public void waitScreenLoaded(){
        driverWait.until(ExpectedConditions.visibilityOf(Create_an_account));
    }

    public GmailEmailFromGoogleScreen openScreen(){
        googleScreen.openScreen().Gmail.click();
        waitScreenLoaded();
        return this;
    }
}