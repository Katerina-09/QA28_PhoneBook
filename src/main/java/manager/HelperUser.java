package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginRegForm(){
       // WebElement logTab = wd.findElement(By.cssSelector("a[href='login']"));
        //xPath ++>//a[text()='LOGIN']

        click(By.cssSelector("a[href='/login']"));

    }

    public void fillLoginRegForm(User user) {

        type(By.name("email"), user.getEmail());



        type(By.xpath("//input[last()]"), user.getPassword());

    }
    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void fillWrongLoginRegForm(String email, String password) {
        type(By.name("email"), email);



        type(By.xpath("//input[last()]"), password);
    }

    public String getMessage() {
        pause(2000);
        return wd.findElement(By.xpath("//div[text()='Registration failed with code 400']")).getText();
    }

    public void submitReg() {
        click(By.xpath("//button[text()='Registration']"));

    }
    public boolean isAdded() {
        return  isElementPresent(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }
    public void login(User user) {
        openLoginRegForm();
        fillLoginRegForm(user);
        submitLogin();
    }


}
