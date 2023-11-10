package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.model.CreateUserDto;
import ru.praktikum.model.LoginUserDto;
import ru.praktikum.pages.HomePage;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.PasswordRecoveryPage;
import ru.praktikum.pages.RegistrationPage;


public class LoginUserTest extends BaseTest {

    private CreateUserDto userDto;
    private LoginUserDto loginUserDto;

    @Before
    public void startUp() {
        userDto = userData.getUserData();
        loginUserDto = userMapper.toLoginUserDto(userDto);
        userClient.createUser(userDto);
    }

    @After
    public void cleanUp() {
        userClient.deleteUser(loginUserDto);
    }

    @Test
    @DisplayName("Log in to account from the main page.")
    @Description("The user successfully logs into the account by clicking the enter button on the main page.")
    public void userLogInByEnterButtonTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickEnterButton();
        loginPage.waitForLoad();
        loginPage.setEmail(loginUserDto.getEmail());
        loginPage.setPassword(loginUserDto.getPassword());
        homePage = loginPage.loginButtonClick();
        homePage.waitForLoad();
        Assert.assertTrue(homePage.confirmButtonIsDisplayed());
    }

    @Test
    @DisplayName("Log in to account from the main page.")
    @Description("The user successfully logs into the account by clicking the account button on the main page.")
    public void userLogInByAccountButtonTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickAccountButton();
        loginPage.waitForLoad();
        loginPage.setEmail(loginUserDto.getEmail());
        loginPage.setPassword(loginUserDto.getPassword());
        homePage = loginPage.loginButtonClick();
        homePage.waitForLoad();
        Assert.assertTrue(homePage.confirmButtonIsDisplayed());
    }

    @Test
    @DisplayName("Log in to account from the registration page.")
    @Description("The user successfully logs into the account by clicking link on the registration page.")
    public void userLogInByEnterLinkOnRegistrationPageTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage= homePage.clickAccountButton();
        RegistrationPage registrationPage = loginPage.registrationLinkClick();
        loginPage = registrationPage.enterLinkClick();
        loginPage.setEmail(loginUserDto.getEmail());
        loginPage.setPassword(loginUserDto.getPassword());
        homePage = loginPage.loginButtonClick();
        homePage.waitForLoad();
        Assert.assertTrue(homePage.confirmButtonIsDisplayed());
    }

    @Test
    @DisplayName("Log in to account from the recovery password page.")
    @Description("The user successfully logs into the account by clicking link on the recovery password page.")
    public void userLogInByRecoveryPasswordPageTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage= homePage.clickAccountButton();
        PasswordRecoveryPage passwordRecoveryPage = loginPage.recoveryPasswordLinkClick();
        passwordRecoveryPage.waitForLoad();
        loginPage = passwordRecoveryPage.enterButtonClick();
        loginPage.setEmail(loginUserDto.getEmail());
        loginPage.setPassword(loginUserDto.getPassword());
        homePage = loginPage.loginButtonClick();
        homePage.waitForLoad();
        Assert.assertTrue(homePage.confirmButtonIsDisplayed());
    }

}
