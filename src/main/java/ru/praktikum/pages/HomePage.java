package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By accountButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX']/p[contains(text(),'Личный Кабинет')]");
    private final By enterButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By confirmButton = By.xpath("//button[text()='Оформить заказ']");
    private final By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click account button")
    public LoginPage clickAccountButton() {
        waitToBeClickable(accountButton);
        driver.findElement(accountButton).click();
        return new LoginPage(driver);
    }

    @Step("Click enter button")
    public LoginPage clickEnterButton() {
        waitToBeClickable(enterButton);
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }

    public boolean confirmButtonIsDisplayed() {
        return isDisplayed(confirmButton);
    }

    public void waitForLoad() {
        waitToBeVisible(burgerTitle);
    }

}
