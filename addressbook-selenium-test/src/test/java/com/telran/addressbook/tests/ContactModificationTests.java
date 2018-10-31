package com.telran.addressbook.tests;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        app.getContactHelper().openContactPage();
        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }
    }
    @Test
    public void testContactModification(){
       // openHomePage();
        int before = app.getContactCount();
       // app.getContactHelper().selectContactByIndex(before-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new Contact().
                setFirstName("Vasy")
                .setLastName("Ivanov")
                .setAddress("London")
                .setTelephone("220222")
                .setEmail("zx@cv"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactCount();
        Assert.assertEquals(after,before);
    }

}
