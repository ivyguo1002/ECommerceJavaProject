package pages;

import datamodel.Credential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "email")
    WebElement emailTextBox;
    @FindBy(id = "pass")
    WebElement passwordTextBox;
    @FindBy(id = "send2")
    WebElement loginBtn;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public AccountPage login(Credential user) {
        emailTextBox.sendKeys(user.getEmail());
        passwordTextBox.sendKeys(user.getPassword());
        loginBtn.click();
        return new AccountPage(driver);
    }
}
