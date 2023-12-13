package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static util.Utility.generateRandomInt;

public class P01_HomePage {
    WebDriver driver;
    public P01_HomePage(WebDriver driver){
        this.driver=driver;
    }

    private final By registerPageBtn = By.xpath( "//a[@href='/register?returnUrl=%2F']");
    private final By loginPageBtn = By.xpath("//a[@class='ico-login']");
    private final By searchInputField = By.id("small-searchterms");
    private final By searchSubmitBtn = By.xpath("//button[@type='submit']");
    private final By switchCurrencies = By.xpath("//select[@id='customerCurrency']");

    public P01_HomePage clickRegisterBtn()
    {
        driver.findElement(this.registerPageBtn).click();
        return this;
    }
    public P01_HomePage clickLoginBtn()
    {
        driver.findElement(this.loginPageBtn).click();
        return this;
    }

    public P01_HomePage fillDataInSearchField(String productName){
        driver.findElement(this.searchInputField).sendKeys(productName);
        return this;
    }

    public P01_HomePage clickOnSearchBtn(){
        driver.findElement(searchSubmitBtn).click();
        return this;
    }

    public P01_HomePage chooseCurrency(int index){
        WebElement switchCurrencies = driver.findElement(this.switchCurrencies);
        Select currency =new Select(switchCurrencies);
        currency.selectByIndex(index);
        return this;
    }
/*


    // locators & actions fot TC06 Select random category
    public List<WebElement> categories(){
        List<WebElement> homePageCatecories = driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
        return homePageCatecories;
    }
    
    public List<WebElement> subCategories(int categoryNum){ //will send random category number chosen
        categoryNum = categoryNum+1; // first Li with index 1 not 0 , first index in category is 0
        List<WebElement> subCategories = driver.findElements((By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+ categoryNum + "]/ul[@class=\"sublist first-level\"]/li"))) ;
        return subCategories;
    }
*/
}
