package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
       // openHomePage();
        app.selectContact();
        app.initContactModification();
        app.fillContactForm("Vasy", "Ivanov", "London", "220222", "zx@cv");
        app.submitContactModification();
        app.returnToContactPage();
    }

}
