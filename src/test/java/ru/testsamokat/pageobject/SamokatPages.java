package ru.testsamokat.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;

public class SamokatPages {
    WebDriver driver;

    public SamokatPages(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка заказа в шапке
    private By orderHeaderButton = By.xpath("Button_Button__ra12g");

    private By orderButtons = By.xpath("//button[contains(text(),'Заказать')]");

    // поле имени
    private By fieldInputName = By.xpath(".//input[@placeholder='* Имя']");

    // селект меню станция метро
    private By selectMenuMetro = By.xpath(".//input[@placeholder='* Станция метро']");

    // элементы списка метро
    private By elementsOfListMetro = By.xpath(".//li/button[contains(@class,'select-search__option')]");

    // поле фамилия
    private By fieldSecondName = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле адреса
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле телефон
    private By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка далее
    private By buttonNext = By.xpath(".//button[text()='Далее']");

    // поле Когда привезти самокат
    private By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле с выбором срока аренды
    private By timeUse = By.xpath(".//div[@class='Dropdown-placeholder']");

    // список с выбором срока аренды
    private By timeUseList = By.xpath(".//div[@class='Dropdown-option']");

    // черный цвет самоката
    private By checkBoxColourBlack = By.xpath(".//input[@id='black']");

    // кнопка заказать по середине страницы
    private By buttonDoOrder = By.xpath(".//button[text()='Заказать' and contains(@class, 'Middle')]");

    // кнопка Да
    private By buttonYes = By.xpath(".//button[text()='Да']");

    // текст заказа
    private By textOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public boolean getTextAfterOrder() {
        WebElement driver1 = driver.findElement(textOrder);
        driver1.getText();
        return driver1.getText().contains("Заказ оформлен");

    }

    public void clickOnYesButton() {
        driver.findElement(buttonYes).click();
    }

    public void clickOnDoOrder() {
        driver.findElement(buttonDoOrder).click();
    }

    public void selectColourBlack() {
        driver.findElement(checkBoxColourBlack).click();
    }

    public void setTimeForUse() {
        driver.findElement(timeUse).click();
        driver.findElements(timeUseList).get(0).click();
    }

    public void setDateCalendar() {
        int cal = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(cal);
        driver.findElement(calendar).click();
        driver.findElement(By.xpath(".//div[contains(@class,'react-datepicker__day') and text()='" + date + "']")).click();
    }

    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(orderHeaderButton).click();
    }

    public void clickOrderButton(int elem) {
        WebElement element =driver.findElements(orderButtons).get(elem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void fillSecondName(String secondName) {
        driver.findElement(fieldSecondName).sendKeys(secondName);
    }

    public void fillFirstName(String name) {
        driver.findElement(fieldInputName).sendKeys(name);
    }

    public void fillAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    public void fillPhoneNumber(String number) {
        driver.findElement(fieldPhoneNumber).sendKeys(number);
    }

    public void setMetro() {
        driver.findElement(selectMenuMetro).click();
        driver.findElements(elementsOfListMetro).get(0).click();
    }

    public void scrollAndClick(String nameElement) {
        WebElement element = driver.findElement(By.xpath("//div[text()='" + nameElement + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    public void checkElementOfListAccordion(String text) {
        List<WebElement> element = driver.findElements(By.xpath("//div[not (@hidden)]/p[text()='" + text + "']"));
        Assert.assertEquals(1, element.size());
    }
}
