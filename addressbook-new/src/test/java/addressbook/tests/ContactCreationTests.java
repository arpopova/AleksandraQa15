package addressbook.tests;


import addressbook.model.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test

    public void testContactCreation() {
//       app.getNavigationHelper().openSite("http://localhost/addressbook/");
//        app.getSessionHelper().login("admin","secret");
        app.getContactHelper().openContactPage();
        int before = app.getContactCount();

        app.getContactHelper().openContactCreationPage();



        app.getContactHelper().fillContactForm(new Contact()
                .setFirstName("1Vasy")
                .setLastName("Ivanov")
               .setAddress("Kyiv")
                .setTelephone("220222")
               .setEmail("zx@cv"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactCount();
        Assert.assertEquals(after, before + 1);
    }


}


