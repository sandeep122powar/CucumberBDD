package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Pages {
    public BasePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    //generic util wrappers

    public void doClick(By locator){
        driver.findElement(locator).click();
    }

    public void doSendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String doGetText(By locator){
       return driver.findElement(locator).getText();
    }

    public void waitForElementPresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }

    public WebElement getElement(By locator) {
        waitForElementPresent(locator);
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("some exception got occurred while creating the webelement : " + locator);
            System.out.println(e.getMessage());
        }
        return element;
    }

    public void doActionsMoveToElement(By locator) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(getElement(locator)).build().perform();
        } catch (Exception e) {
            System.out.println("some exception got occurred while moving on the webelement : " + locator);
            System.out.println(e.getMessage());
        }
    }
}
