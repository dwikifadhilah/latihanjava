package org.example.pageobject;

import org.example.helper.PaymentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends PaymentHelper {
    By iframePayment = By.xpath("//iframe[@id='snap-midtrans']");

    By amount = By.xpath("//div[@class='header-amount']");
    By itemName = By.xpath("//span[@class='quantity']/following-sibling::span");
    By name = By.xpath("//div[@class='order-summary-subheader']");
    By address = By.xpath("//div[@class='order-summary-content']");
    By phoneNumber = By.xpath("//div[@class='order-summary-bold']");

    By clickOrderDetails = By.xpath("//div[@class='header-order-id']");
    By clickCreditCard = By.xpath("//div[@class='page-container scroll']/a[1][@class='list']");
    By clickGopay = By.xpath("//div[@class='page-container scroll']/a[3][@class='list']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe(){
        driver.switchTo().frame(driver.findElement(iframePayment));
    }

    public String getAmount(){
        return driver.findElement(amount).getText();
    }

    public String getItemName(){
        return driver.findElement(itemName).getText();
    }

    public String getName(){
        return driver.findElement(name).getText();
    }

    public String getAddress(){
        return driver.findElement(address).getText();
    }

    public String getPhoneNumber(){
        return  driver.findElement(phoneNumber).getText();
    }

    public void clickOrderDetails(){
        driver.findElement(clickOrderDetails).click();
    }

    public void clickCreditCard(){
        driver.findElement(clickCreditCard).click();
    }
}