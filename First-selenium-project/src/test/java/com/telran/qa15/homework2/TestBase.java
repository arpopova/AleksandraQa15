package com.telran.qa15.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod

    public void setUp() throws InterruptedException {

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        OpenWikipedia();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
    
    public void OpenWikipedia() {
        wd.get("https://www.wikipedia.org/");
    }

    public void clickOnTheJavaLink() {
        wd.findElement(By.cssSelector("#search-form> fieldset > button> i")).click();
    }

    public void faidAndClickOnTheJavaLink() {
        wd.findElement(By.cssSelector("#searchInput")).sendKeys("java");
    }


}
