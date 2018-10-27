package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getTelephone());
        type(By.name("email"), contact.getEmail());
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactModification() {
        click(By.cssSelector("[title=Edit]"));
    }

    public void selectContact() {
       click(By.cssSelector("[type=checkbox]"));

    }

    public void deleteContact() {
        click(By.cssSelector("[value=Delete]"));

        wd.switchTo().alert().accept();
    }

    public void selectContactByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
