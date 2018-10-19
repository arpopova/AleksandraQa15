package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        openGroupPage();
       if(!isGroupPresent()){
           creatGroup();
       }
    }

    @Test
    public void testGroupDeletion(){
        openGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();

    }

}
