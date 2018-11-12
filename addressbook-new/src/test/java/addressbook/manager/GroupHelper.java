package addressbook.manager;

import addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends  HelperBase{


    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a[href='group.php']"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
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
}
