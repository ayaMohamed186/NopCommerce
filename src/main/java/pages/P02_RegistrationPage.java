package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P02_RegistrationPage {
    WebDriver driver;

    public P02_RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameInputField = By.xpath("//input[@id='FirstName']");
    private final By secondNameInputField = By.xpath("//input[@id='LastName']");
    private final By dayElement = By.xpath("//select[@name=\"DateOfBirthDay\"]");
    private final By monthElement = By.xpath("//select[@name='DateOfBirthMonth']");
    private final By yearElement = By.xpath("//select[@name=\"DateOfBirthYear\"]");
    private final By emailInputField = By.id("Email");
    private final By companyDetailsElement = By.xpath("//input[@id='Company']");
    private final By passwordInputField = By.id("Password");
    private final By confirmPasswordInputField = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    private final By registerMsgDisplay = By.xpath("//div[@class='result']");
    private final By repeatMailMsgDisplay = By.xpath("//div[@class='message-error validation-summary-errors']/ul/li");
    private final By unMatchPasswordMsgDisplay = By.xpath("//span[@id='ConfirmPassword-error']");

    public P02_RegistrationPage chooseGender() {
        driver.findElement(By.xpath("(//input[@type='radio'])[" + generateRandomInt(2) + "]")).click();
        return this;
    }

    public P02_RegistrationPage fillFirstName(String firstName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }

    public P02_RegistrationPage fillLastName(String lastName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.secondNameInputField));
        driver.findElement(this.secondNameInputField).sendKeys(lastName);
        return this;
    }

    public P02_RegistrationPage selectDay(int index) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.dayElement));
        WebElement dayElement = driver.findElement(this.dayElement);
        Select day = new Select(dayElement);
        day.selectByIndex(index);
        return this;
    }

    public P02_RegistrationPage selectMonth(int index) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.monthElement));
        WebElement monthElement = driver.findElement(this.monthElement);
        Select month = new Select(monthElement);
        month.selectByIndex(index);
        return this;
    }

    public P02_RegistrationPage selectYear(int value) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.yearElement));
        WebElement yearElement = driver.findElement(this.yearElement);
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByIndex(value);
        return this;
    }

    public P02_RegistrationPage fillEmailInputField(String mail) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.emailInputField));
        driver.findElement(this.emailInputField).sendKeys(mail);
        return this;
    }

    public P02_RegistrationPage fillCompanyDetails(String companyDetails) {
        driver.findElement(this.companyDetailsElement).sendKeys(companyDetails);
        return this;
    }

    public P02_RegistrationPage fillPasswordField(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(password);
        return this;
    }

    public P02_RegistrationPage fillConfirmPassword(String confirmPassword) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmPasswordInputField));
        driver.findElement(this.confirmPasswordInputField).sendKeys(confirmPassword);
        return this;
    }

    public P02_RegistrationPage clickRegisterBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerBtn).click();
        return this;
    }

    public String getDisplayedRegisterMsg() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.registerMsgDisplay));
        return driver.findElement(this.registerMsgDisplay).getText();
    }

    public String getRepeatMailMsg() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.repeatMailMsgDisplay));
        return driver.findElement(this.repeatMailMsgDisplay).getText();
    }

    public String getUnMatchMsg() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.unMatchPasswordMsgDisplay));
        return driver.findElement(this.unMatchPasswordMsgDisplay).getText();
    }

    public P02_RegistrationPage waitUntilPageLoad(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.registerMsgDisplay));
        return this;
    }

}
