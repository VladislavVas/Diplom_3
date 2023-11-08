package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.praktikum.Constants.BASE_URL;

public class AccountPage extends BasePage {

    private final By exitButton = By.xpath("//button[text() ='Выход']");
    private final By stellarLogo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    private final By constructorButton = By.xpath("//p[contains(@class, 'AppHeader_header__linkText__3q_va ml-2') and contains(text(), 'Конструктор')]");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on exit button")
    public LoginPage exitButtonClick() {
        driver.findElement(exitButton).click();
        return new LoginPage(driver);
    }

    @Step("Click on constructor button")
    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
        waitForUrl(BASE_URL);
    }

    @Step("Click on logo title")
    public void logoClick() {
        driver.findElement(stellarLogo).click();
        waitForUrl(BASE_URL);
    }

    public void waitForLoad() {
        waitToBeVisible(exitButton);
    }


}
