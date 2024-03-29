package ru.testsamokat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.testsamokat.pageobject.SamokatPages;

import java.util.concurrent.TimeUnit;

import static ru.testsamokat.config.ConfigSamokat.MAIN_URL;

@RunWith(Parameterized.class)
public class SeleniumSamokataccordionTest {
    private final String namePoint;
    private final String expectText;
    private static WebDriver driver;
    static SamokatPages pages;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        pages = new SamokatPages(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(MAIN_URL);
    }


    public SeleniumSamokataccordionTest(String namePoint, String expectText) {
        this.namePoint = namePoint;
        this.expectText = expectText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."}, {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}, {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}, {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}, {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."}, {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."}, {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}, {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}};
    }

    @Test
    public void checkAccodrion() {

        pages.scrollAndClick(namePoint);
        pages.checkElementOfListAccordion(expectText);
    }

    @AfterClass
    public static void ttt() {
        driver.quit();
    }
}
