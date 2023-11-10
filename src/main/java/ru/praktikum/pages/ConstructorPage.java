package ru.praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage extends HomePage {

    private final By bunTitle = By.xpath("//div[span[text() = 'Булки']]");
    private final By sauceTitle = By.xpath("//div[span[text() = 'Соусы']]");
    private final By filingTitle = By.xpath("//div[span[text() = 'Начинки']]");
    private final By bunTab = By.xpath("//div[contains(@class, 'tab')]/span[text()='Булки']/..");
    private final By sauceTab = By.xpath("//div[contains(@class, 'tab')]/span[text()='Соусы']/..");
    private final By fillingTab = By.xpath("//div[contains(@class, 'tab')]/span[text()='Начинки']/..");


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
        tabWait(fillingTab);
        return driver.findElement(fillingTab).getAttribute("class").contains("tab_type_current");
    }

    public boolean sauceSectionIsActive() {
        tabWait(sauceTab);
        return driver.findElement(sauceTab).getAttribute("class").contains("tab_type_current");
    }

    public boolean bunSectionIsActive() {
        tabWait(bunTab);
        return driver.findElement(bunTab).getAttribute("class").contains("tab_type_current");
    }

    private void tabWait(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(locator, "class", "tab_type_current"));
    }

}
