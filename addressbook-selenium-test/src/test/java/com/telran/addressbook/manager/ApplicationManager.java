package com.telran.addressbook.manager;

import com.telran.addressbook.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private ContactHelper contactHelper;
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

        contactHelper = new ContactHelper(wd);

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);

    }




    public void stop() {
        wd.quit();
    }

    public void openContactPage() {
        groupHelper.click(By.cssSelector("[href='edit.php']"));
    }

    public void openHomePage() {
        groupHelper.click(By.cssSelector("[href='./']"));
        //"#nav > ul > li:nth-child(1) > a"
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

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
