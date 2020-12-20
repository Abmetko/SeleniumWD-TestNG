package com.app.screens;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public abstract class GeneralScreen{

    private WebDriver driver;
    private WebDriverWait driverWait;

    public GeneralScreen(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }


    public boolean waitIsElementVisible(WebElement element){
        try{
            driverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementVisible(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public WebElement waitGetVisibleElement(WebElement element) throws TimeoutException{
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitGetVisibleElements(WebElement element) throws TimeoutException{
        return driverWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public WebElement waitGetClickableElement(WebElement element) throws TimeoutException {
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitIsElementSelected(WebElement element) throws TimeoutException{
        return driverWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitClickAndClearField(WebElement element)throws TimeoutException{
        element.click();
        element.clear();
    }

    public void waitClickEnterDataInField(WebElement element, String data)throws TimeoutException{
        element.click();
        element.sendKeys(data);
    }

    public void waitClickClearEnterDataInField(WebElement element, String data)throws TimeoutException{
        element.click();
        element.clear();
        element.sendKeys(data);
    }

    public void typeEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement){
        new Actions(driver).dragAndDrop(sourceElement, targetElement).build().perform();
    }

    public GeneralScreen openScreen(){
        return this;
    }

    public boolean waitIsScreenLoaded(){
        try {
            waitScreenLoaded ();
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void waitScreenLoaded(){
    }

    public void inputDataInField(WebElement element, String data){
        waitClickClearEnterDataInField(element, data);
    }
}