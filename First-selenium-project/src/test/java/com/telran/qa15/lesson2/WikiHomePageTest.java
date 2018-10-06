package com.telran.qa15.lesson2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiHomePageTest extends TestBese {

    @Test
public void testOpeningEnglishWiki(){
        findAndClickOnTheEnglishLink();
        String currentUrl = wd.getCurrentUrl();

        Assert.assertEquals(currentUrl ,"https://en.wikipedia.org/wiki/Main_Page");

    }

}




