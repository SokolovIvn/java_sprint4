package ru.testsamokat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SeleniumSamokatOrderTest extends Basetest {

    private final int element;

    public SeleniumSamokatOrderTest(int element) {
        this.element = element;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1}
        };
    }


    @Test
    public void testOrderSamokatWithHeader() throws InterruptedException {

        pages.clickOrderButton(element);
        pages.setMetro();
        pages.fillFirstName("тутМогла");
        pages.fillSecondName("БытьВаша");
        pages.fillAddress("1-ая Реклама");
        pages.fillPhoneNumber("+7911111111");
        pages.clickNextButton();
        pages.setDateCalendar();
        pages.setTimeForUse();
        pages.selectColourBlack();
        pages.clickOnDoOrder();
        pages.clickOnYesButton();
        Assert.assertTrue(pages.getTextAfterOrder());

    }

}
