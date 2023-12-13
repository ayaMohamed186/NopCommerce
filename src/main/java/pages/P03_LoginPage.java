package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P03_LoginPage {
    WebDriver driver ;
    public P03_LoginPage(WebDriver driver){
        this.driver=driver;
    }
    // 3- define locators
    private final By email=By.id("Email");
    private final By password=By.id("Password");
    private final By loginButton=By.xpath("(//button[@type='submit'])[2]");

    private final By forgetPasswordBtn = By.xpath("//a[@href='/passwordrecovery']");
    public P03_LoginPage clickOnForgetPassword(){
        driver.findElement(this.forgetPasswordBtn).click();
        return this;
    }

    public P03_LoginPage fillEmail(String email){
        driver.findElement(this.email).sendKeys(email);
        return this;
    }
    public P03_LoginPage fillPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P03_LoginPage clickLoginButton(){
        driver.findElement(this.loginButton).click();
        return this;
    }
}
