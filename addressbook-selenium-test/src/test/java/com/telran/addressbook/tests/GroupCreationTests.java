package com.telran.addressbook.tests;

import com.telran.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupPage();

        int before = app.getGroupsCount();


        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("Sasha")
                .setGroupFooter("footer"));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupsCount();
        Assert.assertEquals(after,before+1);

    }


}
