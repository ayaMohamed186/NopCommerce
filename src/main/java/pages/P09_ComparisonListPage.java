package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P09_ComparisonListPage {
    WebDriver driver;

    public P09_ComparisonListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productAddedToCompareList = By.xpath("//tr[@class='product-name']//td[2]//a");

    public String getProductAddedToCompareList(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productAddedToCompareList));
        return driver.findElement(this.productAddedToCompareList).getText();
    }

}
