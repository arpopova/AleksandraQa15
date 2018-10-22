package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.openGroupPage();

        int before = app.getGroupsCount();


        app.initGroupCreation();
        app.fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("Sasha")
                .setGroupFooter("footer"));

        app.submitGroupCreation();
        app.returnToGroupsPage();

        int after = app.getGroupsCount();
        Assert.assertEquals(after,before+1);

    }


}
