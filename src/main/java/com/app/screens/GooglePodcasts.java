package com.app.screens;

import core.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class GooglePodcasts extends GeneralScreen {

    @FindBy(xpath = ".//button[@role='button' and @aria-label='Search']")
    public WebElement Search;

    @FindBy(xpath = ".//a[@title='Google Podcasts' and @id='sdgBod']")
    public WebElement Google_Podcasts;

    @FindBy(xpath = ".//scrolling-carousel[@class='Ew9oWb' and @id='i5']//div[@class='eWeGpe']")
    public List<WebElement> top_podcast_element;

    @FindBy(xpath = ".//div[@class='FyxyKd']")
    public WebElement searched_header;

    @FindBy(xpath = ".//div[@class='dbCu3e']//div[@class='ZfMIwb']")
    public WebElement podcast_header;

    @FindBy(xpath = ".//form[@role='search']//input[@class='Ax4B8 ZAGvjd']")
    public WebElement Search_for_podcasts;

    public WebDriver driver;
    public WebDriverWait driverWait;

    public GooglePodcasts(WebDriver driver){
        super(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void waitScreenLoaded(){
        driverWait.until(ExpectedConditions.visibilityOf(Google_Podcasts));
    }

    public GooglePodcasts openScreen(){
        navigateTo(PropertyLoader.getProperty("url.Google.Podcasts"));
        waitScreenLoaded();
        return this;
    }
}