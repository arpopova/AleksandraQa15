package com.telran.addressbook.tests;

import com.telran.addressbook.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        app.start();

    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }


}
