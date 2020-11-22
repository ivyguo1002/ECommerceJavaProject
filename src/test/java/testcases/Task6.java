package testcases;

import datamodel.Credential;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.ReadExcelFile;

public class Task6 extends BaseTest {
    @DataProvider
    public Object[][] userCredential(){
        return new Object[][]{{"fakeUser@gmail.com", "123456"}};
    }

    @DataProvider (name = "testdata")
    public Object[][] userCredentials(){
        ReadExcelFile config = new ReadExcelFile("resources/testdata.xlsx");
        int rows = config.getRowCount(0);
        Object[][]signin_credentials = new Object[rows][2];

        for(int i=0;i<rows;i++)
        {
            signin_credentials[i][0] = config.getData(0, i, 0);
            signin_credentials[i][1] = config.getData(0, i, 1);
        }
        return signin_credentials;
    }

    // @Test(dataProvider = "userCredential")
    @Test(dataProvider = "testdata")
    // Verify user is able to purchase product using registered email id
    public void UserShouldBeAbleToPurchaseProduct(String email, String password) {
        driver.get(prop.getProperty("homepage"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        AccountPage accountPage = loginPage.login(new Credential(email, password));
        Assert.assertEquals(driver.getTitle(), "My Account");
    }
}
