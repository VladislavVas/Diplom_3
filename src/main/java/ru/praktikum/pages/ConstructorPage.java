package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends HomePage {

    private final By bunTitle = By.xpath("//div[span[text() = 'Булки']]");
    private final By firstBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    protected final By sauceTitle = By.xpath("//div[span[text() = 'Соусы']]");
    private final By firstSauce = By.xpath("//img[@alt='Соус Spicy-X']");
    private final By filingTitle = By.xpath("//div[span[text() = 'Начинки']]");
    private final By firstFilling = By.xpath("//img[@alt='Мясо бессмертных моллюсков Protostomia']");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on sauce title")
    public void sauceClick() {
        driver.findElement(sauceTitle).click();
    }

    @Step("Click on bun title")
    public void bunClick() {
        driver.findElement(bunTitle).click();
    }

    @Step("Click on filling title")
    public void filingClick() {
        driver.findElement(filingTitle).click();
    }

    public boolean filingSectionIsActive() {
        return isDisplayed(firstFilling);
    }

    public boolean sauceSectionIsActive() {
        return isDisplayed(firstSauce);
    }

    public boolean bunSectionIsActive() {
        return isDisplayed(firstBun);
    }


}
