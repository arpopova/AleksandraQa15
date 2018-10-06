package com.telran.qa15.Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ebay {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void openSiteTest(){
        wd.navigate().to("https://www.ebay.com");
        wd.findElement(By.linkText("Sign in")).click();

        wd.findElement(By.name("userid")).sendKeys("qqqqqq");
        wd.findElement(By.name("pass")).sendKeys("aaaaaa");
        wd.findElement(By.id("sgnBt")).click();


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        wd.quit();
    }

}


