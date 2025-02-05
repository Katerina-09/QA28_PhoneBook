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
       app.getHelperUser().fillLoginRegForm("firiall68@gmail.com","Tele2user84!");
       app.getHelperUser().sumitLogin();
       //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());


    }

}
