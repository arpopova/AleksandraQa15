package com.telran.addressbook.tests;

import com.telran.addressbook.manager.ApplicationManager;
import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
WebDriver wd;

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        app.start();

    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
public boolean isContactPresent(){
        isElementPresent(By.name("selected[]"));
        return true;
}

    public void createContact() {
        app.openContactPage();
        app.getContactHelper().fillContactForm(new Contact()
                .setFirstName("Vasy")
                .setLastName("Ivanov")
                .setAddress("Kyiv")
                .setTelephone("220222")
                .setEmail("zx@cv"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();

    }

    public int getContactsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
