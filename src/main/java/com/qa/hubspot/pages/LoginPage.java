package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //page locators
    By email_id = By.id("user-name");
    By password = By.id("password");
    By button = By.id("login-button");

    //page actions

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void doLogin(String username, String pwd){
        doSendKeys(email_id, username);
        doSendKeys(password, pwd);
        doClick(button);
    }

}
