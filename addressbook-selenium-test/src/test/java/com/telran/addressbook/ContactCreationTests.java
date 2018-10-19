package com.telran.addressbook;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test

    public void tectContactCreation() {

        openContactPage();
        fillContactForm("Vasy", "Ivanov", "Kyiv", "220222", "zx@cv");
        submitContactCreation();
        returnToContactPage();

    }

}


