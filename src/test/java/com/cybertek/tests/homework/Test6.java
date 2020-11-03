package com.cybertek.tests.homework;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){

        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);

    }

    @Test
    public void test6() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitForPageToLoad(5);

        WebElement leftSide = driver.findElement(By.xpath("//label[@class='control-label'][1]"));
        //WebElement rightSide = driver.findElement(By.xpath("//div[@class='control-label']"));

        System.out.println(leftSide.getText());


    }

}
