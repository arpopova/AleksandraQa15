package com.telran.qa15.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WikiHomePageTestJava extends TestBase{

    @Test
public void tectOpeningWikiJava() throws InterruptedException {


   // WebElement searchFl = wd.findElement(By.cssSelector("#searchInput"));
   // searchFl.sendKeys("java");

    faidAndClickOnTheJavaLink();
    Thread.sleep(5000);

    clickOnTheJavaLink();
    Thread.sleep(5000);

    String currentUrl = wd.getCurrentUrl();

    Assert.assertEquals(currentUrl,"https://ru.wikipedia.org/wiki/Java");
}

}
