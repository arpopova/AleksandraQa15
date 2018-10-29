package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
@BeforeMethod
public void preconditions() {
    app.getContactHelper().openContactCreationPage();
    if (!app.getContactHelper().isContactPresent()) {
        app.getContactHelper().createContact();
    }
}
    @Test
    public void testContactDeletion () {
        app.openHomePage();
        int before = app.getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
//        returnToContactPage();
int after = app.getContactCount();
        Assert.assertEquals(after,before-1);
    }

}
