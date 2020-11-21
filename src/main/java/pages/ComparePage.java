package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

public class ComparePage {
    private WebDriver driver;
    @FindBy(css = "h1")
    WebElement heading;
    @FindAll(@FindBy(css="h2.product-name"))
    List<WebElement> productNames;
    @FindBy(css = "button[title='Close Window']")
    WebElement closeWindowBtn;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public String getHeading() {
        return heading.getText();
    }

    public List<String> getProductsList() {
        ArrayList<String> nameList = new ArrayList<String>();
        for ( WebElement productName : productNames) {
            nameList.add(productName.getText());
        }
        return nameList;
    }

	public void closeWindow() {	
		closeWindowBtn.click();
	}
}
