package com.app.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class GoogleSearch extends GeneralScreen {

    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(xpath = ".//h1[@class='Uo8X3b' and contains(text(),'Page navigation')]")
    WebElement Page_navigation;

    public GoogleSearch(WebDriver driver){
        super(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void waitScreenLoaded(){
        driverWait.until(ExpectedConditions.visibilityOf(Page_navigation));
    }
}