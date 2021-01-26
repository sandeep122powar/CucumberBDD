package com.qa.hubspot.tests;

import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test (priority = 1)
    public void verifyLoginPageTitleTest(){
        String title = page.getInstance(LoginPage.class).getLoginPageTitle();
        System.out.println("Login Page Title" + title);
        Assert.assertEquals(title, "Swag Labs");
    }

    @Test
    public void verifyLogin(){
        page.getInstance(LoginPage.class).doLogin("standard_user", "secret_sauce");
        String homePageTitle = page.getInstance(HomePage.class).getHomePageTitle();
        Assert.assertEquals(homePageTitle, "Swag Labs");
    }
}
