package addressbook.tests;

import com.telran.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getGroupHelper().openGroupPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().creatGroup();
        }
    }

    @Test
    public void testGroupModification() {
        app.getGroupHelper().openGroupPage();
        int before = app.getGroupsCount();
        app.selectGroupByIndex(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupHeader("modifyed")
                .setGroupName("new")
                .setGroupFooter("Changed"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupsCount();
        Assert.assertEquals(after, before);
    }

}
