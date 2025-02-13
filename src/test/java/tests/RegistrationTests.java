package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{


        @BeforeMethod
        public void preCondition() {
            //if SingOut present ===>logout
            if (app.getHelperUser().isLogged())
                app.getHelperUser().logout();

        }

        @Test
        public void regSuccess() {
            Random random = new Random();
            int i = random.nextInt(1000) + 1000;

            User user = new User()
                    .setEmail("snow" + i + "@gmail.com")
                    .setPassword("Snow123456$");

            app.getHelperUser().openLoginRegForm();
            app.getHelperUser().fillLoginRegForm(user);
            app.getHelperUser().submitReg();

            Assert.assertTrue(app.getHelperUser().isLogged());


        }
    @Test
    public void regWrongEmail(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("firiall6gmail.com","Tele2user84$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void regWrongPassword(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("firiall68@gmail.com","Tele2");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void regregisteredUser(){
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillWrongLoginRegForm("firiall68@gmail.com","Tele2user84!");
        app.getHelperUser().submitReg();
        app.getHelperUser().pause(5000);


        Assert.assertTrue(app.getHelperUser().isAlertPresent("Registration failed with code 400"));
        //Assert.assertEquals(app.getHelperUser().getMessage(), "Registration failed with code 400");


    }
    }