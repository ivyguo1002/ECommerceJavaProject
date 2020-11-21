package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MobilePage {
    private WebDriver driver;
    @FindBy(xpath = "//a[contains(., 'Mobile')]")
    WebElement mobileMenu;
    @FindBy(css = "button[title='Compare']")
    WebElement compareBtn;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);;
    }

    public ShoppingCartPage addToCart(String model) {
        driver.findElement(By.xpath("//h2[@class='product-name'][contains(., '" + model + "')]//following-sibling::div/button[contains(@class, 'btn-cart')]"))
                .click();
        return new ShoppingCartPage(driver);
    }

    public MobilePage addToCompare(String model) {
        driver.findElement(By.xpath("//h2[@class='product-name'][contains(., '" + model + "')]//following-sibling::div/ul//li/a[@class='link-compare']"))
                .click();
        return this;
    }

    public void compare() {
        compareBtn.click();
    }
}
