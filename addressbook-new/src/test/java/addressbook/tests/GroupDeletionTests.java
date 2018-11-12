package addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        app.getGroupHelper().openGroupPage();
       if(!app.getGroupHelper().isGroupPresent()){
           app.getGroupHelper().creatGroup();
       }
    }

    @Test
    public void testGroupDeletion(){
        app.getGroupHelper().openGroupPage();
        int before = app.getGroupsCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupsCount();
        Assert.assertEquals(after,before-1);

    }

}
