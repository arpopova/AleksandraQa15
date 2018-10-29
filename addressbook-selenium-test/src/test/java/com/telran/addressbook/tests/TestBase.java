package com.telran.addressbook.tests;

import com.telran.addressbook.manager.ApplicationManager;
import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    WebDriver wd;

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() {
        app.start();

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
