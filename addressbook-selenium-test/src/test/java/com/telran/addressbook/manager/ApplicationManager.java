package com.telran.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navigationHelper.openSite("http://localhost/addressbook/");

        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);

    }




    public void stop() {
        wd.quit();
    }

    //=======================================================
    public void returnToContactPage() {
        groupHelper.click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        groupHelper.click(By.name("submit"));
    }

    public void fillContactForm(String firstName, String lastName, String address, String telephone, String email) {
        groupHelper.type(By.name("firstname"), firstName);
        groupHelper.type(By.name("lastname"), lastName);
        groupHelper.type(By.name("address"), address);
        groupHelper.type(By.name("home"), telephone);
        groupHelper.type(By.name("email"), email);
    }

    public void openContactPage() {
        groupHelper.click(By.cssSelector("[href='edit.php']"));
    }

    public void openHomePage() {
        groupHelper.click(By.cssSelector("[href='./']"));
        //"#nav > ul > li:nth-child(1) > a"
    }

    public void submitContactModification() {
        groupHelper.click(By.name("update"));
    }

    public void initContactModification() {
        groupHelper.click(By.cssSelector("[title=Edit]"));
    }

    public void selectContact() {
        groupHelper.click(By.cssSelector("[type=checkbox]"));
        // [type=checkbox]"#'31 4"
    }

    public void deleteContact() {
        groupHelper.click(By.cssSelector("[value=Delete]"));

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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
