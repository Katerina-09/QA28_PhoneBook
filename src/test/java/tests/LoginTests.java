package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        //if SingOut present ===>logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();

    }
    @Test
    public void loginSuccess(){

       app.getHelperUser().openLoginRegForm();
       app.getHelperUser().fillWrongLoginRegForm("firiall68@gmail.com","Tele2user84!");
       app.getHelperUser().submitLogin();
       //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("firiall68gmail.com","Tele2user84!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("firiall68@gmail.com","Tele2user84");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("fir@gmail.com","Tele2user84!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }



}
