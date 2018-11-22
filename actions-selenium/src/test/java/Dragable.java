import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Dragable extends TestBase {

    @Test
    public void testDragable(){
        wd.get("http://localhost/tests/drag.html");
        WebElement box = wd.findElement(By.cssSelector("#draggable"));
        new Actions(wd).moveToElement(box)
                .clickAndHold()
                .moveByOffset(200,200)
                .pause(3000)
                .moveByOffset(100,-100)
                .release()
                .perform();
    }
}
