package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P06_SubCategoryShoesPage {
    WebDriver driver;

    public P06_SubCategoryShoesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By apperalCategory = By.xpath("(//div[@class='header-menu']/ul/li)[3]");
    private final By shoesSubCategory = By.xpath("(//a[@href='/shoes'])[1]");
    private final By greyFilterOption = By.id("attribute-option-14");
    private final By randomSubCategory = By.xpath("//div[@class='header-menu']/ul/li[3]/ul/li[" + generateRandomInt(3) + "]");

    private final By addToCartBtnForFirstProduct = By.xpath("(//button[@type='button'])[1]");
    private final By addToWishListBtnForThirdProduct = By.xpath("(//button[@type='button'])[9]");
    private final By addToCompareListBtnForSecondProduct = By.xpath("(//button[@type='button'])[5]");

    public P06_SubCategoryShoesPage hoverOnApperalCategory() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.apperalCategory));
        WebElement apperalCategory = driver.findElement(this.apperalCategory);
        Actions hover = new Actions(driver);
        hover.moveToElement(apperalCategory).perform();
        return this;
    }

    public P06_SubCategoryShoesPage clickOnShoesSubCategory() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.shoesSubCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.shoesSubCategory).click();
        return this;
    }

    public P06_SubCategoryShoesPage selectGreyFilterOption() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.greyFilterOption));
        driver.findElement(this.greyFilterOption).click();
        return this;
    }

    public P06_SubCategoryShoesPage selectRandomSubCategory() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.randomSubCategory));
        driver.findElement(this.randomSubCategory).click();
        return this;
    }

    public P06_SubCategoryShoesPage addFirstProductToCartProductPage() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addToCartBtnForFirstProduct));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addToCartBtnForFirstProduct).click();
        return this;
    }

    public P06_SubCategoryShoesPage addThirdProductToWishList() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.addToWishListBtnForThirdProduct));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addToWishListBtnForThirdProduct).click();
        return this;
    }

    public P06_SubCategoryShoesPage addSecondProductToCompareList() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addToCompareListBtnForSecondProduct));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addToCompareListBtnForSecondProduct).click();
        return this;
    }

}
