package addressbook.manager;

import addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

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

    public void openContactCreationPage() {
        click(By.cssSelector("[href='edit.php']"));

    }

    public void openContactPage() {
        click(By.cssSelector("[href='./']"));
    }


    public boolean isContactPresent() {
        isElementPresent(By.name("selected[]"));
        return true;
    }

    public void createContact() {
        openContactCreationPage();
        fillContactForm(new Contact()
                .setFirstName("Vasy")
                .setLastName("Ivanov")
                .setAddress("Kyiv")
                .setTelephone("220222")
                .setEmail("zx@cv"));
        submitContactCreation();
        returnToContactPage();

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
