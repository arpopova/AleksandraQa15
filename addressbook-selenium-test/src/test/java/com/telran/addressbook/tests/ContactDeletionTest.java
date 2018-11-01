package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
@BeforeMethod
public void preconditions() {
    app.getContactHelper().openContactPage();
    if (!app.getContactHelper().isContactPresent()) {
        app.getContactHelper().createContact();
    }
}
    @Test
    public void testContactDeletion () {
       // app.openHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
      
//        returnToContactPage();
int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1);
    }

}
