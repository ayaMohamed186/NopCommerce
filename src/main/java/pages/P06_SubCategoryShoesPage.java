package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static util.Utility.generateRandomInt;

public class P06_SubCategoryShoesPage {
    WebDriver driver;
    public P06_SubCategoryShoesPage(WebDriver driver){
        this.driver = driver;
    }

    private final By apperalCategory = By.xpath("(//div[@class='header-menu']/ul/li)[3]");
    private final By shoesSubCategory = By.xpath("(//a[@href='/shoes'])[1]");
    private final By greyFilterOption = By.id("attribute-option-14");
    private final By randomSubCategory = By.xpath("//div[@class='header-menu']/ul/li[3]/ul/li["+generateRandomInt(3)+"]");

    private final By addToCartBtnForFirstProduct = By.xpath("(//button[@type='button'])[1]");
    private final By addToWishListBtnForThirdProduct = By.xpath("(//button[@type='button'])[9]");
    private final By addToCompareListBtnForSecondProduct = By.xpath("(//button[@type='button'])[5]");

    public P06_SubCategoryShoesPage hoverOnApperalCategory(){
        WebElement apperalCategory = driver.findElement(this.apperalCategory);
        Actions hover = new Actions(driver);
        hover.moveToElement(apperalCategory).perform();
        return this;
    }

    public P06_SubCategoryShoesPage clickOnShoesSubCategory(){
        driver.findElement(this.shoesSubCategory).click();
        return this;
    }

    public P06_SubCategoryShoesPage selectGreyFilterOption(){
        driver.findElement(this.greyFilterOption).click();
        return this;
    }

    public P06_SubCategoryShoesPage selectRandomSubCategory(){
        driver.findElement(this.randomSubCategory).click();
        return this;
    }

    public P06_SubCategoryShoesPage addFirstProductToCartProductPage(){
        driver.findElement(this.addToCartBtnForFirstProduct).click();
        return this;
    }

    public P06_SubCategoryShoesPage addThirdProductToWishList(){
        driver.findElement(this.addToWishListBtnForThirdProduct).click();
        return this;
    }

    public P06_SubCategoryShoesPage addSecondProductToCompareList(){
        driver.findElement(this.addToCompareListBtnForSecondProduct).click();
        return this;
    }
}
