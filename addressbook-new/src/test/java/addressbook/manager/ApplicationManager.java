package addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private  String browser;
    WebDriver wd;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void start() {

        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else  if (browser.equals(BrowserType.FIREFOX)){
            wd= new FirefoxDriver();
        }else if (browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);




        navigationHelper = new NavigationHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook/");

        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");

        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);


    }

    public void stop() {
        wd.quit();
    }



    public void openHomePage() {
        groupHelper.click(By.cssSelector("[href='./']"));

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

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


}

