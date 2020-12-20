package com.app.screens;

import core.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class Google extends GeneralScreen{

    WebDriver driver;
    WebDriverWait driverWait;

    @FindBy(xpath=".//div[@id='main' and @class='content']//img[@alt='Google']")
    public WebElement Google;

    @FindBy(xpath=".//div[@id='searchform']//input[@title='Search']")
    public WebElement search_field;

    @FindBy(xpath=".//a[@title='Google apps' and @role='button']")
    public WebElement Google_apps;

    @FindBy(xpath=".//iframe[@role='presentation']")
    public WebElement iframe;

    @FindBy(xpath=".//ul[@jsname='k77Iif']//span[@class='Rq5Gcb']")
    public List<WebElement> iframe_top_element;

    @FindBy(xpath=".//ul[@jsname='z5C9Gb']//span[@class='Rq5Gcb']")
    public List<WebElement> iframe_bottom_element;

    @FindBy(xpath=".//a[@href='https://podcasts.google.com/']//span")
    public WebElement Podcasts;

    @FindBy(xpath=".//a[@target='_top' and contains(text(),'Sign in')]")
    public WebElement Sign_in;

    @FindBy(xpath=".//div[@aria-label='Search by voice' and @role='button']")
    public WebElement Search_by_voice;

    @FindBy(xpath=".//div[@class='microphone']")
    public WebElement microphone;

    @FindBy(linkText="Gmail")
    public WebElement Gmail;

    public Google(WebDriver driver){
        super(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void waitScreenLoaded(){
        driverWait.until(ExpectedConditions.visibilityOf(Google));
    }

    public Google openScreen(){
        navigateTo(PropertyLoader.getProperty("url.Google"));
        waitScreenLoaded();
        return this;
    }
}