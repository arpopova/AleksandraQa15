package addressbook.tests;

import com.telran.addressbook.model.Group;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase{
@DataProvider
public Iterator<Object[]>validGroups() throws IOException {
    List<Object[]>list = new ArrayList<>();

    BufferedReader reader = new BufferedReader (new FileReader(new File("")));
    String line = reader.readLine();
    while (line != null){
        String[]split = line.split(";");
      list.add(new Object[]{new Group()
              .setGroupName(split[0])
              .setGroupHeader(split[1])
              .setGroupFooter(split[2])});
        line = reader.readLine();
    }

//    list.add(new Object[]{"test1", "header1","footer1"});
//    list.add(new Object[]{"test2", "header2", "footer2"});
//    list.add(new Object[]{"", "", ""});
//    list.add(new Object[]{"t", "h", "f"});
//    list.add(new Object[]{"looooooong", "heeee", "f"});

    return list.iterator();
}
    @Test(dataProvider = "validGroups")
    public void testGroupCreation(String name, String header, String footer) {
        app.getGroupHelper().openGroupPage();

        int before = app.getGroupsCount();


        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupName(name)
                .setGroupHeader(header)
                .setGroupFooter(footer));

        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupsCount();
        Assert.assertEquals(after,before+1);

    }


}
