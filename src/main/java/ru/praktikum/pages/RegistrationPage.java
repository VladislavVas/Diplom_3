package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage{

    private final By nameField = By.xpath("//div[contains(label, 'Имя')]/input[@name='name']");
    private final By emailField = By.xpath("//div[contains(label, 'Email')]/input[@type='text']");
    private final By passwordField = By.xpath("//div[contains(label, 'Пароль')]/input[@type='password' and @name='Пароль']");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By enterLink = By.xpath("//a[@href='/login']");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        WebElement element = driver.findElement(nameField);
        element.click();
        element.sendKeys(name);
    }

    public void setEmail(String email) {
        WebElement element = driver.findElement(emailField);
        element.click();
        element.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.click();
        element.clear();
        element.sendKeys(password);
    }

    public void registrationButtonClick() {
        WebElement element = driver.findElement(registrationButton);
        element.click();
    }

    @Step("Click enter link")
    public LoginPage enterLinkClick() {
        WebElement element = driver.findElement(enterLink);
        element.click();
        return new LoginPage(driver);
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(registrationButton)));
    }

}
