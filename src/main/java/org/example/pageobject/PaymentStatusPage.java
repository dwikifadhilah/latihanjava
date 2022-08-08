package org.example.pageobject;

import org.example.helper.PaymentHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentStatusPage extends PaymentHelper {
    By paymentSuccess = By.xpath("//div[@class='text-headline medium']");
    By totalPaymentSuccess = By.xpath("//div[@class='text-headline large']");

    By paymentDenied = By.xpath("//div[@class='cancel-modal-title']");
    By notificationDenied = By.xpath("//div[@class='cancel-modal-title']/following-sibling::div");
    By okButtonDeniedPayment = By.xpath("//div[@class='cancel-modal-subtitle']/following-sibling::button");

    public PaymentStatusPage(WebDriver driver) {
        super(driver);
    }

    public void switchToPaymentFrame(){
        driver.switchTo().parentFrame();
    }
    public String getPaymentSuccess(){
        return driver.findElement(paymentSuccess).getText();
    }

    public  String getTotalPayment(){
        return driver.findElement(totalPaymentSuccess).getText();
    }
    public String getDeniedPayment(){
        return driver.findElement(paymentDenied).getText();
    }

    public  String getDeniedNotification(){
        return driver.findElement(notificationDenied).getText();
    }

    public void clickOkDeniedPayment(){
        driver.findElement(okButtonDeniedPayment).click();
    }

}
