package com.qa.hubspot.tests;

import com.qa.hubspot.pages.Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Pages page;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/index.html");
        Thread.sleep(4000);
        //Create object of page class: Instantiate Page class
        page = new Pages(driver, wait);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
