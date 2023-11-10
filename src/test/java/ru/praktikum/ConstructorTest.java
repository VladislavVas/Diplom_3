package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.pages.ConstructorPage;

public class ConstructorTest extends BaseTest {

    private ConstructorPage constructorPage;

    @Before
    public void startUp() {
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    @DisplayName("Transition to the section with sauces.")
    @Description("When you click on the section with sauces, the sauces should be displayed.")
    public void activeSauceSectionTest() {
        constructorPage.sauceClick();
        Assert.assertTrue(constructorPage.sauceSectionIsActive());
    }

    @Test
    @DisplayName("Transition to the section with fillings")
    @Description("When you click on the section with fillings, the fillings should be displayed.")
    public void activeFillingSectionTest() {
        constructorPage.filingClick();
        Assert.assertTrue(constructorPage.filingSectionIsActive());
    }

    @Test
    @DisplayName("Transition to the section with buns.")
    @Description("When you click on the section with buns, the buns should be displayed.")
    public void activeBunSectionTest() {
        constructorPage.filingClick();
        constructorPage.bunClick();
        Assert.assertTrue(constructorPage.bunSectionIsActive());
    }

}
