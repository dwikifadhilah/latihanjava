package org.example.pageobject;

import org.example.helper.PaymentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditCardPage extends PaymentHelper {

    By inputCardNumber = By.xpath("//input[@type='tel']");
    By inputCardExpiry = By.id("card-expiry");
    By inputCardCvv = By.id("card-cvv");

    By titleText = By.xpath("//span[@class='title-text text-actionable-bold']");
    By amountAfterPromo = By.xpath("//div[@class='header-amount']");
    By discountAmount = By.xpath("//div[@class='asphalt-theme-a6420f20']/following-sibling::" +
            "span[.='-Rp10']");

    By clickPromo = By.xpath("//label[@for='285']");

    By clickPayNow = By.xpath("//button[@class='btn full primary']");

    public CreditCardPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return driver.findElement(titleText).getText();
    }

    public void inputCreditCard(String cardNumber, String expiry, String cvv){
        setText(inputCardNumber, cardNumber);
        setText(inputCardExpiry, expiry);
        setText(inputCardCvv, cvv);
    }

    public void clickPromo(){
        driver.findElement(clickPromo).click();
    }

    public String getPromo() {
        return driver.findElement(discountAmount).getText();
    }

    public String getAmountAfterPromo() {
        return driver.findElement(amountAfterPromo).getText();
    }

    public void clickPayNow(){
        driver.findElement(clickPayNow).click();
    }
}
