package com.telran.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");

        login("admin", "secret");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("[type=submit]"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a[href='group.php']"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupPage() {
        click(By.cssSelector("a[href='group.php']"));
    }

    public void stop() {
        wd.quit();
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.name("edit"));

    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void creatGroup() {
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("Sasha")
                .setGroupFooter("footer"));

        submitGroupCreation();
        returnToGroupsPage();


    }

    //=======================================================
    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(String firstName, String lastName, String address, String telephone, String email) {
        type(By.name("firstname"), firstName);
        type(By.name("lastname"), lastName);
        type(By.name("address"), address);
        type(By.name("home"), telephone);
        type(By.name("email"), email);
    }

    public void openContactPage() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void openHomePage() {
        click(By.cssSelector("[href='./']"));
        //"#nav > ul > li:nth-child(1) > a"
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactModification() {
        click(By.cssSelector("[title=Edit]"));
    }

    public void selectContact() {
        click(By.cssSelector("[type=checkbox]"));
        // [type=checkbox]"#'31 4"
    }

    public void deleteContact() {
        click(By.cssSelector("[value=Delete]"));

      //  #content > form:nth-child(10) > div:nth-child(8) > input[type="button"]
       // [value='Delete']"    [ value="Delete"]
        wd.switchTo().alert().accept();
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
