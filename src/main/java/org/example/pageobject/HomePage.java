package org.example.pageobject;

import org.example.helper.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumHelper {
    By title = By.xpath("//div[@class='title']");
    By buttonBuyNow = By.xpath("//a[@class='btn buy']");
    By notification = By.xpath("//span[@data-reactid='.0.0.0.2.0.1.0.0:0']");

    //Form Shopping Cart
    By inputAmount = By.xpath("//input[@class='text-right']");
    By inputName = By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.0.1.0']");
    By inputEmail = By.xpath("//input[@type='email']");
    By inputPhoneNumber = By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.2.1.0']");
    By inputCity = By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.3.1.0']");
    By inputAddress = By.xpath("//textarea[@data-reactid='.0.0.1.0.3.0.0.4.1.0']");
    By inputPostalCode = By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.5.1.0']");
    By buttonCheckOut = By.xpath("//div[@class='cart-checkout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return driver.findElement(title).isDisplayed();
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public void clickBuyNow(){
        driver.findElement(buttonBuyNow).click();
    }

    public void fillFormCheckOut(String amount, String name, String email,
                                 String phoneNumber, String city,
                                 String address, String postalCode){

        setText(inputAmount, amount);
        setText(inputName, name);
        setText(inputEmail, email);
        setText(inputPhoneNumber, phoneNumber);
        setText(inputCity, city);
        setText(inputAddress, address);
        setText(inputPostalCode, postalCode);
        driver.findElement(buttonCheckOut).click();
    }

    public String getNotification(){
        return driver.findElement(notification).getText();
    }
}
