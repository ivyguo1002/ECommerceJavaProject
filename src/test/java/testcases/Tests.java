package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.MobilePage;
import pages.ShoppingCartPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class Tests extends BaseTest {
    @Test
    public void productAddedToCartShouldNotBeMoreThanTheAvailableAmount() {
        driver.get(prop.getProperty("homepage"));
        HomePage homePage = new HomePage(driver);
        MobilePage mobilePage = homePage.navigateToMobilePage();
        ShoppingCartPage shoppingCartPage = mobilePage.addToCart("Sony Xperia");
        shoppingCartPage.editQty("1000");

        Assert.assertTrue(shoppingCartPage.getItemMsg().contains("* The maximum quantity allowed for purchase is 500."));
    }

    @Test
    public void userShouldBeAbleToCompareTwoProducts(){
        driver.get(prop.getProperty("homepage"));
        HomePage homePage = new HomePage(driver);
        MobilePage mobilePage = homePage.navigateToMobilePage();
        mobilePage.addToCompare("Sony Xperia")
                .addToCompare("IPhone")
                .compare();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(numberOfWindowsToBe(2));

        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        String originalWindow = driver.getWindowHandle();
        for(String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        ComparePage comparePage = new ComparePage(driver);
        Assert.assertEquals(comparePage.getHeading(), "COMPARE PRODUCTS" );
        Assert.assertEquals(comparePage.getProductsList(),
                new ArrayList<String>(Arrays.asList("SONY XPERIA", "IPHONE")));
        comparePage.closeWindow();
        try {
        	wait.until(numberOfWindowsToBe(1));
        }
        catch(Exception e) {
        	Assert.fail();
        }
    }

}
