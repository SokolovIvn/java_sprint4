package ru.testsamokat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.testsamokat.pageobject.SamokatPages;

import java.util.concurrent.TimeUnit;

import static ru.testsamokat.config.ConfigSamokat.MAIN_URL;

public class Basetest {

    WebDriver driver;
    SamokatPages pages;

    @Before
    public void setupTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        pages = new SamokatPages(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
