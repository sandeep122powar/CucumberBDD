package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //page locators
    private By invisibleElement = By.xpath("//div[@class='bm-menu']");
    private By breadCrum = By.xpath("//div[@class='bm-burger-button']");
    private By allItems = By.xpath("//*[@id=\"inventory_sidebar_link\"]");
    private By about = By.xpath("//*[@id=\"about_sidebar_link\"]");
    private By logout = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    private By resetAppState = By.xpath("//*[@id=\"reset_sidebar_link\"]");
    private By homePageLogo = By.xpath("//div[@class='app_logo']");



    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public WebElement setHomePageLogo(WebElement homePageLogo){
        return homePageLogo;
    }

    public String doGetLinkText(String linkName) {

        waitForElementPresent(homePageLogo);
        doActionsMoveToElement(breadCrum);
        //doClick(breadCrum);

        if (linkName == "All Items") {
            doGetText(allItems);
        } else if (linkName == "About") {
            doGetText(about);
        } else if (linkName == "Logout") {
            doGetText(logout);
        } else if (linkName == "Reset App State") {
            doGetText(resetAppState);
        }
        return linkName;
    }

}
