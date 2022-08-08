package org.example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentHelper {
    protected WebDriver driver;

    public PaymentHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
}

