package com.telran.addressbook.tests;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test

    public void tectContactCreation() {

        app.openContactPage();
        app.fillContactForm("Vasy", "Ivanov", "Kyiv", "220222", "zx@cv");
        app.submitContactCreation();
        app.returnToContactPage();

    }

}


