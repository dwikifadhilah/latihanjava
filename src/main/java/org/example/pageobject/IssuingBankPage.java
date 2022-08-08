package org.example.pageobject;

import org.example.helper.PaymentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuingBankPage extends PaymentHelper {
    By iframeIssuingBank = By.xpath("//iframe[@class='iframe-3ds']");
    By titleIssuingBank = By.xpath("//h1[@class='left']");
    By inputPassword = By.xpath("//input[@type='password']");
    By clickOk = By.xpath("//button[@name='ok']");


    public IssuingBankPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return driver.findElement(titleIssuingBank).isDisplayed();
    }

    public void switchToIssuingBankFrame(){
        driver.switchTo().frame(driver.findElement(iframeIssuingBank));
    }

    public void inputPassword(String password) {
        setText(inputPassword, password);
    }

    public void clickOk(){
        driver.findElement(clickOk).click();
    }
}
