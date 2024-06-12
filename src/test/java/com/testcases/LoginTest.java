package com.testcases;

import com.common.BaseTest;
import com.dataprovider.DataProviderManager;
import com.pages.CommonPage;
import com.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test v1.0.0")
@Feature("Login Test")
public class LoginTest extends BaseTest {

    public LoginPage loginPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void loginTest() {
        loginPage = new LoginPage();
        commonPage = new CommonPage();
    }

    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testLoginFromDataProvider(String username, String password) {
        loginPage.logIn(username, password);
        commonPage.dangXuat();
    }

    @Test(priority = 2, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testLoginDataProviderFromExcelByRow(Hashtable<String, String> data) {
        loginPage.logIn(data.get("username"), data.get("password"));
        //commonPage.dangXuat();
    }

    @Test(priority = 4)
    public void testLoginWithUsernameInValid() {
        loginPage.loginWithUsernameInValid("admin_example_123", "123456");

    }

    @Test(priority = 5)
    public void testLoginWithPasswordInValid() {
        loginPage.loginWithPasswordInValid("admin_example", "123456789");

    }

}
