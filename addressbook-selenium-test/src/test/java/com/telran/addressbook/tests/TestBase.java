package com.telran.addressbook.tests;

import com.telran.addressbook.manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sun.plugin2.util.BrowserType;

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
