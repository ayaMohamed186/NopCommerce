package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

import static util.Utility.generateRandomInt;

public class P02_RegistrationPage {
    WebDriver driver;
    public P02_RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    private final By genderRadioBtn = By.xpath("(//input[@type='radio'])[1]");
    private final By firstNameInputField = By.xpath("//input[@id='FirstName']");
    private final By secondNameInputField = By.xpath("//input[@id='LastName']");
    private final  By dayElement = By.xpath("//select[@name=\"DateOfBirthDay\"]");
    private final By monthElement = By.xpath("//select[@name='DateOfBirthMonth']");
    private final By yearElement = By.xpath("//select[@name=\"DateOfBirthYear\"]");
    private final By emailInputField = By.id("Email");
    private final By companyDetailsElement = By.xpath("//input[@id='Company']");
    private final By passwordInputField = By.id("Password");
    private final By confirmPasswordInputField = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");

    public P02_RegistrationPage chooseGender(){
        driver.findElement(By.xpath("(//input[@type='radio'])["+generateRandomInt(2)+"]")).click();
        return this;
    }

    public P02_RegistrationPage fillFirstName(String firstName){
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P02_RegistrationPage fillLastName(String lastName){
        driver.findElement(this.secondNameInputField).sendKeys(lastName);
        return this;
    }

    public P02_RegistrationPage selectDay(int index){
        WebElement dayElement = driver.findElement(this.dayElement);
        Select day=new Select(dayElement);
        day.selectByIndex(index);
        return this;
    }

    public P02_RegistrationPage selectMonth(int index)
    {
        WebElement monthElement = driver.findElement(this.monthElement);
        Select month=new Select(monthElement);
        month.selectByIndex(index);
        return this;
    }

    public P02_RegistrationPage selectYear(int value){
        WebElement yearElement = driver.findElement(this.yearElement);
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByIndex(value);
        return this;
    }

    public P02_RegistrationPage fillEmailInputField(String mail){
        driver.findElement(this.emailInputField).sendKeys(mail);
        return this;
    }

    public P02_RegistrationPage fillCompanyDetails(String companyDetails){
        driver.findElement(this.companyDetailsElement).sendKeys(companyDetails);
        return this;
    }

    public P02_RegistrationPage fillPasswordField(String password){
        driver.findElement(this.passwordInputField).sendKeys(password);
        return this;
    }

    public P02_RegistrationPage fillConfirmPassword(String confirmPassword){
        driver.findElement(this.confirmPasswordInputField).sendKeys(confirmPassword);
        return this;
    }

    public P02_RegistrationPage clickRegisterBtn(){
        driver.findElement(this.registerBtn).click();
        return this;
    }

}
