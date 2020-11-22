package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage {
    WebDriver driver;
    @FindBy (className = "btn-add")
    WebElement addAllToCartBtn;
    public MyWishListPage (WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartPage addAllToCart() {
        addAllToCartBtn.click();
        return new ShoppingCartPage(driver);
    }


}

