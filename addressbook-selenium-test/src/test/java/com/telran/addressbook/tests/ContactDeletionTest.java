package com.telran.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
@BeforeMethod
public void preconditions() {
    app.openContactPage();
    if (!isContactPresent()) {
        createContact();
    }
}
    @Test
    public void testContactDeletion () {
        app.openHomePage();
        int before = getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
//        returnToContactPage();
int after = getContactsCount();
        Assert.assertEquals(after,before-1);
    }

}
