import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

    WebDriver wd;

    @BeforeClass
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
    }

        @AfterClass
                public void tearDawn() throws InterruptedException {
            Thread.sleep(3000);
            wd.quit();

    }
}
