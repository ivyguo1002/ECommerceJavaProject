package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {
        prop = System.getProperties();
        prop.load(new FileInputStream("resources/config.properties"));
        String browserType = prop.getProperty("browser");
        switch (browserType) {
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", "en,en-US");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                break;
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
