package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        openGroupPage();
        initGroupCreation();
        fillGroupForm(new Group()
                .setGroupName("Qa15")
                .setGroupHeader("Sasha")
                .setGroupFooter("footer"));

        submitGroupCreation();
        returnToGroupsPage();


    }


}
