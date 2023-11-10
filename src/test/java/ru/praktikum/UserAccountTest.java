package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.model.CreateUserDto;
import ru.praktikum.pages.AccountPage;
import ru.praktikum.pages.HomePage;
import ru.praktikum.pages.LoginPage;


import static ru.praktikum.Constants.*;

public class UserAccountTest extends BaseTest {

    private CreateUserDto userDto;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void startUp() {
        userDto = userData.getUserData();
        userClient.createUser(userDto);
        homePage = new HomePage(driver);
        loginPage = homePage.clickEnterButton();
        loginPage.waitForLoad();
        loginPage.setEmail(userDto.getEmail());
        loginPage.setPassword(userDto.getPassword());
        homePage = loginPage.loginButtonClick();
        homePage.waitForLoad();
    }

    @Test
    @DisplayName("Login to the personal account for an authorized user.")
    @Description("The authorized user, when clicking on the \"Personal Account\" button, will go to his personal account.")
    public void enterAccountTest() {
        homePage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForLoad();
        Assert.assertEquals(BASE_URL + ACCOUNT, accountPage.getUrl());
    }


    @Test
    @DisplayName("Go to the constructor page by clicking the Constructor button.")
    @Description("When clicking on the constructor button in the personal account, the user goes to the constructor.")
    public void enterToConstructorByConstructorButtonTest() {
        homePage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForLoad();
        accountPage.constructorButtonClick();
        homePage.waitForLoad();
        Assert.assertEquals(BASE_URL, accountPage.getUrl());
    }

    @Test
    @DisplayName("Go to the constructor page by clicking the logo.")
    @Description("When clicking on the logo in the personal account, the user goes to the constructor.")
    public void enterToConstructorByLogoClickTest() {
        homePage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForLoad();
        accountPage.logoClick();
        homePage.waitForLoad();
        Assert.assertEquals(BASE_URL, accountPage.getUrl());
    }


    @Test
    @DisplayName("Log out of user.")
    @Description("When user click on the Log Out button in the account, the user gets to the login page.")
    public void logOutTest() {
        homePage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.waitForLoad();
        loginPage = accountPage.exitButtonClick();
        loginPage.waitForLoad();
        Assert.assertEquals(BASE_URL + LOGIN, loginPage.getUrl());
    }


}
