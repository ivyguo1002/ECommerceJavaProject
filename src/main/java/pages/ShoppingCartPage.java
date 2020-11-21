package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingCartPage {
        private WebDriver driver;

    @FindBy(css ="td.product-cart-actions input.qty.input-text")
    WebElement qtyTextBox;
    @FindBy(css = "button[title='Update']")
    WebElement updateBtn;
    @FindBy(css = ".error")
    WebElement itemMsg;

    public ShoppingCartPage(WebDriver driver) {
            this.driver = driver;
            AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
            PageFactory.initElements(factory, this);
        }

    public void editQty(String s) {
        qtyTextBox.click();
        qtyTextBox.clear();
        qtyTextBox.sendKeys(s);

        updateBtn.click();
    }

    public String getItemMsg(){
        return itemMsg.getText();
    }
}
