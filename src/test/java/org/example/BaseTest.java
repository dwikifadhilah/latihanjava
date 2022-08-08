package org.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openWebBrowser(){
        System.setProperty("webdriver.gecko.driver", "D:\\Aplikasi\\Web Driver\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://demo.midtrans.com/#");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @After
    public void closeWebBrowser(){
        driver.quit();
    }
}

