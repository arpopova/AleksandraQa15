package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        openHomePage();
        selectContact();
        deleteContact();
        returnToContactPage();

    }

    public void deleteContact() {
        wd.findElement(By.cssSelector("[value=Delete]")).click();
        wd.switchTo().alert().sendKeys("ok");
    }

}
