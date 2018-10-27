package com.telran.addressbook.tests;

import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        app.openContactPage();
        if (!isContactPresent()) {
            createContact();
        }
    }

    @Test
    public void testContactModification(){
       // openHomePage();
        int before = getContactsCount();
        app.getContactHelper().selectContactByIndex(before-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new Contact().
                setFirstName("Vasy")
                .setLastName("Ivanov")
                .setAddress("London")
                .setTelephone("220222")
                .setEmail("zx@cv"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        int after = getContactsCount();
        Assert.assertEquals(after,before);
    }

}
