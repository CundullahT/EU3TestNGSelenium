package com.cybertek.tests.homework;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test9_12 {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get("https://practice-cybertekschool.herokuapp.com");

    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();

    }

    @DataProvider
    public Object [][] getData(){

        String [][] data = {
                {"200","This page returned a 200 status code"},
                {"301","This page returned a 301 status code"},
                {"404","This page returned a 404 status code"},
                {"500","This page returned a 500 status code"}
        };

        return data;

    }

    @Test(dataProvider = "getData")
    public void test9_12(String errorNumber, String errorMessage){

        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.waitForPageToLoad(5);
        driver.findElement(By.linkText(errorNumber)).click();
        BrowserUtils.waitForPageToLoad(5);
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        boolean isContains = actualMessage.contains(errorMessage);
        System.out.println("errorMessage = " + errorMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(isContains);

    }

}
