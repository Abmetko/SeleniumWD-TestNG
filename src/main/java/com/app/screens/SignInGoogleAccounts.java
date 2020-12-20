package com.app.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SignInGoogleAccounts extends GeneralScreen {

    @FindBy(xpath = ".//div[@id='initialView']//input[@type='email']")
    WebElement Email_or_phone;

    WebDriver driver;
    WebDriverWait driverWait;
    Google googleScreen;

    public SignInGoogleAccounts(WebDriver driver){
        super(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
        googleScreen = new Google(driver);
    }

    public void waitScreenLoaded(){
        driverWait.until(ExpectedConditions.visibilityOf(Email_or_phone));
    }

    public SignInGoogleAccounts openScreen(){
        googleScreen.openScreen().Sign_in.click();
        waitScreenLoaded();
        return this;
    }
}