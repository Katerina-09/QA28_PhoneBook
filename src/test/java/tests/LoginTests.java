package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
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
