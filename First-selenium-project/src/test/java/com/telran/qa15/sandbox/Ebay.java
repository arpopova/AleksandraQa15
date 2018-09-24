package com.telran.qa15.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ebay {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void openSiteTest(){
        wd.navigate().to("https://www.ebay.com");
        wd.findElement(By.linkText("Sign in")).click();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }

}


