package org.example;

import org.example.pageobject.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumTest extends BaseTest {

    @Test
    public void validPaymentMidTrans(){

        String amount = "Rp120.000";
        String name = "dwiki fadhilah";
        String email = "asdfgh@gmail.com";
        String phoneNumber = "081234567890";
        String city = "Lampung";
        String address = "Pesawaran";
        String postalCode = "12345";

        // This code is used to check the title of the home page, click the buy now button, and fill the form checkout.
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());
        String expectedHomeTitle = "Midtrans Pillow";
        Assert.assertEquals(expectedHomeTitle, homePage.getTitle());
        homePage.clickBuyNow();
        homePage.fillFormCheckOut(amount.replace("Rp","").replace(".",""),
                name, email, phoneNumber, city, address, postalCode);

        // This code is used to switch to the payment frame, check the amount, item name, name, address, and phone number,
        //         and click the credit card button.
        PaymentPage payment = new PaymentPage(driver);
        payment.switchToIframe();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[@class='header-order-id']")));
        payment.clickOrderDetails();
        Assert.assertEquals(amount, payment.getAmount());
        Assert.assertEquals(expectedHomeTitle, payment.getItemName());
        Assert.assertEquals(name, payment.getName());
        Assert.assertEquals(address + " " + city + " " + postalCode, payment.getAddress());
        Assert.assertEquals(phoneNumber.replaceFirst("0", "+62"), payment.getPhoneNumber());
        payment.clickOrderDetails();
        payment.clickCreditCard();

        // This code is used to switch to the credit card frame, check the title, input the credit card number,
        //         expiration date, and cvv, and click the promo button.
        CreditCardPage creditCard = new CreditCardPage(driver);
        Assert.assertEquals("Credit/debit card", creditCard.getTitle());
        creditCard.inputCreditCard("4811111111111114", "0125", "123");
        creditCard.clickPromo();

        // This code is used to calculate the total amount after discount.
        int calculateDiscount = Integer.parseInt(creditCard.getPromo().replace
                ("-","").replace("Rp","").replace(".",""));
        int calculateAmount = Integer.parseInt(amount.replace("Rp","").replace(".",""));
        int total = calculateAmount - calculateDiscount;
        String totalAfterDiscount = Integer.toString(total);
        Assert.assertEquals(totalAfterDiscount, creditCard.getAmountAfterPromo().replace
                ("Rp","").replace(".",""));
        creditCard.clickPayNow();

        // This code is used to switch to the issuing bank frame and input the password.
        IssuingBankPage issuingBankPage = new IssuingBankPage(driver);
        issuingBankPage.switchToIssuingBankFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        Assert.assertTrue(issuingBankPage.isDisplayed());
        issuingBankPage.inputPassword("112233");
        issuingBankPage.clickOk();

        // This code is used to switch to the payment frame and check the payment status and the total amount.
        PaymentStatusPage paymentSuccess = new PaymentStatusPage(driver);
        paymentSuccess.switchToPaymentFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='text-headline medium']")));
        Assert.assertEquals("Payment successful", paymentSuccess.getPaymentSuccess());
        Assert.assertEquals(totalAfterDiscount, paymentSuccess.getTotalPayment().replace
                ("Rp","").replace(".",""));

        // This code is used to switch back to the default frame and check the notification.
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@data-reactid='.0.0.0.2.0.1.0.0:0']")));
        Assert.assertEquals("Thank you for your purchase.", homePage.getNotification());
    }

    @Test
    public void deniedPaymentTestMidTrans(){

        String amount = "Rp120.000";
        String name = "dwiki fadhilah";
        String email = "asdfgh@gmail.com";
        String phoneNumber = "081234567890";
        String city = "Lampung";
        String address = "Pesawaran";
        String postalCode = "12345";

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());
        String expectedHomeTitle = "Midtrans Pillow";
        Assert.assertEquals(expectedHomeTitle, homePage.getTitle());
        homePage.clickBuyNow();
        homePage.fillFormCheckOut(amount.replace("Rp","").replace(".",""),
                name, email, phoneNumber, city, address, postalCode);

        PaymentPage payment = new PaymentPage(driver);
        payment.switchToIframe();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[@class='header-order-id']")));
        payment.clickOrderDetails();
        Assert.assertEquals(amount, payment.getAmount());
        Assert.assertEquals(expectedHomeTitle, payment.getItemName());
        Assert.assertEquals(name, payment.getName());
        Assert.assertEquals(address + " " + city + " " + postalCode, payment.getAddress());
        Assert.assertEquals(phoneNumber.replaceFirst("0", "+62"), payment.getPhoneNumber());
        payment.clickOrderDetails();
        payment.clickCreditCard();

        CreditCardPage creditCard = new CreditCardPage(driver);
        Assert.assertEquals("Credit/debit card", creditCard.getTitle());
        creditCard.inputCreditCard("4911111111111113", "0125", "123");
        creditCard.clickPromo();

        int calculateDiscount = Integer.parseInt(creditCard.getPromo().replace
                ("-","").replace("Rp","").replace(".",""));
        int calculateAmount = Integer.parseInt(amount.replace("Rp","").replace(".",""));
        int total = calculateAmount - calculateDiscount;
        String totalAfterDiscount = Integer.toString(total);
        Assert.assertEquals(totalAfterDiscount, creditCard.getAmountAfterPromo().replace
                ("Rp","").replace(".",""));
        creditCard.clickPayNow();

        IssuingBankPage issuingBankPage = new IssuingBankPage(driver);
        issuingBankPage.switchToIssuingBankFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        Assert.assertTrue(issuingBankPage.isDisplayed());
        issuingBankPage.inputPassword("112233");
        issuingBankPage.clickOk();

        PaymentStatusPage paymentDenied = new PaymentStatusPage(driver);
        paymentDenied.switchToPaymentFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@class='cancel-modal-title']")));
        Assert.assertEquals("Card declined by bank", paymentDenied.getDeniedPayment());
        Assert.assertEquals("Failed to process payment. Please place your order again.",
                paymentDenied.getDeniedNotification());
        paymentDenied.clickOkDeniedPayment();

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//span[@data-reactid='.0.0.0.2.0.1.0.0:0']")));
        Assert.assertEquals("Sorry, something went wrong.", homePage.getNotification());
    }

}
