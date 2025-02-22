package tests;

import models.Contacts;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("firiall68@gmail.com").setPassword("Tele2user84!"));
        }
    }
    @Test
    public void addNewContactSuccessFull(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598562")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();

       // app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactSuccessRequired(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598562")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description(" ")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name(" ")
                .lastname("Brown")
                .phone("0536598562")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyLastName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname(" ")
                .phone("0536598562")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyPhone(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone(" ")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(
                "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test
    public void addNewContactEmptyEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598562")
                .email(" ")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyAddress(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598562")
                .email("Olga1@gmail.com")
                .address(" ")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactWrongPhone(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598s")
                .email("Olga1@gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(
                "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test
    public void addNewContactWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contacts contact = Contacts.builder()
                .name("Olga")
                .lastname("Brown")
                .phone("0536598562")
                .email("Olga1gmail.com")
                .address("Norday,18, Haifa")
                .description("friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid:"));
    }
}
