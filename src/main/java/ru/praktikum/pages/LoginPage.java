package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By emailField = By.xpath("//div[contains(label, 'Email')]/input[@type='text']");
    private final By passwordField = By.xpath("//div[contains(label, 'Пароль')]/input[@type='password' and @name='Пароль']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By registrationLink = By.xpath("//a[@href='/register' and contains(text(), 'Зарегистрироваться')]");
    private final By passwordRecoveryLink = By.xpath("//a[@href='/forgot-password' and contains(text(), 'Восстановить пароль')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        WebElement element = driver.findElement(emailField);
        element.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }

    @Step("Click login button")
    public HomePage loginButtonClick() {
        WebElement element = driver.findElement(loginButton);
        element.click();
        return new HomePage(driver);
    }

    @Step("Click registration link")
    public RegistrationPage registrationLinkClick() {
        waitToBeClickable(registrationLink);
        driver.findElement(registrationLink).click();
        return new RegistrationPage(driver);
    }

    @Step("Click recovery password link")
    public PasswordRecoveryPage recoveryPasswordLinkClick() {
        waitToBeClickable(passwordRecoveryLink);
        driver.findElement(passwordRecoveryLink).click();
        return new PasswordRecoveryPage(driver);
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
    }

}
