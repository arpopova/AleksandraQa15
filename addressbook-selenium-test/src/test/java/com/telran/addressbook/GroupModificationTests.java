package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
    
    @BeforeMethod
    public void preconditions(){
        openGroupPage();
        if(!isGroupPresent()){
            creatGroup();
        }
    }

    @Test
    public void testGroupModification(){
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group()
                .setGroupHeader("modifyed")
                .setGroupName("new")
                .setGroupFooter("Changed"));
        submitGroupModification();
        returnToGroupsPage();

    }

}
