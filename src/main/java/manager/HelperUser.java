package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginRegForm(){
       // WebElement logTab = wd.findElement(By.cssSelector("a[href='login']"));
        //xPath ++>//a[text()='LOGIN']

        click(By.cssSelector("a[href='/login']"));

    }

    public void fillLoginRegForm(String email, String password) {
       // WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);


       // WebElement passwordInput = wd.findElement(By.xpath("//input{last()]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"), password);

    }
    public void sumitLogin(){
        click(By.xpath("//button[text()='Login']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }
}
