package com.telran.addressbook.tests;


import com.telran.addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test

    public void testContactCreation() {

        app.openContactPage();
        int before = getContactsCount();

        app.getContactHelper().fillContactForm(new Contact()
                .setFirstName("Vasy")
                .setLastName("Ivanov")
                .setAddress("Kyiv")
                .setTelephone("220222")
                .setEmail("zx@cv"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        int after = getContactsCount();
        Assert.assertEquals(after,before+1);
    }


}


