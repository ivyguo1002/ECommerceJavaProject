package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    WebDriver driver;
    @FindBy(linkText = "My Wishlist")
    WebElement myWishListLink;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyWishListPage goToMyWishList() {
        myWishListLink.click();
        return new MyWishListPage(driver);
    }
}
