package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerPageBtn = By.xpath("//a[@href='/register?returnUrl=%2F']");
    private final By loginPageBtn = By.xpath("//a[@class='ico-login']");
    private final By searchInputField = By.id("small-searchterms");
    private final By searchSubmitBtn = By.xpath("//button[@type='submit']");
    private final By switchCurrencies = By.xpath("//select[@id='customerCurrency']");
    private final By logOutBtn = By.xpath("//a[@class='ico-logout']");
    private final By msgFailedLogin = By.xpath("//div[@class='message-error validation-summary-errors']");
    private final By productDisplayForSearch = By.xpath("(//a[@href='/apple-macbook-pro-13-inch'])[2]");
    private final By euroSignDisplayed = By.xpath("(//span[@class='price actual-price'])[3]");
    private final By wishListBtn = By.xpath("//a[@href='/wishlist']");
    private final By compareListBtn = By.xpath("(//a[@href='/compareproducts'])[1]");

    public P01_HomePage clickRegisterBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerPageBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerPageBtn).click();
        return this;
    }

    public P01_HomePage clickLoginBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginPageBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginPageBtn).click();
        return this;
    }

    public P01_HomePage fillDataInSearchField(String productName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.searchInputField));
        driver.findElement(this.searchInputField).sendKeys(productName);
        return this;
    }

    public P01_HomePage clickOnSearchBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.searchSubmitBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(searchSubmitBtn).click();
        return this;
    }

    public P01_HomePage chooseCurrency(int index) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.switchCurrencies));
        WebElement switchCurrencies = driver.findElement(this.switchCurrencies);
        Select currency = new Select(switchCurrencies);
        currency.selectByIndex(index);
        return this;
    }

    public String getLogoutBtn() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.logOutBtn));
        return driver.findElement(this.logOutBtn).getText();
    }

    public P01_HomePage waitUntilPageLoad(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.logOutBtn));
        return this;
    }

    public String getFailedLoginMsg() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.msgFailedLogin));
        return driver.findElement(this.msgFailedLogin).getText();
    }

    public boolean validateIfProductsDisplayAfterSearch() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productDisplayForSearch));
        return driver.findElement(this.productDisplayForSearch).getText().contains("Apple");
    }

    public P01_HomePage waitUntilProductDisplay(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productDisplayForSearch));
        return this;
    }

    public boolean validateIfCurrencyChanged() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.switchCurrencies));
        return driver.findElement(this.euroSignDisplayed).getText().contains("€");
    }

    public P01_HomePage waitUntilCurrencyChange(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.euroSignDisplayed));
        return this;
    }

    public P01_HomePage clickOnWishList() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.wishListBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.wishListBtn).click();
        return this;
    }

    public P01_HomePage clickOnComparisonList() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.compareListBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.compareListBtn).click();
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
