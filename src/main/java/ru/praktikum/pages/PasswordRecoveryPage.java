package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage {

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    private final By enterButton = By.xpath("//a[@href='/login']");
    private final By recoveryTitle = By.xpath("//h2[text()='Восстановление пароля']");

    @Step("Enter button click")
    public LoginPage enterButtonClick() {
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }

    public void waitForLoad() {
        waitToBeVisible(recoveryTitle);
    }

}