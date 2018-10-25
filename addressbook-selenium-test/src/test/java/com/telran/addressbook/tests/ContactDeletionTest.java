package com.telran.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        app.openHomePage();
        app.selectContact();
        app.deleteContact();
//        returnToContactPage();

    }

}
