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
import ru.praktikum.pages.RegistrationPage;

public class CreateUserTest extends BaseTest {

    private CreateUserDto userDto;
    private LoginUserDto loginUserDto;

    @Before
    public void startUp() {
        userDto = userData.getUserData();
        loginUserDto = userMapper.toLoginUserDto(userDto);
    }

    @After
    public void cleanUp() {
        userClient.deleteUser(loginUserDto);
    }

    @Test
    @DisplayName("Create a new user")
    @Description("Successful creation of a new user.")
    public void createUserTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickAccountButton();
        loginPage.waitForLoad();
        RegistrationPage registrationPage = loginPage.registrationLinkClick();
        registrationPage.waitForLoad();
        registrationPage.setName(userDto.getName());
        registrationPage.setEmail(userDto.getEmail());
        registrationPage.setPassword(userDto.getPassword());
        registrationPage.registrationButtonClick();
        Assert.assertNotNull(userClient.getToken(loginUserDto));
    }

    @Test
    @DisplayName("Create a new user with short password")
    @Description("It is not possible to create a user if the password length is less than 6 characters.")
    public void createUserWithShortPasswordTest() {
        userDto.setPassword(userData.getInvalidPassword());
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickAccountButton();
        loginPage.waitForLoad();
        RegistrationPage registrationPage = loginPage.registrationLinkClick();
        registrationPage.waitForLoad();
        registrationPage.setName(userDto.getName());
        registrationPage.setEmail(userDto.getEmail());
        registrationPage.setPassword(userDto.getPassword());
        registrationPage.registrationButtonClick();
        Assert.assertNull(userClient.getToken(loginUserDto));
    }


}
