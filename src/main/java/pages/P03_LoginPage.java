package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P03_LoginPage {
    WebDriver driver;

    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By loginButton = By.xpath("(//button[@type='submit'])[2]");

    public P03_LoginPage fillEmail(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.email));
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public P03_LoginPage fillPassword(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    public P03_LoginPage clickLoginButton() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginButton));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginButton).click();
        return this;
    }
}
