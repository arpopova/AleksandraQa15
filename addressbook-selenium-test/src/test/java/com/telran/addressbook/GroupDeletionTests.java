package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        app.openGroupPage();
       if(!app.isGroupPresent()){
           app.creatGroup();
       }
    }

    @Test
    public void testGroupDeletion(){
        app.openGroupPage();
        int before = app.getGroupsCount();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupsPage();
        int after = app.getGroupsCount();
        Assert.assertEquals(after,before-1);

    }

}
