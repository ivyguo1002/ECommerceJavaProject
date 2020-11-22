package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath="//a[contains(., 'Mobile')]")
    WebElement mobileMenu;
    @FindBy(css = ".skip-account")
    WebElement accountLink;
    @FindBy(css = "a[title='My Account']")
    WebElement myAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public MobilePage navigateToMobilePage() {
        mobileMenu.click();
        return new MobilePage(driver);
    }

    public LoginPage goToLoginPage() {
        accountLink.click();
        myAccountLink.click();
        return new LoginPage(driver);
    }
}
