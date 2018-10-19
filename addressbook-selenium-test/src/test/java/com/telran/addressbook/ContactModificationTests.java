package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        openHomePage();
        selectContact();
        initContactModification();
        fillContactForm("Vasy", "Ivanov", "London", "220222", "zx@cv");
        submitContactModification();
        returnToContactPage();
    }

}
